package gui.acheteur;

import config.DatabaseConnection;
import dao.AnnonceDAO;
import model.Annonce;
import service.ServiceVente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AcheteurFrame extends JFrame {

    private int idAcheteur = 2;

    private JTable tableAnnonces;
    private DefaultTableModel modelAnnonces;
    private JTextField fieldMontant;
    private JLabel labelStatut;

    private ServiceVente serviceVente = new ServiceVente();

    public AcheteurFrame(int idAcheteur) {
        super("Interface Acheteur");
        this.idAcheteur = idAcheteur;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        JPanel panelAnnonces = new JPanel(new BorderLayout());
        panelAnnonces.setBorder(BorderFactory.createTitledBorder("Annonces disponibles"));

        modelAnnonces = new DefaultTableModel(
                new String[]{"ID", "Produit", "Prix souhaite", "Categorie"}, 0);
        tableAnnonces = new JTable(modelAnnonces);

        Button btnRefresh = new Button("Refresh");
        panelAnnonces.add(new JScrollPane(tableAnnonces), BorderLayout.CENTER);
        panelAnnonces.add(btnRefresh, BorderLayout.SOUTH);

        c.gridx = 0; c.gridy = 0; c.weightx = 1; c.weighty = 0.7;
        add(panelAnnonces, c);


        JPanel panelProposition = new JPanel(new GridBagLayout());
        panelProposition.setBorder(BorderFactory.createTitledBorder("Faire une proposition"));
        GridBagConstraints cp = new GridBagConstraints();
        cp.fill = GridBagConstraints.HORIZONTAL;
        cp.insets = new Insets(5, 5, 5, 5);

        fieldMontant = new JTextField(15);
        labelStatut = new JLabel("");
        JButton btnSoumettre = new JButton("Soumettre proposition");

        cp.gridx = 0; cp.gridy = 0;
        panelProposition.add(new JLabel("Votre proposition :"), cp);
        cp.gridx = 1;
        panelProposition.add(fieldMontant, cp);

        cp.gridx = 1; cp.gridy = 1;
        panelProposition.add(labelStatut, cp);

        cp.gridx = 1; cp.gridy = 2;
        panelProposition.add(btnSoumettre, cp);

        c.gridx = 0; c.gridy = 1; c.weightx = 1; c.weighty = 0.3;
        add(panelProposition, c);


        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshAnnonces();
            }
        });

        btnSoumettre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                soumettreProposition();
            }
        });

        refreshAnnonces();
        setVisible(true);
    }

    private void refreshAnnonces() {
        modelAnnonces.setRowCount(0);
        String query = "SELECT a.id_annonce, p.title, a.proposed_price, c.nom " + "FROM annonce a " +"JOIN product p ON a.id_product = p.id_product " + "JOIN categorie c ON p.id_category = c.id_category " + "WHERE a.statut = 'publiee'";
        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_annonce");
                String title = rs.getString("title");
                double prix = rs.getDouble("proposed_price");
                String categorie = rs.getString("nom");
                modelAnnonces.addRow(new Object[]{id, title, prix, categorie});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void soumettreProposition() {
        int row = tableAnnonces.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selectionnez une annonce");
            return;
        }
        String montantStr = fieldMontant.getText().trim();
        if (montantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Entrez un montant");
            return;
        }
        int idAnnonce = (int) modelAnnonces.getValueAt(row, 0);
        double montant = Double.parseDouble(montantStr);
        boolean venteConclue = serviceVente.soumettreProposition(montant, idAnnonce, idAcheteur);
        if (venteConclue) {
            labelStatut.setText("Vente conclue !");
            labelStatut.setForeground(Color.GREEN);
            JOptionPane.showMessageDialog(this, " Vente a " + montant + "$");
            refreshAnnonces();
        } else {
            labelStatut.setText("Proposition soumise, en attente.");
            labelStatut.setForeground(Color.ORANGE);
            JOptionPane.showMessageDialog(this, "Proposition soumise montant insuffisant.");
        }
        fieldMontant.setText("");
    }
}
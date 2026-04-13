package gui;

import gui.acheteur.AcheteurFrame;
import gui.annonceur.AnnonceurFrame;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    public Home() {
        super("home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JButton btnAnnonceur = new JButton("Annonceur");
        JButton btnAcheteur = new JButton("Acheteur");

        add(btnAnnonceur);
        add(btnAcheteur);

        btnAnnonceur.addActionListener(e -> { dispose(); new AnnonceurFrame(1); });
        btnAcheteur.addActionListener(e -> { dispose(); new AcheteurFrame(2); });

        setVisible(true);
    }
}
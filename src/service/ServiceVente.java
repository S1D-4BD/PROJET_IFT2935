package service;

import dao.AnnonceDAO;
import dao.EstimationDAO;
import dao.PropositionDAO;
import dao.VenteDAO;
import model.Estimation;
import model.Proposition;

public class ServiceVente {

    ///e but de service vente est de verifier si, lorsque
    ///  l'acheteur va cliquer sur soumettre une proposition dans l'interface
    ///  la vue appelle soumettreProposition(), en MVC c est l'equivalent du controller
    ///
    ///
    private AnnonceDAO annonceDAO = new AnnonceDAO(); // va ns permettre de ask la table annonce
    private EstimationDAO estimationDAO = new EstimationDAO();  // va ns permettre de ask la table estimations
    private PropositionDAO propositionDAO = new PropositionDAO(); //bref anyways
    private VenteDAO venteDAO = new VenteDAO();

    public boolean soumettreProposition(double montant, int idAnnonce, int idAcheteur) {  // le but est juste de return true ou false en fct de si la vente a ete conclue
        propositionDAO.insertProposition(montant, idAnnonce, idAcheteur); //on insere la proposition dans la table de propositions (ds le modele on a specifie que pour chaqun on genere un id serialise et LUI on doit le recup pour travailler
        Proposition proposition = propositionDAO.getLastPropositionByAnnonce(idAnnonce); // la quon a insert une proposition, elle a donc un id quon peut utiliser pr la recuperer via d autres tables
        Estimation estimation = estimationDAO.getEstimationAccepteeByAnnonce(idAnnonce); // on regarde l estimation acceptee pour l annonce (et la on use le id serialisee davant)
        //en gros on va chercher l'estimation que l'annonceur a agree on pour cette annonce
        // cv etre elle qui contient le seuil pour quune vente soit effectuee
        if (estimation != null && proposition != null) { // tatn que c est pas nul
            if (proposition.getMontant() >= estimation.getMontant()) {
                venteDAO.insertVente(proposition.getMontant(), proposition.getIdProposition());
                propositionDAO.updateStatut(proposition.getIdProposition(), "acceptee");
                annonceDAO.updateStatut(idAnnonce, "vendue");
                System.out.println("vnte");

                return true;
            }
        }
        return false;
    }
}
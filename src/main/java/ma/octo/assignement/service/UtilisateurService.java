package ma.octo.assignement.Utilisateur;

import ma.octo.assignement.dto.UtilisateurDTO;
import ma.octo.assignement.exceptions.UtilisateurNonExistant;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDTO ajouterUtilisateur(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO getUtilisateur(Long idUtilisateur) throws UtilisateurNonExistant;

    List<UtilisateurDTO> getAllUtilisateurs();

    void supprimerUtilisateur(Long idUtilisateur) throws UtilisateurNonExistant;

}

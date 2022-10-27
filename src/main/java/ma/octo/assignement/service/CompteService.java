package ma.octo.assignement.Compte;

import ma.octo.assignement.dto.CompteDTO;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.UtilisateurNonExistant;

import java.util.List;

public interface CompteService {

    CompteDTO ajouterCompte(Long idUtilisateur,CompteDTO compteDTO) throws UtilisateurNonExistant;

    CompteDTO supprimerCompte(Long compteId) throws CompteNonExistantException;

    CompteDTO getCompte(Long compteId) throws CompteNonExistantException;

    List<CompteDTO> getAllComptes();

}

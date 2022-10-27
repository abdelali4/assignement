package ma.octo.assignement.Compte;


import ma.octo.assignement.dto.CompteDTO;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.Utilisateur.UtilisateurRepository;
import ma.octo.assignement.exceptions.UtilisateurNonExistant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompteServiceImp implements CompteService {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public CompteDTO ajouterCompte(Long idUtilisateur,CompteDTO compteDTO) throws UtilisateurNonExistant {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                                                        .orElseThrow(()-> new UtilisateurNonExistant());
        Compte compte = modelMapper.map(compteDTO,Compte.class);
        compte.setUtilisateur(utilisateur);
        compte = compteRepository.save(compte);
        return modelMapper.map(compte,CompteDTO.class);
    }

    @Override
    public CompteDTO supprimerCompte(Long idCompte) throws CompteNonExistantException {
        Compte compte = compteRepository.findById(idCompte)
                                        .orElseThrow(()->new CompteNonExistantException());
        compteRepository.deleteById(idCompte);
        return null;
    }

    @Override
    public CompteDTO getCompte(Long idCompte) throws CompteNonExistantException {
        Compte compte = compteRepository.findById(idCompte)
                                        .orElseThrow(()->new CompteNonExistantException());

        return modelMapper.map(compte, CompteDTO.class);
    }

    @Override
    public List<CompteDTO> getAllComptes() {
        List<Compte> comptes = compteRepository.findAll();
        return comptes.stream().map(compte->modelMapper.map(compte, CompteDTO.class))
                                .collect(Collectors.toList());

    }
}

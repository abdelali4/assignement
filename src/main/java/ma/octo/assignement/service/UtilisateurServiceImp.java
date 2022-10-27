package ma.octo.assignement.Utilisateur;

import ma.octo.assignement.dto.UtilisateurDTO;
import ma.octo.assignement.exceptions.UtilisateurNonExistant;
import ma.octo.assignement.domain.Utilisateur;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UtilisateurServiceImp implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UtilisateurDTO ajouterUtilisateur(UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = modelMapper.map(utilisateurDTO, Utilisateur.class);
        utilisateur = utilisateurRepository.save(utilisateur);
        return modelMapper.map(utilisateur,UtilisateurDTO.class);

    }

    @Override
    public void supprimerUtilisateur(Long idUtilisateur) throws UtilisateurNonExistant {

        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(()->new UtilisateurNonExistant());
        utilisateurRepository.deleteById(idUtilisateur);

    }

    @Override
    public UtilisateurDTO getUtilisateur(Long idUtilisateur) throws UtilisateurNonExistant {

        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(()->new UtilisateurNonExistant());

        return modelMapper.map(utilisateur, UtilisateurDTO.class);

    }

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().map(utilisateur->modelMapper.map(utilisateur, UtilisateurDTO.class))
                .collect(Collectors.toList());
    }
}

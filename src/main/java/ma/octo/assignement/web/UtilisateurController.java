package ma.octo.assignement.Utilisateur;


import ma.octo.assignement.service.CompteService;
import ma.octo.assignement.dto.CompteDTO;
import ma.octo.assignement.dto.UtilisateurDTO;
import ma.octo.assignement.exceptions.UtilisateurNonExistant;
import ma.octo.assignement.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private CompteService  compteService;

    @GetMapping("")
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs(){

        List<UtilisateurDTO> response =  utilisateurService.getAllUtilisateurs();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{idUtilisateur}")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable Long idUtilisateur)
            throws UtilisateurNonExistant {

        UtilisateurDTO response =  utilisateurService.getUtilisateur(idUtilisateur);
        return new ResponseEntity<>(response, HttpStatus.FOUND);

    }

    @PostMapping("/add")
    public ResponseEntity<UtilisateurDTO> ajouterUtilisateur(@RequestBody @Valid UtilisateurDTO utilisateurDTO) {

        UtilisateurDTO response =  utilisateurService.ajouterUtilisateur(utilisateurDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{idUtilisateur}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimerUtilisateur(@PathVariable Long idUtilisateur) throws UtilisateurNonExistant {

        utilisateurService.supprimerUtilisateur(idUtilisateur);

    }

    @PostMapping("/{idUtilisateur}/addCompte")
    public ResponseEntity<CompteDTO> ajouterCompte(@PathVariable Long idUtilisateur,
                                   @RequestBody @Valid CompteDTO compteDTO) throws UtilisateurNonExistant {

        CompteDTO response = compteService.ajouterCompte(idUtilisateur,compteDTO);

        return new ResponseEntity<>( response , HttpStatus.CREATED);

    }

}

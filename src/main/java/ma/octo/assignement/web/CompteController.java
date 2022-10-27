package ma.octo.assignement.Compte;


import ma.octo.assignement.dto.CompteDTO;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping("")
    public ResponseEntity<List<CompteDTO>> getAllComptes(){
        List<CompteDTO> response =  compteService.getAllComptes();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{idCompte}")
    public ResponseEntity<CompteDTO> getCompte(@PathVariable Long idCompte) throws CompteNonExistantException {
        CompteDTO response =  compteService.getCompte(idCompte);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{idCompte}")
    @ResponseStatus(HttpStatus.OK)
    public void supprimerCompte(@PathVariable Long idCompte) throws CompteNonExistantException {
        CompteDTO response =  compteService.supprimerCompte(idCompte);
    }

}

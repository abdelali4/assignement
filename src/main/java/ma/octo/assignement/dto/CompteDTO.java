package ma.octo.assignement.Compte.utilis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.octo.assignement.domain.Utilisateur;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CompteDTO {

    private Long id;

    @Length(min = 16,max=16)
    private String nrCompte;

    private String rib;

    private BigDecimal solde;

    private Utilisateur utilisateur;

}

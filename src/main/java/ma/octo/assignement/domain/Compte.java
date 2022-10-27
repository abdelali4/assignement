package ma.octo.assignement.Compte;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.octo.assignement.Utilisateur.Utilisateur;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "COMPTE")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 16, unique = true)
    private String nrCompte;

    private String rib;

    @Column(precision = 16, scale = 2)
    private BigDecimal solde;

    @ManyToOne()
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}
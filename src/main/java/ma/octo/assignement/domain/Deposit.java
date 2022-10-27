package ma.octo.assignement.Operations.Deposit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.octo.assignement.domain.Compte;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Data
@AllArgsConstructor @NoArgsConstructor
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(precision = 16, scale = 2, nullable = false)
    private BigDecimal Montant;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExecution;

    @Column
    private String nom_prenom_emetteur;

    @ManyToOne
    private Compte compteBeneficiaire;

    @Column(length = 200)
    private String motifDeposit;


}

package ma.octo.assignement.Operations.utilis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class TransferDTO {
    public static final int MONTANT_MAXIMAL = 10000;
    public static final int MONTANT_MINIMAL = 10;

    @NotBlank
    private String nrCompteEmetteur;

    @NotBlank
    private String nrCompteBeneficiaire;

    @Length(max=200) @NotBlank(message = "Motif vide")
    private String motif;

    @Max(value = MONTANT_MAXIMAL, message = "Montant maximal de transfer dépassé")
    @Min(value = MONTANT_MINIMAL, message = "Montant minimal de transfer non atteint")
    @NotNull(message = "Montant vide")
    private BigDecimal montant;

    private Date date;

}

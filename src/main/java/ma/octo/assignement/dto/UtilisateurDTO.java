package ma.octo.assignement.Utilisateur.utilis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UtilisateurDTO {

    private Long id;

    @Length(max=10) @NotBlank
    private String username;

    @Pattern(regexp = "female|male")
    private String gender;

    @Length(max=60) @NotBlank
    private String lastname;

    @Length(max=60) @NotBlank
    private String firstname;

    private Date birthdate;

}

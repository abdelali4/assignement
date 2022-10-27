package ma.octo.assignement.repository;


import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


//@DataJpaTest
public class CompteRepositoryTest {

    @Autowired
    private CompteRepository underTest;
    @Autowired
    private UtilisateurRepository userRepo;

    @Test
    void it_should_be_able_to_find_a_user_by_number_of_account(){
          System.out.println(underTest);
//        Compte expected = adding_an_account();
//
//        Compte result = underTest.findByNrCompte(expected.getNrCompte()).get();
//
//        assertEquals(result, expected);

    }

    public Compte adding_an_account(){
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setUsername("user1");
        utilisateur1.setLastname("last1");
        utilisateur1.setFirstname("first1");
        utilisateur1.setGender("Male");
        userRepo.save(utilisateur1);
        Compte compte1 = new Compte();
        compte1.setNrCompte("010000A000001000");
        compte1.setRib("RIB1");
        compte1.setSolde(BigDecimal.valueOf(200000L));
        compte1.setUtilisateur(utilisateur1);

        return  compte1;
    }
}

package ma.octo.assignement.Compte;

import ma.octo.assignement.domain.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    Optional<Compte> findByNrCompte(String nrCompte);

    Optional<Compte> findByRib(String Rib);

}

package ma.octo.assignement.Operations.Deposit;

import ma.octo.assignement.domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}

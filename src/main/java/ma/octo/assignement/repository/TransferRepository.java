package ma.octo.assignement.Operations.Transfer;

import ma.octo.assignement.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}

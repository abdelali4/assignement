package ma.octo.assignement.AuditOperation;

import ma.octo.assignement.domain.AuditOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditOperationRepository extends JpaRepository<AuditOperation, Long> {

}

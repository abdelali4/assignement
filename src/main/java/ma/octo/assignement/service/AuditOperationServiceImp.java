package ma.octo.assignement.AuditOperation;

import ma.octo.assignement.domain.utils.OperationType;
import ma.octo.assignement.domain.AuditOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditOperationServiceImp implements AuditOperationService {

    @Autowired
    private AuditOperationRepository auditOperationRepository;

    @Override
    public void auditTransferOrDeposit(String message, OperationType operationType) {

        AuditOperation audit = new AuditOperation();

        audit.setOperationType(operationType);
        audit.setMessage(message);

        auditOperationRepository.save(audit);
    }
}

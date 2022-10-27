package ma.octo.assignement.AuditOperation;


import ma.octo.assignement.domain.utils.OperationType;

public interface AuditOperationService {

    public void auditTransferOrDeposit(String message, OperationType operationType);

}

package ma.octo.assignement.AuditOperation.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class AuditOperationDTO {

    private Long id;
    private String message;
    private OperationType operationType;

}

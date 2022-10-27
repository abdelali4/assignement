package ma.octo.assignement.AuditOperation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.octo.assignement.AuditOperation.utils.OperationType;

import javax.persistence.*;

@Entity
@Table(name="AUDIT")
@Data @NoArgsConstructor @AllArgsConstructor
public class AuditOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String message;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

}

package ma.octo.assignement.Operations;

import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.domain.Transfer;
import ma.octo.assignement.dto.DepositDTO;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.dto.TransferDTO;

import java.util.List;

public interface OperationService {

    void faireUnTransfer(TransferDTO transferDTO) throws CompteNonExistantException,
                                                SoldeDisponibleInsuffisantException;

    void faireUnDepot(DepositDTO depositDTO) throws CompteNonExistantException;
    List<Transfer> getAllTransfers();



}

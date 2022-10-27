package ma.octo.assignement.Operations;


import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.domain.Transfer;
import ma.octo.assignement.dto.DepositDTO;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.dto.TransferDTO;
import ma.octo.assignement.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationsController {
    @Autowired
    private OperationService operationService;

    @GetMapping("/transfers")
    public ResponseEntity<List<Transfer>> getAllTransfers(){

        List<Transfer> response = operationService.getAllTransfers();
        return new ResponseEntity<>(response , HttpStatus.OK);

    }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.CREATED)
    public void faireUnTransfer(@RequestBody @Valid TransferDTO transferDTO)
                                    throws CompteNonExistantException,
                                    SoldeDisponibleInsuffisantException {

        operationService.faireUnTransfer(transferDTO);
    }

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public void faireUnTransfer(@RequestBody @Valid DepositDTO depositDTO)
            throws CompteNonExistantException,
            SoldeDisponibleInsuffisantException {

        operationService.faireUnDepot(depositDTO);
    }

}

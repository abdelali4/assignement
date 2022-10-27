package ma.octo.assignement.Operations;


import ma.octo.assignement.AuditOperation.AuditOperationService;
import ma.octo.assignement.domain.utils.OperationType;
import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.Compte.CompteRepository;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.domain.Deposit;
import ma.octo.assignement.Operations.Deposit.DepositRepository;
import ma.octo.assignement.domain.Transfer;
import ma.octo.assignement.Operations.Transfer.TransferRepository;
import ma.octo.assignement.dto.DepositDTO;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.dto.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OperationServiceImp implements OperationService{

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private AuditOperationService auditOperationService;

    @Autowired
    private DepositRepository depositRepository;

    @Override
    public void faireUnTransfer(TransferDTO transferDTO)
                            throws CompteNonExistantException,
                            SoldeDisponibleInsuffisantException {

        Compte emitteur = compteRepository.findByNrCompte(transferDTO.getNrCompteEmetteur())
                                            .orElseThrow(()->
                                                    new CompteNonExistantException(
                                                    "Le compte emitteur est introuvable"));

        Compte benificaire = compteRepository.findByNrCompte(transferDTO.getNrCompteEmetteur())
                .orElseThrow(()-> new CompteNonExistantException("Le compte bénificaire est introuvable"));

        if(emitteur.getSolde().subtract(transferDTO.getMontant()).compareTo(new BigDecimal("0")) == -1){
            throw new SoldeDisponibleInsuffisantException();
        }
        emitteur.setSolde(emitteur.getSolde().subtract(transferDTO.getMontant()));
        benificaire.setSolde(emitteur.getSolde().add(transferDTO.getMontant()));

        Transfer transfer =  new Transfer();
        transfer.setDateExecution(new Date());
        transfer.setCompteBeneficiaire(benificaire);
        transfer.setCompteEmetteur(emitteur);
        transfer.setMontantTransfer(transferDTO.getMontant());

        transferRepository.save(transfer);
        compteRepository.save(benificaire);
        compteRepository.save(emitteur);
        auditOperationService.auditTransferOrDeposit("Transfer depuis " + transferDTO.getNrCompteEmetteur() +
                " vers " + transferDTO.getNrCompteBeneficiaire() + " d'un montant de " + transferDTO.getMontant()
                .toString()
                , OperationType.TRANSFER);
    }

    @Override
    public void faireUnDepot(DepositDTO depositDTO) throws CompteNonExistantException {

        Compte benificiaire = compteRepository.findByRib(depositDTO.getRibBeneficiaire())
                                            .orElseThrow(()-> new CompteNonExistantException());

        Deposit deposit = new Deposit();

        deposit.setNom_prenom_emetteur(deposit.getNom_prenom_emetteur());
        deposit.setMontant(deposit.getMontant());
        deposit.setCompteBeneficiaire(benificiaire);
        deposit.setDateExecution(new Date());
        deposit.setMotifDeposit(deposit.getMotifDeposit());

        benificiaire.setSolde(benificiaire.getSolde().add(depositDTO.getMontant()));

        compteRepository.save(benificiaire);
        depositRepository.save(deposit);

        auditOperationService.auditTransferOrDeposit(
                "Depot d'argent fait par " + depositDTO.getNom_prenom_emetteur() +
                        " dans " + depositDTO.getRibBeneficiaire() + " d'un montant de " + depositDTO.getMontant()
                        .toString()
                , OperationType.DEPOSIT
        );

    }

    public List<Transfer> getAllTransfers(){
        return transferRepository.findAll();
    }
}

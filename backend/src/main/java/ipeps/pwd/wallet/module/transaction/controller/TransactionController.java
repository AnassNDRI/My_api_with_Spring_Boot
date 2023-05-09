package ipeps.pwd.wallet.module.transaction.controller;

import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.transaction.entity.CreateTransactionPayload;
import ipeps.pwd.wallet.module.transaction.entity.Transaction;
import ipeps.pwd.wallet.module.transaction.entity.UpdateTransactionPayload;
import ipeps.pwd.wallet.module.transaction.repository.TransactionRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transaction")
@RestController
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    /**transaction
     * cette methode retourne la liste des transactions ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Transaction> transactions = transactionRepository.findAll();
        return new ApiResponse(true, transactions, null);
    }

    /** cette methode retourne une transaction si son identifiant est dans la base de
     donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/detail/{transaction_id}")
    public ApiResponse detail(@PathVariable int transaction_id){
        return  new ApiResponse(true, transactionRepository.findById(transaction_id), null);
    }

    // cette methode permet d'ajouter une nouvelle transaction
    @PostMapping("/create")
    public ApiResponse create (@RequestBody CreateTransactionPayload request){

        Transaction transaction  = new Transaction.Builder().setType(request.getType())
                                                            .setAmount(request.getAmount()).build();
        Transaction newTransaction = transactionRepository.save(transaction) ;
        return  new ApiResponse(true, newTransaction, null);
    }

    /** Cette methode permet de modifier une transaction
     */

    @PutMapping("/update")
    public ApiResponse update (@RequestBody UpdateTransactionPayload request){

        Transaction transaction  = transactionRepository.findById(request.getTransaction_id());
        if (transaction != null) {
            transaction.setType(request.getType());
            transaction.setAmount(request.getAmount());
            Transaction UpdateTransactionPayload = transactionRepository.save(transaction);
            return new ApiResponse(true, UpdateTransactionPayload, null);
        }
        else
        {
            return new ApiResponse(false,null, null);
        }
    }

    /** Cette methode renvoie un message de réussite si
     *  la transaction a été supprimé sinon false ApiResponse avec le code d'erreur api
     */

    @DeleteMapping("/delete/{transaction_id}")
    public ApiResponse delete(@PathVariable int transaction_id) {
        Transaction transaction = transactionRepository.findById(transaction_id);
        if (transaction != null) {
            transactionRepository.delete(transaction);
            return new ApiResponse(true, ApiReponseCode.TransactionDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.TransactionNotFoundErrorCode());
        }

    }
}

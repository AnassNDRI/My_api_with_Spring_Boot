package ipeps.pwd.wallet.module.account.controller;


import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.account.entity.Account;
import ipeps.pwd.wallet.module.account.entity.CreateAccountPayload;

import ipeps.pwd.wallet.module.account.entity.UpdateAccountPayload;
import ipeps.pwd.wallet.module.account.repository.AccountRepository;

import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import ipeps.pwd.wallet.security.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController   // dire que c'est controller
@RequestMapping("/account") // route de depart.

public class AccountController {
    @Autowired   //  sert a injecter une classe dans ce controller
    AccountRepository accountRepository; // (est injectée la classe AcountRepository pour pouvoir beneficier de toutes les methodes que cette classe a)
    @Autowired                         //  sert a injecter une classe dans ce controller
    CredentialRepository credentialRepository; // (est injectée la classe Credential repository)



    /**
     * cette methode retourne la liste des Accounts ou un tableau vide.
     */
   @GetMapping("list")
    public ApiResponse list() {

       List<Account> accounts = accountRepository.findAll();
       return new ApiResponse(true, accounts, null);
   }

    /** cette methode retourne un account si son identifiant est dans la base de
    donnée sinon elle retourne une erreur
     */

    @GetMapping("/{account_id}")
    public ApiResponse detail(@PathVariable int account_id){
            return new ApiResponse(true, accountRepository.findById(account_id), null);
    }


    // cette methode permet creer un nouveau Account
    @PostMapping("/create")
    public ApiResponse create(@RequestBody CreateAccountPayload request){

        Account account  = new Account.Builder().setFirstname(request.getFirstname())
                                                 .setLastname(request.getLastname()).build();
                       Account newAccount = accountRepository.save(account);
        return  new ApiResponse(true, newAccount, null);
    }

    /** Cette methode permet de modifier un Account en le cherchant avec son ID
     */

    @PutMapping("/update")
    public ApiResponse update(@RequestBody UpdateAccountPayload request){
        Account account = accountRepository.findById(request.getAccount_id());
        if(account != null){
            account.setFirstname(request.getFirstname());
            account.setLastname(request.getLastname());
            Account UpdateAddressPayload = accountRepository.save(account);
            return  new ApiResponse(true, UpdateAddressPayload, null);
        }
        else
        {
            return new ApiResponse(false,null, null);
        }

    }

    /** Cette methode renvoie un message de réussite si
     *  l' Account a été supprimé sinon un message d'erreur.
     */
    @DeleteMapping("/delete/{account_id}")
    public ApiResponse delete(@PathVariable int account_id) {
        Account account = accountRepository.findById(account_id);
        if (account != null) {
            accountRepository.delete(account);
            return new ApiResponse(true, ApiReponseCode.AccountDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.AccountNotFoundErrorCode());
        }

    }

}

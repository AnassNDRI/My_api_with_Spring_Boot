package ipeps.pwd.wallet.module.wallet.controller;

import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import ipeps.pwd.wallet.module.wallet.entity.CreateWalletPayload;
import ipeps.pwd.wallet.module.wallet.entity.UpdateWalletPayload;
import ipeps.pwd.wallet.module.wallet.entity.Wallet;
import ipeps.pwd.wallet.module.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/wallet")
@RestController
public class WalletController {
    @Autowired
    WalletRepository walletRepository;

    /**
     * cette methode retourne la liste des Wallets ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Wallet> wallets = walletRepository.findAll();
        return new ApiResponse(true, wallets, null);
    }
    /** cette methode retourne un Wallet si son identifiant est dans la base de
     donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{wallet_id}")
    public ApiResponse detail(@PathVariable int wallet_id){
        return  new ApiResponse(true, walletRepository.findById(wallet_id), null);
    }

    // cette methode permet d'ajouter un nouveau Wallet
    @PostMapping("/create")
    public ApiResponse create (@RequestBody CreateWalletPayload request){

        Wallet wallet  = new Wallet.Builder().setName(request.getName())
                                             .setDescription(request.getDescription())
                                             .setActif(request.isActif())
                                             .setType(request.getType()).build();
        Wallet newWallet = walletRepository.save(wallet) ;
        return  new ApiResponse(true, newWallet, null);
    }

    /** Cette methode permet de modifier un Wallet
     */

    @PutMapping("/update")
    public ApiResponse update (@RequestBody UpdateWalletPayload request){

        Wallet wallet  = walletRepository.findById(request.getWallet_id());
        if (wallet != null) {
            wallet.setName(request.getName());
            wallet.setDescription(request.getDescription());
            wallet.setActif(request.isActif());
            wallet.setType(request.getType());
            Wallet UpdateWalletPayload = walletRepository.save(wallet);
            return new ApiResponse(true, UpdateWalletPayload, null);
        }
        else
        {
            return new ApiResponse(false,null, null);
        }
    }

    /** Cette methode renvoie un message de réussite si
     *  le Wallet a été supprimé sinon false ApiResponse avec le code d'erreur api
     */

    @DeleteMapping("/delete/{wallet_id}")
    public ApiResponse delete(@PathVariable int wallet_id) {
        Wallet wallet = walletRepository.findById(wallet_id);
        if (wallet != null) {
            walletRepository.delete(wallet);
            return new ApiResponse(true, ApiReponseCode.WalletDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.WalletNotFoundErrorCode());
        }
    }

}

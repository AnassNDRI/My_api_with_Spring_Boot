package ipeps.pwd.wallet.module.address.controller;

import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.address.entity.Address;
import ipeps.pwd.wallet.module.address.entity.CreateAddressPayload;
import ipeps.pwd.wallet.module.address.entity.UpdateAddressPayload;
import ipeps.pwd.wallet.module.address.repository.AddressRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
@RestController
public class AddressController {
    @Autowired
    AddressRepository addressRepository;


    /**
     * cette methode retourne la liste des Address ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Address> address = addressRepository.findAll();
        return new ApiResponse(true, address, null);
    }


    /** cette methode retourne une address si son identifiant est dans la base de
     donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{address_id}")
    public ApiResponse detail(@PathVariable int address_id){
        return  new ApiResponse(true, addressRepository.findById(address_id), null);
    }

    // cette methode permet d'ajouter une nouvelle address
    @PostMapping("/create")
    public ApiResponse create (@RequestBody CreateAddressPayload request){

        Address address  = new Address.Builder().setType(request.getType())
                                                .setRoad(request.getRoad())
                                                .setNumber(request.getNumber())
                                                .setBox(request.getBox())
                                                .setCp(request.getCp())
                                                .setTown(request.getTown())
                                                .setCountry(request.getCountry()).build();
        Address newAddress = addressRepository.save(address) ;
        return  new ApiResponse(true, newAddress, null);
    }

    /** Cette methode permet de modifier une address
     */

    @PutMapping("/update")
    public ApiResponse update(@RequestBody UpdateAddressPayload request){
       Address address = addressRepository.findById(request.getAddress_id());
       if (address!= null) {
           address.setType(request.getType());
           address.setRoad(request.getRoad());
           address.setNumber(request.getNumber());
           address.setBox(request.getBox());
           address.setCp(request.getCp());
           address.setTown(request.getTown());
           address.setCountry(request.getCountry());
           Address UpdateAddressPayload = addressRepository.save(address);
           return new ApiResponse(true, UpdateAddressPayload, null);
       }
       else
       {
           return new ApiResponse(false,null, null);
       }
    }


    /** Cette methode renvoie un message de réussite si
     *  l'employee a été supprimé sinon false ApiResponse avec le code d'erreur api
     */
    @DeleteMapping("/delete/{address_id}")
    public ApiResponse delete(@PathVariable int address_id) {
        Address address = addressRepository.findById(address_id);
        if (address != null) {
            addressRepository.delete(address);
            return new ApiResponse(true, ApiReponseCode.AddressDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.AddressNotFoundErrorCode());
        }

    }


}

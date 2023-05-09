package ipeps.pwd.wallet.module.contact.controller;

import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.contact.entity.Contact;
import ipeps.pwd.wallet.module.contact.entity.CreateContactPayload;
import ipeps.pwd.wallet.module.contact.entity.UpdateContactPayload;
import ipeps.pwd.wallet.module.contact.repository.ContactRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contact")
@RestController
public class ContactController {
    @Autowired
    ContactRepository contactRepository;

    /**
     * cette methode retourne la liste des contacts ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Contact> contacts = contactRepository.findAll();
        return new ApiResponse(true, contacts, null);
    }

    /** cette methode retourne un contact si son identifiant est dans la base de
     donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{contact_id}")
    public ApiResponse detail(@PathVariable int contact_id){
        return  new ApiResponse(true, contactRepository.findById(contact_id), null);
    }
    // cette methode permet d'ajouter un nouveau contact
    @PostMapping("/create")
    public ApiResponse create (@RequestBody CreateContactPayload request){

        Contact contact  = new Contact.Builder().setFirstname(request.getFirstname())
                                                .setLastname(request.getLastname())
                                                .setEmail(request.getEmail())
                                                .setPhone(request.getPhone()).build();
        Contact newContact = contactRepository.save(contact) ;
        return  new ApiResponse(true, newContact, null);
    }

    /** Cette methode permet de modifier une address
     */
    @PutMapping("/update")
    public ApiResponse create (@RequestBody UpdateContactPayload request){
       Contact contact = contactRepository.findById(request.getContact_id());
       if (contact != null) {
           contact.setFirstname(request.getFirstname());
           contact.setLastname(request.getLastname());
           contact.setEmail(request.getEmail());
           contact.setPhone(request.getPhone());
           Contact UpdateContactPayload = contactRepository.save(contact);
           return new ApiResponse(true, UpdateContactPayload, null);
       }
       else
       {
           return new ApiResponse(false,null, null);
       }
    }
    /** Cette methode renvoie un message de réussite si
     *  l'employee a été supprimé sinon false ApiResponse avec le code d'erreur api
     */

    @DeleteMapping("/delete/{contact_id}")
    public ApiResponse delete(@PathVariable int contact_id) {
        Contact contact = contactRepository.findById(contact_id);
        if (contact != null) {
            contactRepository.delete(contact);
            return new ApiResponse(true, ApiReponseCode.ContactDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.ContactNotFoundErrorCode());
        }

    }
}

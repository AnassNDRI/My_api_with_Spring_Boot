package ipeps.pwd.wallet.module.document.controller;
import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.document.entity.CreateDocumentPayload;
import ipeps.pwd.wallet.module.document.entity.Document;
import ipeps.pwd.wallet.module.document.entity.UpdateDocumentPayload;
import ipeps.pwd.wallet.module.document.filter.DocumentFilter;
import ipeps.pwd.wallet.module.document.filter.criteria.DocumentCriteria;
import ipeps.pwd.wallet.module.document.repository.DocumentRepository;
import ipeps.pwd.wallet.module.employee.filter.EmployeeFilter;
import ipeps.pwd.wallet.module.employee.filter.criteria.EmployeeCriteria;
import ipeps.pwd.wallet.module.employee.repository.EmployeeRepository;
import ipeps.pwd.wallet.module.organization.repository.OrganizationRepository;
import ipeps.pwd.wallet.module.transaction.repository.TransactionRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/document")
@RestController
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TransactionRepository transactionRepository;

    private final DocumentFilter documentFilter;

    public DocumentController(DocumentFilter documentFilter) {
        this.documentFilter = documentFilter;
    }

    @PostMapping("/search")
    public ApiResponse search(@RequestBody DocumentCriteria criteria) {
        return new ApiResponse(true, this.documentFilter.findAllWithFilters(criteria), null);
    }

    /**
     * cette methode retourne la liste des documents ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Document> documents = documentRepository.findAll();
        return new ApiResponse(true, documents, null);
    }

    /** cette methode retourne un document si son identifiant est dans la base de
     donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{document_id}")
    public ApiResponse detail(@PathVariable int document_id){
        return  new ApiResponse(true, documentRepository.findById(document_id), null);
    }

    // cette methode permet d'ajouter un nouveau document
    @PostMapping("/create")
    public ApiResponse create (@RequestBody CreateDocumentPayload request){

        Document document  = new Document.Builder().setName(request.getName())
                                                   .setDescription(request.getDescription())
                                                   .setFree_access(request.isFree_access())
                                                   .setPath(request.getPath())
                                                   .setPath(request.getPath()).build();
        Document newDocument = documentRepository.save(document) ;
        return  new ApiResponse(true, newDocument, null);
    }

    /** Cette methode permet de modifier une document
     */

    @PutMapping("/update")
    public ApiResponse update (@RequestBody UpdateDocumentPayload request){
       Document document = documentRepository.findById(request.getDocument_id());
       if (document != null){
           document.setName(request.getName());
           document.setDescription(request.getDescription());
           document.setFree_access(request.isFree_access());
           document.setPath(request.getPath());
           document.setPath(request.getPath());
           Document UpdateDocumentPayload = documentRepository.save(document) ;
           return  new ApiResponse(true, UpdateDocumentPayload, null);

       } else
       {
           return new ApiResponse(false,null, null);
       }


    }

    /** Cette methode renvoie un message de réussite si
     *  l'employee a été supprimé sinon false ApiResponse avec le code d'erreur api
     */

    @DeleteMapping("/delete/{document_id}")
    public ApiResponse delete(@PathVariable int document_id) {
        Document document = documentRepository.findById(document_id);
        if (document != null) {
            documentRepository.delete(document);
            return new ApiResponse(true, ApiReponseCode.DocumentDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.DocumentNotFoundErrorCode());
        }
    }

}

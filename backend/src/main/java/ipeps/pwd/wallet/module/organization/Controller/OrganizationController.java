package ipeps.pwd.wallet.module.organization.Controller;


import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.organization.entity.CreateOrganizationPayload;
import ipeps.pwd.wallet.module.organization.entity.Organization;
import ipeps.pwd.wallet.module.organization.entity.UpdateOrganizationPayload;
import ipeps.pwd.wallet.module.organization.filter.OrganizationFilter;
import ipeps.pwd.wallet.module.organization.filter.criteria.OrganizationCriteria;
import ipeps.pwd.wallet.module.organization.repository.OrganizationRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/organization")
@RestController
public class OrganizationController {
    @Autowired
    OrganizationRepository organizationRepository;
    private final OrganizationFilter organizationFilter;

    public OrganizationController(OrganizationFilter organizationFilter) {
        this.organizationFilter = organizationFilter;
    }

    @PostMapping("/search")
    public ApiResponse search(@RequestBody OrganizationCriteria criteria) {
        return new ApiResponse(true, this.organizationFilter.findAllWithFilters(criteria), null);
    }

    /**
     * cette methode retourne la liste des organizations ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Organization> organizations = organizationRepository.findAll();
        return new ApiResponse(true, organizations, null);
    }

    /**
     * cette methode retourne une organization si son identifiant est dans la base de
     * donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{organization_id}")
    public ApiResponse detail(@PathVariable int organization_id) {
        return new ApiResponse(true, organizationRepository.findById(organization_id), null);
    }

    // cette methode permet d'ajouter une nouvelle organization
    @PostMapping("/create")
    public ApiResponse create(@RequestBody CreateOrganizationPayload request) {

        Organization organization = new Organization.Builder().setName(request.getName())
                .setDescription(request.getDescription())
                .setActif(request.isActif()).build();
        Organization newOrganization = organizationRepository.save(organization);
        return new ApiResponse(true, newOrganization, null);
    }

    /**
     * Cette methode permet de modifier une address
     */

    @PutMapping("/update")
    public ApiResponse update(@RequestBody UpdateOrganizationPayload request) {
        Organization organization = organizationRepository.findById(request.getOrganization_id());
        if (organization != null) {
            organization.setName(request.getName());
            organization.setDescription(request.getDescription());
            organization.setActif(request.isActif());
            Organization UpdateOrganizationPayload = organizationRepository.save(organization);
            return new ApiResponse(true, UpdateOrganizationPayload, null);
        }
        else
        {
            return new ApiResponse(false,null, null);
        }
    }

    /**
     * Cette methode renvoie un message de réussite si
     * l'employee a été supprimé sinon false ApiResponse avec le code d'erreur api
     */

    @DeleteMapping("/delete/{organization_id}")
    public ApiResponse delete(@PathVariable int organization_id) {
        Organization organization = organizationRepository.findById(organization_id);
        if (organization != null) {
            organizationRepository.delete(organization);
            return new ApiResponse(true, ApiReponseCode.OrganizationDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.OrganizationNotFoundErrorCode());

        }
    }

}

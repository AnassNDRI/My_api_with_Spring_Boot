package ipeps.pwd.wallet.module.employee.Controller;

import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.account.repository.AccountRepository;
import ipeps.pwd.wallet.module.employee.entity.CreateEmployeePayload;
import ipeps.pwd.wallet.module.employee.entity.Employee;
import ipeps.pwd.wallet.module.employee.entity.UpdateEmployeePayload;
import ipeps.pwd.wallet.module.employee.filter.EmployeeFilter;
import ipeps.pwd.wallet.module.employee.filter.criteria.EmployeeCriteria;
import ipeps.pwd.wallet.module.employee.repository.EmployeeRepository;
import ipeps.pwd.wallet.module.organization.repository.OrganizationRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employee")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    AccountRepository accountRepository;

    private final EmployeeFilter employeeFilter;

    public EmployeeController(EmployeeFilter employeeFilter) {
        this.employeeFilter = employeeFilter;
    }

    @PostMapping("/search")
    public ApiResponse search(@RequestBody EmployeeCriteria criteria) {
        return new ApiResponse(true, this.employeeFilter.findAllWithFilters(criteria), null);
    }

    /**
     * cette methode retourne la liste des employees ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Employee> employees = employeeRepository.findAll();
        return new ApiResponse(true, employees, null);
    }

    /**
     * cette methode retourne un employee si son identifiant est dans la base de
     * donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{employee_id}")
    public ApiResponse detail(@PathVariable int employee_id) {
        return new ApiResponse(true, employeeRepository.findById(employee_id), null);
    }

    // cette methode permet d'ajouter une nouvelle employee
    @PostMapping("/create")
    public ApiResponse create(@RequestBody CreateEmployeePayload request) {

        Employee employee = new Employee.Builder().setRole(request.getRole())
                .setActif(request.isActif()).build();
        Employee newEmployee = employeeRepository.save(employee);
        return new ApiResponse(true, newEmployee, null);
    }

    /**
     * Cette methode permet de modifier un employee
     */

    @PutMapping("/update")
    public ApiResponse update(@RequestBody UpdateEmployeePayload request) {
        Employee employee = employeeRepository.findById(request.getEmployee_id());
        if (employee != null) {
            employee.setRole(request.getRole());
            employee.setActif(request.isActif());
            Employee UpdateEmployeePayload = employeeRepository.save(employee);
            return new ApiResponse(true, UpdateEmployeePayload, null);
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

    @DeleteMapping("/delete/{employee_id}")
    public ApiResponse delete(@PathVariable int employee_id) {
        Employee employee = employeeRepository.findById(employee_id);
        if (employee != null) {
            employeeRepository.delete(employee);
            return new ApiResponse(true, ApiReponseCode.EmployeeDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.EmployeeNotFoundErrorCode());
        }

    }
}

package ipeps.pwd.wallet.module.salary.controller;


import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.salary.entity.CreateSalaryPayload;
import ipeps.pwd.wallet.module.salary.entity.Salary;
import ipeps.pwd.wallet.module.salary.entity.UpdateSalaryPayload;
import ipeps.pwd.wallet.module.salary.repository.SalaryRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/salary")
@RestController
public class SalaryController {
    @Autowired
    SalaryRepository salaryRepository;

    /**
     * cette methode retourne la liste des Salary ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Salary> salary = salaryRepository.findAll();
        return new ApiResponse(true, salary, null);
    }

    /** cette methode retourne un salary si son identifiant est dans la base de
     donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{salary_id}")
    public ApiResponse detail(@PathVariable int salary_id){
        return  new ApiResponse(true, salaryRepository.findById(salary_id), null);
    }

    // cette methode permet d'ajouter une nouveau salary
    @PostMapping("/create")
    public ApiResponse create (@RequestBody CreateSalaryPayload request){

        Salary salary  = new Salary.Builder()
                .setType(request.getType())
                .setDate(request.getDate())
                .setAmount(request.getAmount())
                .setPeriodicity(request.getPeriodicity()).build();
        Salary newSalary = salaryRepository.save(salary) ;
        return  new ApiResponse(true, newSalary, null);
    }

    /** Cette methode permet de modifier un Salary
     */

    @PutMapping("/update")
    public ApiResponse update (@RequestBody UpdateSalaryPayload request){
        Salary salary = salaryRepository.findById(request.getSalary_id());
        if (salary != null) {
            salary.setType(request.getType());
            salary.setDate(request.getDate());
            salary.setAmount(request.getAmount());
            salary.setPeriodicity(request.getPeriodicity());
            Salary UpdateSalaryPayload = salaryRepository.save(salary);
            return new ApiResponse(true, UpdateSalaryPayload, null);
        }
        else
        {
            return new ApiResponse(false,null, null);
        }
    }

    /** Cette methode renvoie un message de réussite si
     *  Salary a été supprimé sinon false ApiResponse avec le code d'erreur api
     */

    @DeleteMapping("/delete/{salary_id}")
    public ApiResponse delete(@PathVariable int salary_id) {
        Salary salary = salaryRepository.findById(salary_id);
        if (salary != null) {
            salaryRepository.delete(salary);
            return new ApiResponse(true, ApiReponseCode.SalaryDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.SalaryNotFoundErrorCode());
        }

    }


}

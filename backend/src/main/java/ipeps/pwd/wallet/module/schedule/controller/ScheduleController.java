package ipeps.pwd.wallet.module.schedule.controller;

import ipeps.pwd.wallet.common.entity.response.ApiResponse;
import ipeps.pwd.wallet.module.schedule.entity.CreateSchedulePayload;
import ipeps.pwd.wallet.module.schedule.entity.Schedule;
import ipeps.pwd.wallet.module.schedule.entity.UpdateSchedulePayload;
import ipeps.pwd.wallet.module.schedule.repository.ScheduleRepository;
import ipeps.pwd.wallet.module.utils.ApiReponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/schedule")
@RestController
public class ScheduleController {
    @Autowired
    ScheduleRepository scheduleRepository;

    /**
     * cette methode retourne la liste des Schedules ou un tableau vide.
     */
    @GetMapping("/list")
    public ApiResponse list() {

        List<Schedule> schedule = scheduleRepository.findAll();
        return new ApiResponse(true, schedule, null);
    }

    /** cette methode retourne un Schedule si son identifiant est dans la base de
     donnée sinon elle retourne une fausse ApiResponse avec api error_code
     */
    @GetMapping("/{schedule_id}")
    public ApiResponse detail(@PathVariable int schedule_id){
        return  new ApiResponse(true, scheduleRepository.findById(schedule_id), null);
    }

    // cette methode permet d'ajouter un nouveau Schedule
    @PostMapping("/create")
    public ApiResponse create (@RequestBody CreateSchedulePayload request){

        Schedule schedule  = new Schedule.Builder().setType(request.getType())
                                                   .setDate_schedule(request.getDate_schedule())
                                                   .setComment(request.getComment()).build();
        Schedule newSchedule = scheduleRepository.save(schedule) ;
        return  new ApiResponse(true, newSchedule, null);
    }

    /** Cette methode permet de modifier un Schedule
     */

    @PutMapping("/update")
    public ApiResponse update (@RequestBody UpdateSchedulePayload request){
        Schedule schedule = scheduleRepository.findById(request.getSchedule_id());
        if (schedule != null) {
            schedule.setSchedule_id(request.getSchedule_id());
            schedule.setType(request.getType());
            schedule.setDate_schedule(request.getDate_schedule());
            schedule.setComment(request.getComment());
            Schedule UpdateSchedulePayload = scheduleRepository.save(schedule);
            return new ApiResponse(true, UpdateSchedulePayload, null);
        }
        else
        {
            return new ApiResponse(false,null, null);
        }
    }

    /** Cette methode renvoie un message de réussite si
     *  le Schedule a été supprimé sinon false ApiResponse avec le code d'erreur api
     */

    @DeleteMapping("/delete/{schedule_id}")
    public ApiResponse delete(@PathVariable int schedule_id) {
        Schedule schedule = scheduleRepository.findById(schedule_id);
        if (schedule != null) {
            scheduleRepository.delete(schedule);
            return new ApiResponse(true, ApiReponseCode.ScheduleDeleteSuccessCode(), null);
        } else {
            return new ApiResponse(false, null, ApiReponseCode.ScheduleNotFoundErrorCode());
        }

    }

}

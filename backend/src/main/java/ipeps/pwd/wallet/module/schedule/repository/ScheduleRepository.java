package ipeps.pwd.wallet.module.schedule.repository;

import ipeps.pwd.wallet.module.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findByType(String type);
    Schedule findById(int id);
    boolean existsByType(String type);
}

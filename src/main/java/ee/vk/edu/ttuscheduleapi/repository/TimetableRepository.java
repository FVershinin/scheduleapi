package ee.vk.edu.ttuscheduleapi.repository;

import ee.vk.edu.ttuscheduleapi.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fjodor on 4.03.16.
 */
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}

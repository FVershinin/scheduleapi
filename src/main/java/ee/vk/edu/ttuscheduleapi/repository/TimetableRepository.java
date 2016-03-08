package ee.vk.edu.ttuscheduleapi.repository;

import ee.vk.edu.ttuscheduleapi.model.Timetable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedEntityGraph;
import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by fjodor on 4.03.16.
 */
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}

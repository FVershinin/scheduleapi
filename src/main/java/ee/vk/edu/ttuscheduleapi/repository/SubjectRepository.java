package ee.vk.edu.ttuscheduleapi.repository;

import ee.vk.edu.ttuscheduleapi.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fjodor on 4.03.16.
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByCode(String code);
}

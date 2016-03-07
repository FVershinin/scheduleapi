package ee.vk.edu.ttuscheduleapi.repository;

import ee.vk.edu.ttuscheduleapi.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by fjodor on 4.03.16.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}

package ee.vk.edu.ttuscheduleapi.service.impl;

import ee.vk.edu.ttuscheduleapi.model.Teacher;
import ee.vk.edu.ttuscheduleapi.repository.TeacherRepository;
import ee.vk.edu.ttuscheduleapi.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by fjodor on 7.03.16.
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Inject
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher findByFullname(String fullname) {
        return null;
    }

    @Override
    public List<Teacher> saveAll(List<Teacher> teachers) {
        return teacherRepository.save(teachers.stream()
                .map(x -> Optional.ofNullable(teacherRepository.findByUsername(x.getUsername())).orElse(x))
                .collect(Collectors.toList()));
    }
}

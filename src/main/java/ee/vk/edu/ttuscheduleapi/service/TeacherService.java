package ee.vk.edu.ttuscheduleapi.service;

import ee.vk.edu.ttuscheduleapi.model.Teacher;

import java.util.List;

/**
 * Created by fjodor on 5.03.16.
 */
public interface TeacherService {
    List<Teacher> findAll();
}

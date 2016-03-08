package ee.vk.edu.ttuscheduleapi.service;

import ee.vk.edu.ttuscheduleapi.model.Subject;

import java.util.List;

/**
 * Created by fjodor on 4.03.16.
 */
public interface SubjectService {
    List<Subject> saveAll(List<Subject> subjects);
}

package ee.vk.edu.ttuscheduleapi.service;

import ee.vk.edu.ttuscheduleapi.model.Group;

import java.util.List;

/**
 * Created by fjodor on 4.03.16.
 */
public interface GroupService {
    List<Group> save(List<Group> groups);
    List<Group> findAll();
}
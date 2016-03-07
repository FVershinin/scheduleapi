package ee.vk.edu.ttuscheduleapi.service;

import ee.vk.edu.ttuscheduleapi.model.Timetable;

import java.util.List;

/**
 * Created by fjodor on 5.03.16.
 */
public interface TimetableService {
    List<Timetable> save(List<Timetable> timetables);
}

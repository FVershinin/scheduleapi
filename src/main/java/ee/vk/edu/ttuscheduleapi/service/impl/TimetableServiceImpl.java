package ee.vk.edu.ttuscheduleapi.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import ee.vk.edu.ttuscheduleapi.model.Group;
import ee.vk.edu.ttuscheduleapi.model.Subject;
import ee.vk.edu.ttuscheduleapi.model.Teacher;
import ee.vk.edu.ttuscheduleapi.model.Timetable;
import ee.vk.edu.ttuscheduleapi.repository.TimetableRepository;
import ee.vk.edu.ttuscheduleapi.service.GroupService;
import ee.vk.edu.ttuscheduleapi.service.SubjectService;
import ee.vk.edu.ttuscheduleapi.service.TeacherService;
import ee.vk.edu.ttuscheduleapi.service.TimetableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

    @Inject
    private TimetableRepository timetableRepository;

    @Inject
    private TeacherService teacherService;

    @Inject
    private SubjectService subjectService;

    @Inject
    private GroupService groupService;

    @Override
    public List<Timetable> save(List<Timetable> timetables) {
        Map<String, Subject> subjectMap = timetables.stream().map(Timetable::getSubject).collect(Collectors.toMap(Subject::getCode, y -> y, (x, y) -> x));
        Map<String, Teacher> teacherMap = timetables.stream().map(Timetable::getTeacher).collect(Collectors.toMap(Teacher::getUsername, y -> y, (x, y) -> x));
        Map<String, Group> groupMap = timetables.stream().map(Timetable::getGroup).collect(Collectors.toMap(Group::getName, y -> y, (x, y) -> x));
        subjectService.saveAll(Lists.newArrayList(subjectMap.values()));
        teacherService.saveAll(Lists.newArrayList(teacherMap.values()));
        groupService.saveAll(Lists.newArrayList(groupMap.values()));
        for (Timetable timetable : timetables) {
            timetable.setGroup(Optional.ofNullable(groupMap.get(timetable.getGroup().getName())).orElse(timetable.getGroup()));
            timetable.setTeacher(Optional.ofNullable(teacherMap.get(timetable.getTeacher().getUsername())).orElse(timetable.getTeacher()));
            timetable.setSubject(Optional.ofNullable(subjectMap.get(timetable.getSubject().getCode())).orElse(timetable.getSubject()));
        }
        return timetableRepository.save(timetables);
    }
}

package ee.vk.edu.ttuscheduleapi.service.impl;

import ee.vk.edu.ttuscheduleapi.model.Timetable;
import ee.vk.edu.ttuscheduleapi.repository.TimetableRepository;
import ee.vk.edu.ttuscheduleapi.service.TimetableService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

    @Inject
    private TimetableRepository timetableRepository;

    @Override
    public List<Timetable> save(List<Timetable> timetables) {
        return timetableRepository.save(timetables);
    }
}

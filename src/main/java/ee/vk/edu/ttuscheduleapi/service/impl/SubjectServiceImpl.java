package ee.vk.edu.ttuscheduleapi.service.impl;

import ee.vk.edu.ttuscheduleapi.model.Subject;
import ee.vk.edu.ttuscheduleapi.repository.SubjectRepository;
import ee.vk.edu.ttuscheduleapi.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{

    @Inject
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> saveAll(List<Subject> subjects) {
        return subjectRepository.save(subjects.stream()
                .map(x -> Optional.ofNullable(subjectRepository.findByCode(x.getCode())).orElse(x))
                .collect(Collectors.toList()));
    }
}

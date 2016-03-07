package ee.vk.edu.ttuscheduleapi.controller;

import com.google.common.collect.Maps;
import ee.vk.edu.ttuscheduleapi.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

@Controller
@RequestMapping("/api/")
public class TeacherController {
    @Inject
    private TeacherService teacherService;

    @RequestMapping("v2/teachers/")
    public ResponseEntity<Map<String, Object>> getSchedules(){
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put("schedules", teacherService);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    }
}

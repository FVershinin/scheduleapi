package ee.vk.edu.ttuscheduleapi.controller;

import com.google.common.collect.Maps;
import ee.vk.edu.ttuscheduleapi.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

@Controller
@RequestMapping("/api/")
public class ScheduleController {

    @Inject
    private GroupService groupService;

    @RequestMapping("v2/schedules/")
    public ResponseEntity<Map<String, Object>> getSchedules(){
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put("schedules", groupService.findAll());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}

package ee.vk.edu.ttuscheduleapi.service;

import net.fortuna.ical4j.data.ParserException;

import java.io.IOException;
import java.util.List;

/**
 * Created by fjodor on 4.03.16.
 */
public interface ScheduleService {
    void updateGroups() throws IOException;
    void update() throws IOException, ParserException;
}

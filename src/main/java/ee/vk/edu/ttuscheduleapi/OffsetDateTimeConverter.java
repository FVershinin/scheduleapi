package ee.vk.edu.ttuscheduleapi;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.*;
import java.util.Objects;

/**
 * Created by fjodor on 8.03.16.
 */
@Converter(autoApply = true)
public class OffsetDateTimeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {


    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime value) {
        return Timestamp.valueOf(value.toLocalDateTime());
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp value) {
        return ZonedDateTime.of(value.toLocalDateTime(), ZoneOffset.UTC);
    }
}

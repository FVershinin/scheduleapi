package ee.vk.edu.ttuscheduleapi;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;

/**
 * Created by fjodor on 8.03.16.
 */
@Converter(autoApply = true)
public class OffsetDateTimeConverter implements AttributeConverter<OffsetDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(OffsetDateTime offsetDateTime) {
        Instant instant = Instant.from(offsetDateTime);
        return Timestamp.from(instant);
    }

    @Override
    public OffsetDateTime convertToEntityAttribute(Timestamp timestamp) {
        Instant instant = timestamp.toInstant();
        return OffsetDateTime.from(instant);
    }
}

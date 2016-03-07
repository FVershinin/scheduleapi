package ee.vk.edu.ttuscheduleapi.model;

import com.google.common.collect.Lists;
import ee.vk.edu.ttuscheduleapi.enums.LessonType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "timetable")
@NamedEntityGraph(name = "timetable.detail", attributeNodes = {@NamedAttributeNode("subject"), @NamedAttributeNode("group"), @NamedAttributeNode("teacher")})
public class Timetable implements Serializable {
    @Id
    @SequenceGenerator(name="timetable_id_seq",sequenceName="timetable_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="timetable_id_seq")
    private Long id;

    @DateTimeFormat
    private OffsetDateTime date;

    @DateTimeFormat
    private OffsetDateTime time_start;

    @DateTimeFormat
    private OffsetDateTime time_end;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "timetable")
    private List<Attendance> attendances = Lists.newArrayList();

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private LessonType lessonType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Group group;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(id, timetable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public Timetable setId(Long id) {
        this.id = id;
        return this;
    }

    public OffsetDateTime getStart() {
        return time_start;
    }

    public Timetable setStart(OffsetDateTime start) {
        this.time_start = start;
        return this;
    }

    public OffsetDateTime getDate(){
        return date;
    }

    public Timetable setDate(OffsetDateTime date){
        this.date = date;
        return this;
    }

    public OffsetDateTime getEnd() {
        return time_end;
    }

    public Timetable setEnd(OffsetDateTime end) {
        this.time_end = end;
        return this;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public Timetable setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
        return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public Timetable setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public Timetable setGroup(Group group) {
        this.group = group;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Timetable setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public Timetable setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
        return this;
    }
}

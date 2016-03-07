package ee.vk.edu.ttuscheduleapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable{

    @Id
    @SequenceGenerator(name="teacher_id_seq",sequenceName="teacher_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="teacher_id_seq")
    private Long id;

    private String fullname;

    @OneToMany
    private List<Timetable> timetables;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public Teacher setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public Teacher setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public Teacher setTimetables(List<Timetable> timetables) {
        this.timetables = timetables;
        return this;
    }
}

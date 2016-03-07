package ee.vk.edu.ttuscheduleapi.model;

import ee.vk.edu.ttuscheduleapi.enums.AttendanceType;

import javax.persistence.*;

/**
 * Created by strukov on 3/7/16.
 */
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @SequenceGenerator(name="attendance_id_seq",sequenceName="attendance_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="attendance_id_seq")
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Timetable timetable;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AttendanceType attendanceType;

    public Long getId() {
        return id;
    }

    public Attendance setId(Long id) {
        this.id = id;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Attendance setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public Attendance setTimetable(Timetable timetable) {
        this.timetable = timetable;
        return this;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public Attendance setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
        return this;
    }
}

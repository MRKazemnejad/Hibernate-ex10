package ir.maktab.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private Integer teacherCode;
    private LocalDate birthday;
    @Column(nullable=false)
    private double salary;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, Integer teacherCode, LocalDate birthday, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherCode = teacherCode;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(Integer teacherCode) {
        this.teacherCode = teacherCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode=" + teacherCode +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

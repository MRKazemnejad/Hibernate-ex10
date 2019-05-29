package ir.maktab.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String city;
    private String state;
    @Column(nullable = false, unique = true)
    private String number;
    private String pstalCode;
    private String postalAddress;
    @OneToOne(mappedBy = "address")
    private Teacher teacher;
    @OneToOne(mappedBy = "address")
    private Student student;

    public Address() {
    }

    public Address(String city, String state, String number, String pstalCode, String postalAddress) {
        this.city = city;
        this.state = state;
        this.number = number;
        this.pstalCode = pstalCode;
        this.postalAddress = postalAddress;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPstalCode() {
        return pstalCode;
    }

    public void setPstalCode(String pstalCode) {
        this.pstalCode = pstalCode;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", number='" + number + '\'' +
                ", pstalCode='" + pstalCode + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                '}';
    }
}

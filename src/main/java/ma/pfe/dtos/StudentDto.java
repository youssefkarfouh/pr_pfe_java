package ma.pfe.dtos;

import ma.pfe.entities.StudentId;

import java.util.List;

public class StudentDto {

    private StudentId studentId;
    private String name;
    List<CoursDto> courses;
    private AdresseDto adresse;

    public List<CoursDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursDto> courses) {
        this.courses = courses;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                ", adresse=" + adresse +
                '}';
    }
}
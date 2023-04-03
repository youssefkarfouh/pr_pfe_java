package ma.pfe.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")

public class StudentEntity {

    // 1 -  comment mapper une clé composé ex => primary key (id + code)
    // we have to create another class containing all the fileds
    @EmbeddedId
    private StudentId StudentId;
    @Column(name = "name_student")
    private String name;

//    to ovveride Adress column names
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rue", column = @Column(name = "rue_student")),
            @AttributeOverride(name = "avenue", column = @Column(name = "avenu_student"))
    })
    private Adresse adresse;


    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentId getStudentId() {
        return StudentId;
    }

    public void setStudentId(StudentId studentId) {
        StudentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "StudentId=" + StudentId +
                ", name='" + name + '\'' +
                ", adresse=" + adresse +
                '}';
    }
}
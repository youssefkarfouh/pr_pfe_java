package ma.pfe.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student")
@Inheritance(strategy = InheritanceType.JOINED)

public class StudentEntity {

    // 1 -  comment mapper une clé composé ex => primary key (id + code)
    // we have to create another class containing all the fileds
    @EmbeddedId
    private StudentId StudentId;
    @Column(name = "name_student")
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE , CascadeType.PERSIST},fetch = FetchType.LAZY)

    @JoinTable(name = "list_cours_students")
    List<CoursEntity> courses;

    //    to ovveride Adress column names
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rue", column = @Column(name = "rue_student")),
            @AttributeOverride(name = "avenue", column = @Column(name = "avenu_student"))
    })
    private AdresseEntity adresse;


    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;

    }

    public List<CoursEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursEntity> courses) {
        this.courses = courses;
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
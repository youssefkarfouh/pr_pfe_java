package ma.pfe.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")

public class StudentEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO) // generate auto id
     private Long id;
     private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

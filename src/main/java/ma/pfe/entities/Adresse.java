package ma.pfe.entities;


import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
    private String rue ;
    private String avenue ;
    private int number ;

    public Adresse(String rue, String avenue, int number) {
        this.rue = rue;
        this.avenue = avenue;
        this.number = number;
    }

    public Adresse() {
    }
}

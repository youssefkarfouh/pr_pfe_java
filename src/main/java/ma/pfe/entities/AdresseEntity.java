package ma.pfe.entities;


import javax.persistence.Embeddable;

@Embeddable
public class AdresseEntity {
    private String rue ;
    private String avenue ;
    private int number ;

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public AdresseEntity() {
    }
}

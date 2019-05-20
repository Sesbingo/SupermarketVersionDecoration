package entity;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {


    private String namesupermarket;
    private List<Rayon> rayons = new ArrayList<Rayon>();

    public Supermarket(String namesupermarket) {
        this.namesupermarket = namesupermarket;
        this.rayons = new ArrayList<Rayon>();
    }


    public void add(Rayon e) {
        rayons.add(e);
    }

    public void remove(Rayon e) {
        rayons.remove(e);
    }


    public List<Rayon> getRayons() {
        return rayons;
    }
}

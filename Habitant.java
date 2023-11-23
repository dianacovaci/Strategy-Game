package assignment1;

public class Habitant extends Person {

    public Habitant(Tile p, double hP, String f){
        super(p, hP, 2, f);
    }

    public void takeAction(Tile target){
        if (getPosition().equals(target) && !target.isCity()){
            target.buildCity();
            getPosition().removePerson(this);
        }
    }

    public boolean equals(Object given){
        if (given instanceof Habitant && super.equals(given)){
            return true;
        }
        return false;
    }
}

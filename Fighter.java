package assignment1;

public class Fighter extends MilitaryPerson {

    public Fighter(Tile p, double hP, String f) {
        super(p, hP, 1, f, 20.0, 1, 25);
    }

    public boolean equals(Object given){
        if (given instanceof Fighter && super.equals(given)){
            return true;
        }
        return false;
    }
}
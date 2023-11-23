package assignment1;

public class Bowman extends MilitaryPerson{
    private int numArrows;

    public Bowman(Tile p, double hP, String f){
        super(p, hP, 2, f, 15.0, 2, 0);
        this.numArrows = 5;
    }

    public void takeAction(Tile target){
        if (numArrows > 0){
            super.takeAction(target);
            numArrows -= 1;
        }
        else {
            numArrows = 5;
        }
    }

    public boolean equals (Object given){
        if (given instanceof Bowman && super.equals(given)){
            Bowman other = (Bowman) given;
            if (other.numArrows == this.numArrows){
                return true;
            }
        }
        return false;
    }
}

package assignment1;

public class Laborer extends Person{
    private int numJobs;

    public Laborer(Tile p, double hP, String f){
        super(p, hP, 2, f);
        this.numJobs = 0;
    }

    public void takeAction(Tile target) {
        if (getPosition().equals(target) && !target.isImproved()) {
            target.buildImprovement();
            numJobs += 1;
            if (numJobs >= 10) {
                getPosition().removePerson(this);
            }
        }
    }

    public boolean equals(Object given) {
        if (given instanceof Laborer && super.equals(given)) {
            Laborer other = (Laborer) given;
            if (other.numJobs == this.numJobs){
                return true;
            }
        }
        return false;
    }
}

package assignment1;

public abstract class Person {
    private Tile position;
    private double hP;
    private int movingRange;
    private String faction;

    public Person(Tile p, double hP, int mR, String f){
        this.position = p;
        this.hP = hP;
        this.movingRange = mR;
        this.faction = f;
        if (!position.addPerson(this)) {
            throw new IllegalArgumentException("Cannot add unit to tile.");
        }
    }

    public final Tile getPosition(){
        return(this.position);
    }

    public final double getHP(){
        return(this.hP);
    }

    public final String getFaction(){
        return(this.faction);
    }

    public boolean moveTo(Tile goal){
        if (goal == null){
            return false;
        }
        double distance = Tile.getDistance(position, goal);
        if (distance <= movingRange && goal.addPerson(this)){
            position.removePerson(this);
            position = goal;
            return true;
        }
        return false;
    }

    public void receiveDamage(double dReceived){
        if (dReceived > 0){
            if (this.position.isCity()) {
                dReceived = (0.90) * dReceived;
            }
            this.hP = this.hP - dReceived;
            if (this.hP <= 0) {
                position.removePerson(this);
            }
        }
    }

    public abstract void takeAction(Tile target);

    public boolean equals(Object given){
        if (given == this){
            return true;
        }
        if (!(given instanceof Person)) {
            return false;
        }
        Person other = (Person) given;
        double x = Math.pow(this.hP - other.hP, 2);
        if( x < 0.001 && (this.faction.equals(other.faction)) && (this.position.equals(other.position))){
                        return true;
        }
        return false;
    }
}

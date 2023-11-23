package assignment1;

public class Tile {
    private int x;
    private int y;
    private boolean city;
    private boolean improvements;
    private ListOfPersons positionedPersons;

    public Tile (int x, int y){
        this.x = x;
        this.y = y;
        this.city = false;
        this.improvements = false;
        this.positionedPersons = new ListOfPersons();
    }

    public int getX(){
        return(this.x);
    }

    public int getY(){
        return(this.y);
    }

    public boolean isCity(){
        return(this.city);
    }

    public boolean isImproved(){
        return(this.improvements);
    }

    public void buildCity(){
        this.city = true;
    }

    public void buildImprovement(){
        this.improvements = true;
    }

    public boolean addPerson(Person toAdd) {
        if (toAdd instanceof MilitaryPerson) {
            String s = toAdd.getFaction();
            MilitaryPerson[] militaries = positionedPersons.getArmy();
            for (MilitaryPerson element: militaries) {
                if (!element.getFaction().equals(s)) {
                    return false;
                }
            }
        }
        positionedPersons.addPerson(toAdd);
        return true;

    }

    public boolean removePerson(Person toRemove){
        boolean x = positionedPersons.removePerson(toRemove);
        return x;
    }

    public Person selectWeakEnemy(String f){
        Person weak = null;
        for (int i=0; i<positionedPersons.getSize(); i++){
            String s = positionedPersons.getList()[i].getFaction();
            if(!f.equals(s)){
                if (weak == null){
                    weak = positionedPersons.getList()[i];
                }
                if (weak.getHP() > positionedPersons.getList()[i].getHP()){
                    weak = positionedPersons.getList()[i];
                }
            }
        }
        return weak;
    }

    public static double getDistance(Tile t1, Tile t2){
        double xAxis = Math.pow(t1.getX() - t2.getX(), 2);
        double yAxis = Math.pow(t1.getY() - t2.getY(), 2);
        double distance = Math.sqrt(xAxis + yAxis);
        return distance;
    }
}
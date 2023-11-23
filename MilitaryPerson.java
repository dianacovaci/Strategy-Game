package assignment1;

public abstract class MilitaryPerson extends Person{
    private double damage;
    private int attackRange;
    private int armor;

    public MilitaryPerson(Tile p, double hP, int mR, String f, double d, int aR, int a){
        super(p, hP, mR, f);
        this.damage = d;
        this.attackRange = aR;
        this.armor = a;
    }

    public void takeAction(Tile target){
        double distance = Tile.getDistance(this.getPosition(), target);
        double damageGiven = this.damage;
        if (distance <= this.attackRange){
            Person enemy = target.selectWeakEnemy(getFaction());
            if (enemy != null){
                //double damage = target.attackDamage;
                if (getPosition().isImproved()){
                    damageGiven = damageGiven*(1.05);
                }
                enemy.receiveDamage(damageGiven);
            }
        }
    }

    public void receiveDamage(double damage){
        double multiplier = 100.0 / (100.0 + armor);
        damage = damage*multiplier;
        super.receiveDamage(damage);
    }
}

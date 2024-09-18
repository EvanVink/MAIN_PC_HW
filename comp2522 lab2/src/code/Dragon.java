public class Dragon extends Creature{


    private int firePower;
    private int health;
    private final String name;
    private final Date dateOfBirth;
    private static final int REDUCE_POWER = 10;
    private static final int MAX_FIRE_POWER = 101;
    private static final int MIN_FIRE_POWER = 0;
    private static final int BREATHE_FIRE_DAMAGE = 20;


    public Dragon(String name, Date dateOfBirth, int health, int firePower) throws LowFirePowerException {
        super(name, dateOfBirth);

        validateFirePower(firePower);

        this.firePower = firePower;
        this.health = health;
        this.name = name;
        setHealth(health);
        this.dateOfBirth = dateOfBirth;
    }


    public void validateFirePower(int firePower){
        if(!(firePower > MIN_FIRE_POWER)){
            throw new LowFirePowerException("Low Fire Power!");
        } else if(!(firePower < MAX_FIRE_POWER)){
            throw new LowFirePowerException("Too much power!");
        }
    }




    @Override
    public void getDetails(){
        System.out.println("This Creature's name is: " + name + ",\n their date of birth is: "
                + dateOfBirth.getDateOfBirth() + ",\n their age is: " + getAgeYears(dateOfBirth)
                + ",\n their health is at: " + getHealth() + ",\n their fire power is: " + firePower + "\n");
    }


    public void breatheFire(Creature targetCreature){
        firePower -= REDUCE_POWER;
        validateFirePower(firePower);
        //minus 20 damage to a creature
        targetCreature.takeDamage(BREATHE_FIRE_DAMAGE);
    }


    public void restoreFirePower(int amount){
        if (firePower + amount > MAX_FIRE_POWER){
            firePower = MAX_FIRE_POWER;
        } else {
            firePower += amount;
        }
    }





}

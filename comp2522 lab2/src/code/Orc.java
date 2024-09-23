public class Orc extends Creature{

    private String name;
    private final Date dateOfBirth;
    private int health;
    private int rage;
    private int damage = 15;
    private int addRage = 5;
    private int MIN_RAGE = 5;


    public Orc(String name, Date dateOfBirth, int health, int rage){
        super(name, dateOfBirth);



        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
        this.rage = rage;
        setHealth(health);

    }


    @Override
    public void getDetails(){
        System.out.println("This Creature's name is: " + name + ",\n their date of birth is: "
                + dateOfBirth.getDateOfBirth() + ",\n their age is: " + getAgeYears(dateOfBirth)
                + ",\n their health is at: " + getHealth() + ",\n their rage is: " + rage + "\n");
    }



    public void berserk(Creature targetCreature){
        if (rage < MIN_RAGE){
            throw new LowRageException("Low rage!");
        }

        rage += addRage;
        int damageDoubleThreshold = 20;
        if (rage >= damageDoubleThreshold){
            damage = damage * 2;
        }

        targetCreature.takeDamage(damage);

    }




}

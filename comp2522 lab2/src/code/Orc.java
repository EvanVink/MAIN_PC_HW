public class Orc extends Creature{

    private String name;
    private Date dateOfBirth;
    private int health;
    private int rage;
    private int damage = 15;
    private int damageDoubleThreshold = 20;
    private int addRage = 5;
    private int MIN_RAGE = 0;
    private int MAX_RAGE = 30;


    public Orc(String name, Date dateOfBirth, int health, int rage){
        super(name, dateOfBirth);

        validateRage(rage);

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


    public void validateRage(int rage){
        if (rage < MIN_RAGE || rage > MAX_RAGE){
            throw new IllegalArgumentException("Invalid rage");
        }
    }

    public void berserk(){
        validateRage(rage);

        rage += addRage;
        if (rage >= damageDoubleThreshold){
            damage = damage * 2;
        }

        System.out.println(rage);

    }




}

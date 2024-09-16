public class Orc extends Creature{

    private String name;
    private Date dateOfBirth;
    private int health;
    private int rage;
    private int damage;


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
        if (rage < 0 || rage > 30){
            throw new IllegalArgumentException("Invalid rage");
        }
    }

    public void berserk(){
        rage += 5;
        if (rage >= 20){
            damage = 20;
        } else if (rage < 5){
            throw new IllegalArgumentException("low rage");
        }

        System.out.println(rage);

    }




}

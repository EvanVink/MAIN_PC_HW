public class Creature {

    private final String name;
    private final Date dateOfBirth;
    private int health;

    Creature(String name, Date dateOfBirth){

        this.dateOfBirth = dateOfBirth;
        this.name = name;


    }

    public void validateNameDate(String name, Date dateOfBirth){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }

        if(dateOfBirth == null){
            throw new IllegalArgumentException("Invalid date");
        }
    }


    public boolean isAlive(){
        return health > 0;
    }

    public void setHealth(int setHealth){
        health = setHealth;
    }

    public int getHealth(){
        return health;
    }


    public void takeDamage(int damage){
        validateDamage(damage);
        health -= damage;
        if(health <= 0){
            setHealth(0);
        }
    }

    public void validateDamage(int damage){
        if(damage < 0){
            throw new IllegalArgumentException("Invalid Damage");
        }
    }


    public void heal(int healAmount){
        validateHeal(healAmount);

        if(this.health + healAmount > 100){
            setHealth(100);
        }

    }

    public void validateHeal(int healAmount){
        if(healAmount < 0){
            throw new IllegalArgumentException("Invalid Heal");
        }
    }


    public int getAgeYears(Date age){
        return age.getCurrentYear() - age.getYear();
    }

    public void getDetails(){
        System.out.println("This Creature's name is: " + name + ",\n their date of birth is: "
                + dateOfBirth.getDateOfBirth() + ",\n their age is: " + getAgeYears(dateOfBirth)
                + ",\n their health is at: " + health + "\n");
    }













}

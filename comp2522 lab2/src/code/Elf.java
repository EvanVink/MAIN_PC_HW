public class Elf extends Creature{

    private final String name;
    private final Date dateOfBirth;
    private int health;
    private int mana;
    private static final int REDUCE_MANA = 5;
    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 51;
    private static final int SPELL_DAMAGE = 10;


    public Elf(String name, Date dateOfBirth, int health, int mana){
        super(name, dateOfBirth);
        validateMana(mana);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
        this.mana = mana;
        setHealth(health);
    }


    public void validateMana(int mana){
        if(!(mana > MIN_MANA && mana < MAX_MANA)){
            throw new LowManaException("oh no");
        }
    }


    @Override
    public void getDetails(){
        System.out.println("This Creature's name is: " + name + ",\n their date of birth is: "
                + dateOfBirth.getDateOfBirth() + ",\n their age is: " + getAgeYears(dateOfBirth)
                + ",\n their health is at: " + getHealth() + ",\n their mana is: " + mana + "\n");
    }

    public void castSpell(Creature targetCreature){
        validateMana(mana);
        mana -= REDUCE_MANA;
        targetCreature.takeDamage(SPELL_DAMAGE);


    }


    public void restoreMana(int amount){
        if (mana + amount > MAX_MANA){
         mana = MAX_MANA;
        } else {
            mana += amount;
        }
    }





}

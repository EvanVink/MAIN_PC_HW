import java.util.Random;


public class creatureHealer extends Creature{

    private final int heal;

    Random rand = new Random();



    creatureHealer(String name, Date dateOfBirth){
        super(name, dateOfBirth);
        this.heal = rand.nextInt();
    }


    public void healCreature(Creature targetCreature){
        if(heal < 0){
            throw new HealingException("healing is negative - Invalid");
        } else {
            targetCreature.heal(heal);
        }
    }




}

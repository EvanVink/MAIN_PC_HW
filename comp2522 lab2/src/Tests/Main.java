public class Main {

    public static void main(final String[] args)throws LowManaException, LowFirePowerException {

        final Creature orc;
        final Creature drag;
        final Creature elf;
        final Creature healer;



        Date dragDOB = new Date(2000, 10, 5);
        Date elfDOB = new Date(1990, 5, 2);
        Date orcDOB = new Date(1900, 8, 23);
        Date healerDOB = new Date(1850, 3, 2);

        drag = new Dragon("Dragon", dragDOB, 100, 10);
        orc = new Orc("Orc", orcDOB, 100, 5);
        elf = new Elf("Elf", elfDOB, 100, 50);
        healer = new creatureHealer("Healer", healerDOB);

        elf.getDetails();
        drag.getDetails();
        orc.getDetails();

        System.out.println(elf.getClass());
        System.out.println(elf instanceof Creature);
        System.out.println(elf instanceof Elf);

        System.out.println("\n");

        System.out.println(drag.getClass());
        System.out.println(drag instanceof Creature);
        System.out.println(drag instanceof Dragon);

        System.out.println("\n");

        System.out.println(orc.getClass());
        System.out.println(orc instanceof Creature);
        System.out.println(orc instanceof Orc);

        System.out.println("\n");

        System.out.println(healer.getClass());
        System.out.println(healer instanceof Creature);
        System.out.println(healer instanceof creatureHealer);


        try {
            if(elf instanceof Elf){
                ((Elf)elf).castSpell(drag);
            }
        } catch(final LowManaException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The Elf has ended his attack");
        }

        try {
            if(drag instanceof Dragon){
                ((Dragon)drag).breatheFire(orc);
            }
        } catch(final LowFirePowerException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The Dragon has ended his attack");
        }

        if(orc instanceof Orc){
            ((Orc)orc).berserk(drag);
        }
        System.out.println("The Orc has ended his attack");

        orc.getDetails();
        try{
            if(healer instanceof creatureHealer){
                ((creatureHealer)healer).healCreature(orc);
            }
        } catch (final HealingException he) {
            System.out.println(he.getMessage());
        } finally {
            System.out.println("The healer has ended his heal");
        }
        orc.getDetails();









    }




}

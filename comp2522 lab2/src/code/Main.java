public class Main {

    public static void main(final String[] args){

        Date dragDOB = new Date(2000, 10, 5);

        Dragon drag = new Dragon("Dragon", dragDOB, 100, 100);



        Date elfDOB = new Date(1990, 5, 2);

        Elf elf = new Elf("Elf", elfDOB, 50, 40);

        Date orcDOB = new Date(1900, 8, 23);

        final Creature orc;

        orc = new Orc("Orc", orcDOB, 200, 0);

        drag.breatheFire(elf);

//        drag.takeDamage(elf.castSpell());
//        elf.takeDamage(drag.breatheFire());


        elf.getDetails();
//        drag.getDetails();
//        orc.getDetails();



    }




}

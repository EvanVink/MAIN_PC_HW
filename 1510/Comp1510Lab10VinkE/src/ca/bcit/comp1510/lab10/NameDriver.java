package ca.bcit.comp1510.lab10;

import java.util.ArrayList;

public class NameDriver {
    

    public static void main(String[] args) throws InterruptedException {
        
        ArrayList<Name> list = new ArrayList<Name>();
        
        
        
        
        Name one = new Name("Evan", "Nickolas", "Vink");
        
        list.add(one);
        

        
        Name two = new Name("Matt", "", "Vink");
        
        list.add(two);
        
        Name three = new Name("Evan", "Nickolas", "Vink");
        
        list.add(three);
        
        
        Name four = new Name("Evan", "", "Vink");
        
        list.add(four);
        
        
        Name five = new Name("Evan", "", "Matt");
        
        list.add(five);
        
        Name six = new Name("Nathan", "pres", "Nathan");
        
        list.add(six);
        
        
        
    
        list.sort(null);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
//            Thread.sleep(1000);
        }
        
        
        
        
        
        

    }

}

package ca.bcit.comp1510.lab10;

public class Name implements Comparable<Name>{

    private final String first;
    
    private final String middle;
    
    private final String last;
    
    
    public Name(String firstN, String middleN, String lastN) {
        
        first = firstN;
        
        middle = middleN;
        
        last = lastN;
        
        
    }
    
    
    public Name(String firstN, String lastN) {
        
        first = firstN;
        
        middle = null;
        
        last = lastN;
        
        
    }


    @Override
    public int compareTo(Name o) {
        
        int compL = 0;
        int compF = 0;
        int compM = 0;
        
        if (!this.last.equals(o.last)) {
            compL = this.last.compareTo(o.last);
            return compL;
        } else if (!this.first.equals(o.first)){
            compF = this.first.compareTo(o.first);
            return compF;
        } else if (!this.middle.equals(o.middle)){
            compM = this.middle.compareTo(o.middle);
            return compM;
        }
        
        
        
        
        
        
        return 0;
    }
    
    
    public String toString() {
        String total = first + ", " + middle + ", " + last;
        return total;
    }
    
    
    
    
}

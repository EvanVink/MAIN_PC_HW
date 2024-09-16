public class Date {


    private final int year;
    private final int month;
    private final int day;

    private static final int CURRENT_YEAR = 2024;


    Date(int year, int month, int day){

        validateDate(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;

    }


    public void validateDate(int year, int month, int day){

        if(year > 2024 && month > 9 && day > 12){
            throw new IllegalArgumentException("invalid date: " + year + " " + month + " " + day);
        }

    }

    public String getDateOfBirth(){
        return day + ", " + month + ", " + year;
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getCurrentYear(){
        return CURRENT_YEAR;
    }


}

package bcit.WordGame;

/**
 * @author Evan Vink
 * @version 1.0
 */
public class Country {

    private final String    name;
    private final String    capitalCityName;
    private final String[]  facts;

    /**
     * initializes the instance variables
     * @param name name of the country
     * @param capitalCityName capital city name of the country
     * @param facts facts of the country
     */
    public Country(final String name, final String capitalCityName, final String[] facts) {
        this.name               = name;
        this.capitalCityName    = capitalCityName;
        this.facts              = facts;
    }

    /**
     * gets the facts array
     * @return returns the facts array
     */
    public String[] getFacts(){
        return facts;
    }

    /**
     * gets the country name
     * @return returns the country name
     */
    public String getName(){
        return name;
    }

    /**
     * gets the capital city name
     * @return returns the capital city name
     */
    public String getCapitalCityName(){
        return capitalCityName;
    }

}

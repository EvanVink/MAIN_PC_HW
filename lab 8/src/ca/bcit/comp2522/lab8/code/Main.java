package ca.bcit.comp2522.lab8.code;

import java.io.IOException;

/**
 * Main driver
 *
 * @author Evan Vink
 * @author Yujin Jeong
 * @version 1.0
 */
public class Main {
    /**
     * main driver
     * @param args unused
     */
    public static void main(final String[] args) {

        final CountryLab data;

        try {
            data = new CountryLab();


            data.longerThanTen();

            data.shorterThanFive();

            data.startsWithA();

            data.endWIthLand();

            data.containUnited();

            data.alphaOrder();

            data.uniqueFirstLetter();

            data.numberOfCountries();

            data.longestCountryName();

            data.shortestCountryName();

            data.namesInUpperCase();

            data.moreThanOneWord();

            data.mapCountriesName();

            data.startWithZ();

            data.longerThanThreeChar();

        } catch (IOException e) {
            System.out.println("error printing the method" + e.getMessage());
        }
    }
}

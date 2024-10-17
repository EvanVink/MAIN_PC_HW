package bcit.WordGame;

abstract class WordGame {

    abstract void playGame();

    abstract void askQuestionCapital();

    abstract boolean verifyCapital(String question, String answer);

    abstract void askQuestionCountry();

    abstract boolean verifyCountry(String question, String answer);

    abstract void askQuestionFact();

    abstract boolean verifyFact(String question, String answer);

}

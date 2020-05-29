import javax.swing.*;

public class Main {

    //INSTANCE VARIABLES
    private static int loss;
    private static int wins;
    private static Card card;
    private static Card card2;
    private static int cardCount;
    static String[] Rank = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static int[] pointValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    static String[] Suit = {"Clover", "Diamond", "Spade", "Hearts"};
    static String[] option1 = {"Higher", "Lower", "Exit"};


    //Main method that gives some of the uninitiliazied variables a value
    public static void main(String[] args) {
        loss = 0;
        wins = 0;
        cardCount = 0;
        //First box of dialog that pops up, explains what the game is about in a joptionpane window
        JOptionPane.showMessageDialog(null, "So uh this is this card game, and you have to guess shit\nLike whether the current card is higher or lower than the next\nIm uncultured so hopefully i did this crap correctly");
        //Creates a new deck(for display)
        Decks deck = new Decks(Rank, Suit, pointValue);
        //The game will run as long as there is less than 26 cards and they lose less than 3 times
        while (cardCount < 26 && loss < 3) {
            card = deck.deal();
            card2 = deck.deal();
            //Records the option the user selects when guessing if higher or lower
            int x = Window.option(option1, "This guy is higher or lower?\nAmount Correct: " +wins + "\n" + card);
            //When user selects higher, tells them if they were right wrong or the numbers were the same
            //Shows them the true value of the card
            if (x == 0) {
                if(card.pointValue() == card2.pointValue()){
                    JOptionPane.showMessageDialog(null, "They were somehow the same, im lazy");
                }
                else if (card.pointValue() > card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Tf you were correct?, The card was " + card2);
                    wins++;
                } else {
                    JOptionPane.showMessageDialog(null, "WRONG lol, The card was " + card2);
                    loss++;
                }
            }
            //When user selects lower, tells them if they were right wrong or the numbers were the same
            //Shows them the true value of the card
            if (x == 1) {
                if(card.pointValue() == card2.pointValue()){
                    JOptionPane.showMessageDialog(null, "They were somehow the same, im lazy");
                }
                else if (card.pointValue() < card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Tf you were correct?, The card was " + card2);
                    wins++;
                } else {
                    JOptionPane.showMessageDialog(null, "WRONG lol, The card was " + card2);
                    loss++;
                }
            }
            //If they select exit, closes the game
            if (x == 2) {
                System.exit(0);
            }

        }
        //When the user loses 3 times it will give them a message and end the game for them
        if(loss == 3){
            JOptionPane.showMessageDialog(null, "Apparently you lose at 3 guesses wrong, thats what you got.,\nR.I.P.\nDamn you got " + wins + "correct..");
        }
        //When the user goes through all the cards it gives them a "win" message and ends the game for them
        if(cardCount == 26){
            JOptionPane.showMessageDialog(null, "What the fuck. You went through fucking 52 cards with somehow only fucking up " + loss +" times \nNice?");
        }
    }
}



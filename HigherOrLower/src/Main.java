import javax.swing.*;

public class Main {

    private static int loss;
    private static int wins;
    private static Card card;
    private static Card card2;
    private static int cardCount;
    static String[] Rank = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static int[] pointValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    static String[] Suit = {"Clover", "Diamond", "Spade", "Hearts"};
    static String[] option1 = {"Higher", "Lower", "Exit"};


    public static void main(String[] args) {
        loss = 0;
        wins = 0;
        cardCount = 0;
        JOptionPane.showMessageDialog(null, "So uh this is this card game, and you have to guess shit\nLike whether the current card is higher or lower than the next\nIm uncultured so hopefully i did this crap correctly");

        Decks deck = new Decks(Rank, Suit, pointValue);
        while (cardCount < 26 && loss < 3) {
            card = deck.deal();
            card2 = deck.deal();
            int x = Window.option(option1, "This guy is higher or lower?\nAmount Correct: " +wins + "\n" + card);

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

            if (x == 2) {
                System.exit(0);
            }

        }
        if(loss == 3){
            JOptionPane.showMessageDialog(null, "Apparently you lose at 3 guesses wrong, thats what you got.,\nR.I.P.\nDamn you got " + wins + "correct..");
        }
        if(cardCount == 26){
            JOptionPane.showMessageDialog(null, "What the fuck. You went through fucking 52 cards with somehow only fucking up " + loss +" times \nNice?");
        }
    }
}




//option 3 or 2 (Still deciding)
/* Sources : https://www.britannica.com/topic/playing-card/National-decks 
https://intranet.missouriwestern.edu/cas/wp-content/uploads/sites/17/2020/05/Standard-Deck-of-Cards.pdf
https://stackoverflow.com/questions/65115441/java-shuffle-deck-using-math-random */
public class ExampleClass {
    public static void main(String[] args) {
        System.out.println("Test");
        Card c = new Card("Queen", "Hearts", 12);
        Card c2 = new Card("Ace", "Clubs", 11);
        Card c3 = new Card("10", "Spades", 10);
        Card c4 = new Card("Jack", "Diamonds", 9);

        System.out.println(c); //PRINTS Queen of Hearts
        System.out.println(c.getName()); //PRINTS Queen
        System.out.println(c.getSuit()); //PRINTS Hearts
        System.out.println(c.getValue()); // PRINTS 12
        System.out.println(c.equals(c2)); //PRINTS false
        System.out.println(c.equals(null)); //PRINTS false
        Card[] arr = {c, c2, c3, c4};
        Deck d = new Deck(arr);
        System.out.println("Prior to shuffling: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        d.shuffle();

        System.out.println("After shuffling: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("Deck size: " + d.size()); //PRINTS Deck size: 4
        System.out.println("Drawn: " + d.draw()); //Draws *(any top card after shuffle)*
        System.out.println("Current deck size: " + d.size()); //New deck size should print "Current deck size: 3"
        Deck testDeck = new Deck();
        System.out.println(testDeck.size());
        System.out.println(testDeck.draw());
        System.out.println(testDeck.draw());
        System.out.println(testDeck.draw());
        System.out.println(testDeck.draw());
        Deck testDeck2 = new Deck ();
        testDeck2.shuffle();
        System.out.println("Shuffled! The top card drawn is: " + testDeck2.draw());
        System.out.println(testDeck2.size()); //size after drawing a card: x - 1 where x <= 52.; full standard deck
        Deck testDeck3 = new Deck(arr);
        System.out.println(testDeck3.size());
        testDeck3.addCard(new Card("King", "Hearts", 13));
        System.out.println(testDeck3.size()); //size increase by 1; addCard. it should put new card at the bottom of deck.
        Deck testDeck4 = new Deck(arr);
        System.out.println(testDeck4.size());
        Card c5 = new Card("3", "Spades", 2);
        Card c6 = new Card("7", "Diamonds", 3);
        Card[] newCards = {c5, c6};
        testDeck4.reshuffle(newCards);      
        System.out.println(testDeck4.size());
        /* current output: 
        Test
        Queen of Hearts
        Queen
        Hearts 
        12
        false
        false
        Prior to SHuffling: 
        Queen of Hearts
        Ace of Clubs
        10 of Spades
        Jack of Diamonds
        After shuffling:
        10 of Spades
        Ace of Clubs
        Queen of Hearts
        Jack of Diamonds
        Deck size: 4
        Drawn: 10 of Spades
        Current deck size: 3
        52
        Ace of Hearts
        2 of Hearts
        3 of Hearts
        4 of Hearts
        Shuffled! The top card drawn is: King of Hearts
        51
        4
        5
        4
        6

        Note: Shuffling is random so it'll print different outputs every time and this is js one instance
        */
    }
	
}

class Card {
private String name;
private String suit;
private int value;

Card(String a, String b, int f) {
    name = a;
    suit = b;
    value = f;
}
public String toString() {
    return name + " of " + suit;
}
public String getName() {
    return name;
}
public String getSuit() {
    return suit;
}
public int getValue() {
    return value;
}
public boolean equals(Card other) {
    if (other == null) {
        return false;
    }
    boolean sameName = this.getName().equals(other.getName());
    boolean sameSuit = this.getSuit().equals(other.getSuit());
    boolean sameValue = this.getValue() == (other.getValue());
    if (sameName && sameSuit && sameValue) {
        return true;
    } else {
        return false;
    }
}
}
class Deck {
    private Card[] cards;
    public Deck(Card[] c) {
        cards = c;
    }
    public Deck () {
        cards = new Card[52];
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
     int index = 0; 
    for (int a = 0; a < suits.length; a++) {
        for (int b = 0; b < names.length; b++) {
            int value = b + 1;
            cards[index] = new Card(names[b], suits[a], value);
            index++;
        }
    }
    };
    public int size() {
        return cards.length;
    }
    public Card draw() {
        if (cards.length == 0) {
            return null;
        }
        Card top = cards[0]; //top card = index 0
        Card[] newArr = new Card[cards.length - 1]; //makes a new array one size smaller AND then...

        for (int i = 1; i < cards.length; i++) {
            newArr[i-1] = cards[i]; //then copies EVERYTHINg except for the index 0 (aka first card), so it basically discards top card
        }
        cards = newArr;
        return top;
    }
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int random = (int)(Math.random() * cards.length);
            Card temp = cards[i];
            cards[i] = cards[random];
            cards[random] = temp;
        }
    }
      public void addCard(Card card) {
            if (card == null) {
                return;
            }
            Card[] newArr = new Card[cards.length + 1];
            for (int i = 0; i < cards.length; i ++) {
                newArr[i] = cards[i];
            }
            newArr[cards.length] = card;
            cards = newArr;
        }
        public void reshuffle(Card[] newCards) {
            if (newCards == null || newCards.length == 0) {
                shuffle();
                return;
            }
                Card[] newArr = new Card[cards.length + newCards.length];
                for (int i = 0; i < cards.length; i++) {
                    newArr[i] = cards[i];
                }
                for (int k = 0; k < newCards.length; k++) {
                    newArr[cards.length + k] = newCards[k];
                }
                cards = newArr;
                shuffle();
            
        }
    class DiscardPile {
        private Card[] pile; //holds discarded cards
        public DiscardPile(Card[] cards) {
            pile = cards;
        }
        public DiscardPile() {
            pile = new Card[0]; //empty disc. pile
        }
        public int size() {
            return pile.length;
        }
        public Card[] getPile() {
            return pile;
        }
    }
}
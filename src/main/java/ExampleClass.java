
//option 3 or 2 (Still deciding)
/* Sources : https://www.britannica.com/topic/playing-card/National-decks 
inspirations: https://stackoverflow.com/questions/65115441/java-shuffle-deck-using-math-random */
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
        System.out.println(c.equals(c2)); //PRINTS true
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
        System.out.println("Drawn: " + d.draw()); //Draws Ace of Clubs (any top card)
        System.out.println("Current deck size: " + d.size()); //New deck size should print "Current deck size: 3"
        /* current output: 
        Test
        Queen of Hearts
        Queen
        Hearts 
        12
        true
        false
        Prior to SHuffling: 
        Queen of Hearts
        Ace of Clubs
        10 of Spades
        Jack of Diamonds
        After shuffling:
        Ace of Clubs
        Queen of Hearts
        10 of Spades
        Jack of Diamonds
        Deck size: 4
        Drawn: Queen of Hearts
        Current deck size: 1

        Note: Shuffling is random so it'll print different outputs every time. (obviously...)
        */
    }
	
}

class Card {
private String name;
private String suit;
private int value;

Card(String n, String s, int v) {
    name = n;
    suit = s;
    value = v;
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
}
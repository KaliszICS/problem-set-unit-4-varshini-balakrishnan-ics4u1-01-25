
//Option: 2 (up to 90%)
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
        DiscardPile discPile = new DiscardPile(); 
        discPile.addCard(c);
        System.out.println(discPile.removeCard(c));
        System.out.println(discPile.size());

        DiscardPile discPile2 = new DiscardPile();
        discPile2.addCard(c2);
        discPile2.addCard(c3);
        Card[] removed = discPile2.removeAll();
        System.out.println(removed.length);
        System.out.println(discPile2.size());
        System.out.println(removed[0]);
        System.out.println(removed[1]);

        DiscardPile stringTestpile = new DiscardPile();
        stringTestpile.addCard(c);
        stringTestpile.addCard(c2);
        stringTestpile.addCard(c3);
        System.out.println("Discard Pile has: " + stringTestpile.toString());

        Player one = new Player("Kafka", 23);
        Player two = new Player("Firefly", 17, arr);
        System.out.println("Player one: " + one.getName() + ", " + one.getAge() + ", " + one.size());
        System.out.println("Player two: " + two.getName() + ", " + two.getAge() + ", " + two.size());

        System.out.println("Player 1's hand size: " + one.size());
        one.draw(testDeck);
        one.draw(testDeck); //draws two times
        System.out.println("Player 1's new hand size: " + one.size());

        two.discardCard(c2, discPile);
        System.out.println(discPile.size());

        System.out.println(two.size());
        boolean work = two.returnCard(c3, d);
        System.out.println(work);
        System.out.println(two.size());
        System.out.println(d.size());

        System.out.println("Ready Player 1!: " + one.toString());
        System.out.println("Ready Player 2!: " + two.toString());

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
        After shuffling: *random*
        10 of Spades
        Ace of Clubs
        Queen of Hearts
        Jack of Diamonds
        Deck size: 4
        Drawn: 10 of Spades *random*
        Current deck size: 3
        52
        Ace of Hearts
        2 of Hearts
        3 of Hearts
        4 of Hearts
        Shuffled! The top card drawn is: King of Hearts *random*
        51 
        4
        5
        4
        6
        Queen of Hearts
        0
        2
        0
        Ace of Clubs
        10 of Spades
        Discard Pile has: Queen of Hearts, Ace of Clubs, 10 of Spades
        Player one: Kafka, 23, 0
        Player two: Firefly, 17, 4
        Player 1's hand size: 0
        Player 1's new hand size: 2
        1
        3
        true
        2
        4
        Ready Player 1!: Kafka, 23, 5 of Hearts, 6 of Hearts *
        Ready Player 2!: Firefly, 17, Queen of Hearts, Jack of Diamonds *

        *random* Note: Shuffling is random so it'll print different outputs every time and this is just one instance
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
    public void addCard(Card card) {
        if (card == null) {
            return;
        }

        Card[] newArr = new Card[pile.length + 1];
        for(int i = 0; i < pile.length; i++) {
            newArr[i] = pile[i];
        }
        newArr[pile.length] = card;
        pile = newArr;
    }
    public Card removeCard(Card card) {
        if (card == null) { //like aforementioned, nothing given = nothing that we can remove
            return null;
        }
        int index = -1;
        for (int i = 0; i < pile.length; i++) {
            if(pile[i].equals(card) && index == -1) {
                index = i;
            }
            }
            if (index == -1) {
                return null;
            }
            Card removed = pile[index];
            Card[] newArr = new Card[pile.length - 1];
            int index1 = 0;
            for (int i = 0; i < pile.length; i++) {
                if ( i!= index) {
                    newArr[index1] = pile[i];
                    index1++;
                }
            }
            pile = newArr;
            return removed;
        }
        public Card[] removeAll() {
            if(pile.length == 0) {
                return new Card[0]; //when pile is empty, returns empty array
            }
            Card[] discardedCards = pile; //supposed to save current pile
            pile = new Card[0];
            return discardedCards; //returns og pile
        }
        public String toString() {
            if (pile.length ==0) {
            return ""; //if the pile is empty, returns a blank
            }
            String result = "";
            for (int i = 0; i < pile.length; i ++) {
                result = result + pile[i];
                if (i != pile.length - 1) {
                    result = result + ", "; //adds a comma only if the card isnt the last one
                }
            }
            return result;
        }
    }
class Player {
    private String name;
    private int age;
    private Card[] hand;

    public Player(String n, int a, Card[] h) {
        name = n;
        age = a;
        hand = h;
    }
    public Player(String n, int a) {
        name = n;
        age = a;
        hand = new Card[0];
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Card[] getHand() {
        return hand;
    }
    public int size() {
        return hand.length;
    }
    public void draw(Deck deck) {
        Card drawn = deck.draw(); //removes top card from deck
        if (drawn == null) {
            return;
        }
        Card[] newHand = new Card[hand.length + 1];
        for(int i = 0; i < hand.length; i ++) {
        newHand[i] = hand[i];
        }
    newHand[hand.length] = drawn;
    hand = newHand;
    }
    public void discardCard(Card card, DiscardPile discardPile) {
        if (card == null || discardPile == null) {
            return;
        }
        int index = -1;
        for (int i = 0; i < hand.length; i ++) {
            if (hand[i].equals(card)) {
                index = i;
            }
        }
        if (index == -1) {
            return;
        }
        discardPile.addCard(card); //adds card to discard pile
        Card[] newHand = new Card[hand.length - 1];
        int j = 0;
        for (int i = 0; i < hand.length; i ++) {
            if (i != index) {
                newHand[j] = hand[i];
                j++;
            }
        }
        hand = newHand;
    }
    public boolean returnCard(Card card, Deck deck) {
        if (card == null || deck == null) {
            return false;
        }
        int index = -1;
        for (int prevIndex = 0; prevIndex < hand.length; prevIndex++) {
            if (hand[prevIndex].equals(card) && index == -1) {
                index = prevIndex;
            }
        }
        Card[] prevHand = hand;
        Card[] newHand = new Card[hand.length - 1];
        int newIndex = 0;

        for (int prevIndex = 0; prevIndex < prevHand.length; prevIndex++) {
            if (prevIndex != index) {
                newHand[newIndex] = prevHand[prevIndex];
                newIndex++;
            }
        }
        hand = newHand;
        deck.addCard(card); //adds card back to the deck
        return true;
    }
    public String toString() {
        String result = name + ", " + age + ", ";
        for (int i = 0; i < hand.length; i ++) {
            result = result + hand[i];
            if (i != hand.length - 1) {
                result = result + ", ";
            }
        }
        return result;
    }
}


    

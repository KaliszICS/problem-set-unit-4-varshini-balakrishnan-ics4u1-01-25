
//option 3 (Still deciding)
public class ExampleClass {
    public static void main(String[] args) {
        System.out.println("Test");
        Card c = new Card("Queen", "Hearts", 12);
        Card c2 = new Card("Queen", "Hearts", 12);

        System.out.println(c); //queen of hearts
        System.out.println(c.getName()); //queen
        System.out.println(c.getSuit()); //hearts
        System.out.println(c.getValue()); //12
        System.out.println(c.equals(c2)); //false 
        System.out.println(c.equals(null)); //=false
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

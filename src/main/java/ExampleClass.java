
//option 3 (Still deciding)
public class ExampleClass {
    public static void main(String[] args) {
        System.out.println("Test");
        Card c = new Card("Queen", "Hearts", 12);
        System.out.println(c);
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
public String tostring() {
    return "";
}
}
package e_CardsEnumClass;

public class card {
	value Value;
	suit Suit;
	public card(value Value, suit Suit){
		this.Value = Value;
		this.Suit = Suit;
	}
	public String toString(){
		return Value+" of "+Suit;
	}
}

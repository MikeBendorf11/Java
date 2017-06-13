package e_CardsEnumClass;

public class printCard {
	public static void main (String[]args){
		value Value = value.ACE;
		suit Suit = suit.CLUBS;
		card mycard= new card(Value,Suit);
		//System.out.println(mycard);
		for(value Value2:value.values()){
			for(suit Suit2:suit.values()){
				card myCard2 = new card (Value2,Suit2);
				System.out.println(myCard2);
			}
		}
	}
}
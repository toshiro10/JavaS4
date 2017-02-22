package toshiro10.E54.blackJackHandTest;

import toshiro10.E54.cards.Card;
import toshiro10.E54.cards.Deck;
import toshiro10.E54.hand.BlackjackHand;

public class TestBlackJackHand {
	public static void main(String[] args) {
		Deck deck = new Deck(); 
		String again ="";
		boolean replay = true;
		while(replay){
			BlackjackHand bjhand = new BlackjackHand();
			deck.shuffle();
			int valeur = 2+(int)(Math.random()*5);
			System.out.println("Number of card to deal = " + valeur);
			deck.dealCard();
			for (int i = 0;i<valeur; ++i ){
				Card card =deck.dealCard();
				bjhand.addCard(card);
				System.out.println("Value of the card = " + card.getValue());
			}
			System.out.println("The value of your hand is = " + bjhand.getBlackjackValue());
			System.out.println("Type \"again\" if you want to continue ");
			again = TextIO.getWord();
			if (again.compareTo("again")==0)
				replay =true;
			else 
				replay = false;
		}

	}
}

package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	Hand hand = new Hand();
	boolean win = true;

	public List<Card> getStartingHand(List<Card> deck) {
		List<Card> startingHand = new ArrayList<>();
		startingHand.add(deck.remove(0));
		startingHand.add(deck.remove(0));
		return startingHand;
	}
//	public boolean winCondition(List<Card> dealerHand) {
//		if (hand.calculateHandValue(dealerHand) == 21) {
//			return win;
//		}
//		else return false;
//	}
}

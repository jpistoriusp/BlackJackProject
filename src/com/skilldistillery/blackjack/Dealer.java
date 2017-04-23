package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	Hand hand = new Hand();

	public List<Card> getStartingHand(List<Card> deck) {
		List<Card> startingHand = new ArrayList<>();
		startingHand.add(deck.remove(0));
		startingHand.add(deck.remove(0));
		return startingHand;
	}

}

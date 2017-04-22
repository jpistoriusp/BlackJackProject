package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	int value;
	List<Card> deck = new ArrayList<Card>();

	public int calculateHandValue(List<Card> hand) {
		for (Card card : hand) {
			value = value + card.getValue();
		}
		return value;
	}

	public void displayHand() {

	}
}

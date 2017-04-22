package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	public List<Card> generate_52_Cards() {
		List<Card> deck = new ArrayList<Card>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}
}

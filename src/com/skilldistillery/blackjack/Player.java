package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;

	public List<Card> getStartingHand(List<Card> deck) {
		List<Card> startingHand = new ArrayList<>();
		startingHand.add(deck.remove(0));
		startingHand.add(deck.remove(0));
		return startingHand;
	}
	
	public List<Card> hit(List<Card> player, List<Card> deck) {
		player.add(deck.remove(0));
		return player;
	}

	public void placeWadger() {
		
	}
}

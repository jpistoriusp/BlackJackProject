package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	boolean win = true;
	Hand hand = new Hand();

	public List<Card> getStartingHand(List<Card> deck) {
		List<Card> startingHand = new ArrayList<>();
		startingHand.add(deck.remove(0));
		startingHand.add(deck.remove(0));
		return startingHand;
	}
	
	
	public List<Card> playerChoosesToHit(List<Card> player, List<Card> deck) {
		//check for deck return.
		player.add(deck.remove(0));
		System.out.println(player.get(2).getValue());
		return player;
	}

	public void placeWadger() {
		
	}
}

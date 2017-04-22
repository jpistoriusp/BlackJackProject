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
	
//	public boolean winCondition(List<Card> playerHand) {
//		if (hand.calculateHandValue(playerHand) == 21) {
//			return win;
//		}
//		else return false;
//	}
	
	public List<Card> playerChoosesToHit(List<Card> player, List<Card> deck) {
		//check for deck return.
		player.add(deck.remove(0));
		return player;
	}

	public void placeWadger() {
		
	}
}

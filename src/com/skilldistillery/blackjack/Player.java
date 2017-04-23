package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {


	boolean win = true;
	Hand hand = new Hand();
//	Deck deck = new Deck();
//	Dealer dealer;

	public List<Card> getStartingHand(List<Card> deck) {
		List<Card> startingHand = new ArrayList<>();
		startingHand.add(deck.remove(0));
		startingHand.add(deck.remove(0));
		return startingHand;
	}
		
	public boolean blackjackCheck(List<Card> h) {
		if (hand.getHandValue(h) == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public void receiveOneCardFromDealer(Card card) {
		hand.addCard(card);
//		return hand;
	}

	public void placeWadger() {
		
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
}

package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dealer {
	Hand hand = new Hand();
	Card card = new Card();
	Deck deck;
	
	public Dealer(){
		deck = new Deck();
		deck.createDeckFromCards();
	}
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand ha) {
		this.hand = ha;
	}
	
	public List<Card> getStartingHand() {
		List<Card> startingHand = new ArrayList<>();
		hand.addCard(deck.getDeck().remove(0));
		startingHand.add(deck.getDeck().remove(0));
		hand.addCard(deck.getDeck().remove(0));
		startingHand.add(deck.getDeck().remove(0));
		return startingHand;
	}
	
	public Card dealOneCardFromDeck() {
		return deck.getDeck().remove(0);
	}
	
	public void addOneCardToHand(Card card) {
		hand.addCard(card);
	}
	
	public boolean returnsTrueIfDealerHasBlackjack(List<Card> h) {
		if (hand.getHandValue(h) == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public void shuffleDeck(Deck deck) {
		this.deck = deck;
		Collections.shuffle(deck.getDeck());
	}

}

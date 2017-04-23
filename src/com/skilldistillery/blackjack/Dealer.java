package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dealer {
	Hand ha = new Hand();
	Deck deck;
	Card card = new Card();
	
	public Dealer(){
		deck = new Deck();
		deck.createDeckFromCards();
	}
	public Hand getHa() {
		return ha;
	}
	
	public void setHa(Hand ha) {
		this.ha = ha;
	}
	
	public List<Card> getStartingHand() {
		List<Card> startingHand = new ArrayList<>();
		startingHand.add(deck.getDeck().remove(0));
		startingHand.add(deck.getDeck().remove(0));
		System.out.print("Deck Size: ");
		deck.printSize();
		return startingHand;
	}
	
	public Card dealOneCardFromDeck() {
//		card.add(deck.getDeck().remove(0));
//		System.out.print("Deck Size: ");
//		deck.printSize();
		return deck.getDeck().remove(0);
	}
	
	public void blackjackCheck(List<Card> hand) {
		System.out.println("\nDealer is checking for blackjack...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException exp) {
		}
		if (ha.getHandValue(hand) == 21) {
			System.out.println("Dealer has blackjack. You lose.");
			System.exit(0);
		} else {
			System.out.println("Dealer does not have blackjack.");
		}
	}
	public void shuffleDeck(Deck deck) {
		this.deck = deck;
		Collections.shuffle(deck.getDeck());
	}

}

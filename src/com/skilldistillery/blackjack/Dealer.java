package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dealer {
	Hand ha = new Hand();

	public List<Card> getStartingHand(List<Card> deck) {
		List<Card> startingHand = new ArrayList<>();
		startingHand.add(deck.remove(0));
		startingHand.add(deck.remove(0));
		return startingHand;
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

}

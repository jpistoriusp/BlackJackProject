package com.skilldistillery.blackjack;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBlackJack {
	public static void main(String[] args) {
		TestBlackJack tbj = new TestBlackJack();
		tbj.play();
	}

	public void play() {
		Scanner kb = new Scanner(System.in);
		Deck de = new Deck();
		Player player = new Player();
		Dealer dealer = new Dealer();
		Hand hand = new Hand();
		List<Card> playerHand = new ArrayList<>();
		List<Card> dealerHand = new ArrayList<>();
		List<Card> deck = new ArrayList<>();

		deck = de.generate_52_Cards();
		Collections.shuffle(deck);
		playerHand = player.getStartingHand(deck);
		dealerHand = dealer.getStartingHand(deck);
		System.out.println("dealer shows" + dealerHand.get(0));
		System.out.println("Hidden card:" + dealerHand.get(1));
		System.out.println("player hand" + playerHand);

		// displays value of first card
		// System.out.println(dealerHand.get(0).getValue());
		// displays value of total hand
		// System.out.println(hand.calculateHandValue(dealerHand));
		while (!(hand.calculateHandValue(dealerHand) >= 21))

			System.out.println("Would you like to hit? (y or n) ");
		String choice = kb.next();
		while (choice.toLowerCase() == "y") {
			player.hit(playerHand, deck);
			if (hand.calculateHandValue(playerHand) < 21)
				System.out.println("Would you like to hit? (y or n) ");
		}
	}

	// else {
	// playerHand.getValue();
	// }
}

// }

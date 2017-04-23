package com.skilldistillery.blackjack;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBlackJack {
	Scanner kb = new Scanner(System.in);
	Hand hand = new Hand();
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck de = new Deck();
	List<Card> playerHand = new ArrayList<>();
	List<Card> dealerHand = new ArrayList<>();
	List<Card> deck = new ArrayList<>();

	public static void main(String[] args) {
		TestBlackJack tbj = new TestBlackJack();
		tbj.play();
	}

	public void play() {
		// Add comments to code//
		Scanner kb = new Scanner(System.in);
		deck = de.generate_52_Cards();
		Collections.shuffle(deck);
		playerHand = player.getStartingHand(deck);
		dealerHand = dealer.getStartingHand(deck);
		System.out.print("Dealer hand: ");
		hand.displayFirstCard(dealerHand);
//		System.out.println(" Hidden card:" + dealerHand.get(1).getRank());
		System.out.print("Player hand: ");
		hand.displayCurrentHand(playerHand);

		if (hand.getHandValue(dealerHand) == 21) {
			System.out.println("Dealer has blackjack. You lose.");
		} else {
			playerChoosesToHitOrStay();
		}
	}

	// check to see if it is needed to pass Lists.
	public void playerChoosesToHitOrStay() {
		while (hand.getHandValue(playerHand) < 21) {
			System.out.println("\nWould you like to hit? (y or n) ");
			String choice = kb.next();
			if (choice.toLowerCase().equals("y")) {
				playerHand.add(deck.remove(0));
				System.out.println("Your drew a: " + playerHand.get(playerHand.size() - 1).getValue());
				hand.displayCurrentHand(playerHand);
				if (hand.getHandValue(playerHand) > 21) {
					System.out.println("You busted! Dealer wins.");
					System.exit(0);
				}
				playerChoosesToHitOrStay();
			} else {
			comparePlayerHandToDealerHand();
			break;
			}
		} 
		if (hand.getHandValue(playerHand) == 21) {
			System.out.println("BlackJack! You win!");
		}
	}

	public void comparePlayerHandToDealerHand() {
		if (hand.getHandValue(playerHand) == hand.getHandValue(dealerHand)) {
			System.out.println("The result is a push.");
			System.out.println(playerHand);
			System.out.println(dealerHand);
		} else if (hand.getHandValue(playerHand) < hand.getHandValue(dealerHand)) {
			System.out.println("You lose.");
			System.out.println("Player:" + hand.getHandValue(playerHand));
			System.out.println("Dealer:" + hand.getHandValue(dealerHand));
		} else if (hand.getHandValue(playerHand) > hand.getHandValue(dealerHand)) {
			if (hand.getHandValue(playerHand) == 21) {
				System.out.println("Blackjack!");
				System.out.println("test");
			}
			System.out.println("You win!");
			System.out.println(playerHand);
			System.out.println(dealerHand);
		}
	}
}
// displays value of first card
// System.out.println(dealerHand.get(0).getValue());
// displays value of total hand
// System.out.println(hand.calculateHandValue(dealerHand));
package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestBlackJack {
	Scanner kb = new Scanner(System.in);
	Hand hand = new Hand();
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();
	List<Card> playerHand = new ArrayList<>();
	List<Card> dealerHand = new ArrayList<>();
//	List<Card> deck = new ArrayList<>();

	public static void main(String[] args) {
		TestBlackJack tbj = new TestBlackJack();
		tbj.play();
	}

	public void play() {
		// Add comments to code//
		Scanner kb = new Scanner(System.in);
//		deck = de.createDeckFromCards();
		deck.createDeckFromCards();
		dealer.shuffleDeck(deck);
		
		playerHand = dealer.getStartingHand();
		dealerHand = dealer.getStartingHand();
		
		System.out.print("Dealer hand: ");
		hand.displayFirstCard(dealerHand);
		System.out.print("Player hand: ");
		hand.displayHand(playerHand);
		if (dealerHand.get(0).getValue() >= 10) {
			dealer.blackjackCheck(dealerHand);
		}
		playerChoosesToHitOrStay();
	}

	public void playerChoosesToHitOrStay() {
		while (hand.getHandValue(playerHand) < 21) {
			System.out.println("\nWould you like to hit? (y or n) ");
			String choice = kb.next();
			if (choice.toLowerCase().equals("y")) {
 				player.receiveOneCardFromDealer(dealer.dealOneCardFromDeck());
				System.out.print("Your drew a: ");
				hand.displayLastCard(playerHand);
				hand.displayHand(playerHand);
				if (hand.getHandValue(playerHand) > 21) {
					System.out.println("\nYou busted! Dealer wins.");
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
			System.out.print("Dealer:");
			hand.displayHand(dealerHand);
			System.out.print("\nPlayer:");
			hand.displayHand(playerHand);
			System.out.println("The result is a push.");
		} else if (hand.getHandValue(playerHand) < hand.getHandValue(dealerHand)) {
			System.out.print("Dealer:");
			hand.displayHand(dealerHand);
			System.out.print("\nPlayer:");
			hand.displayHand(playerHand);
			System.out.println("You lose.");
		} else if (hand.getHandValue(playerHand) > hand.getHandValue(dealerHand)) {
			if (hand.getHandValue(playerHand) == 21) {
				System.out.println("21!");
			}
			System.out.print("Dealer:");
			hand.displayHand(dealerHand);
			System.out.print("\nPlayer:");
			hand.displayHand(playerHand);
			System.out.println("You win!");
		}
	}
}

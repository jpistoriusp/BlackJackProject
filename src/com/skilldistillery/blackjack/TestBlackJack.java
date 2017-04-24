package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestBlackJack {
	Scanner kb = new Scanner(System.in);
	Hand hand = new Hand();
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();
	List<Card> playerHand = new ArrayList<>();
	List<Card> dealerHand = new ArrayList<>();
	// List<Card> deck = new ArrayList<>();

	public static void main(String[] args) {
		TestBlackJack tbj = new TestBlackJack();
		tbj.play();
	}

	public void play() {
		// A 52 card deck is created and shuffled by the dealer.
		deck.createDeckFromCards();
		dealer.shuffleDeck(deck);

		// Player receives starting hand from the dealer
		player.getHand().setHand(dealer.getStartingHand());

		// Prints out the initial hands for the player and dealer.
		System.out.print("Dealer hand: ");
		hand.displayFirstCard(dealer.getHand().getHand());
		System.out.print("Player hand: ");
		hand.displayHand(player.getHand().getHand());

		// Checks to see if dealer has blackjack. If dealer has blackjack the
		// game ends immediately. If not the game continues.
		if (dealer.getHand().getHand().get(0).getValue() >= 10) {
			System.out.println("\nDealer is checking for blackjack...");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException exp) {
			}
			if (dealer.blackjackCheck(dealer.getHand().getHand())) {
				System.out.println("Dealer has blackjack. You Lose.");
			} else {
				System.out.println("Dealer does not have blackjack.");
			}
		}
		playerChoosesToHitOrStay();
		if (hand.getHandValue(player.getHand().getHand()) <= 21) {
			dealerHitsUntilHandValueIs17();
		}
		if (hand.getHandValue(player.getHand().getHand()) < 21 && hand.getHandValue(dealer.getHand().getHand()) < 21) {
			winCondition();
		}
		System.out.println("\nWould you like to play again? (y/n): ");
		String choice = kb.next();
		if (choice.toLowerCase().equals("y")) {
			deck.clearDeck();
			play();
		}
	}

	public void playerChoosesToHitOrStay() {
		// Continues while the player hand value is less than 21.
		while (hand.getHandValue(player.getHand().getHand()) < 21) {
			System.out.println("\nWould you like to hit? (y or n) ");
			String choice = kb.next();
			// If player chooses to hit, add one card to his hand from the deck
			// and check if hand value is over 21. If hand is under 21 re-prompt
			// user to hit, if over 21 player busts and game is over.
			if (choice.toLowerCase().equals("y")) {
				player.receiveOneCardFromDealer(dealer.dealOneCardFromDeck());
				System.out.print("Your drew a: ");
				hand.displayLastCard(player.getHand().getHand());
				System.out.print("Player hand: ");
				hand.displayHand(player.getHand().getHand());
				if (hand.getHandValue(player.getHand().getHand()) > 21) {
					System.out.println("\nYou busted! Dealer wins.");
					break;
				}
				else {
					playerChoosesToHitOrStay();
				}
			}
			else{
				dealerHitsUntilHandValueIs17();
				break;
			}
		}
		if (hand.getHandValue(player.getHand().getHand()) == 21) {
			System.out.println("\nYou have Blackjack!");
		}
	}

	// Runs if dealers hand value is less than 17.
	public void dealerHitsUntilHandValueIs17() {
		while (hand.getHandValue(dealer.getHand().getHand()) < 17) {
			dealer.addOneCardToHand(dealer.dealOneCardFromDeck());
			System.out.print("\nThe dealer draws: ");
			hand.displayLastCard(dealer.getHand().getHand());
			System.out.print("Dealer hand: ");
			hand.displayHand(dealer.getHand().getHand());
			if (hand.getHandValue(dealer.getHand().getHand()) > 21) {
				System.out.println("\n Dealer busted! You win!");
			}
		}
	}

	public void winCondition() {
		if (hand.getHandValue(player.getHand().getHand()) == hand.getHandValue(dealer.getHand().getHand())) {
			System.out.print("Dealer:");
			hand.displayHand(dealer.getHand().getHand());
			System.out.print("\nPlayer:");
			hand.displayHand(player.getHand().getHand());
			System.out.println("\nThe result is a push.");
		} else if (hand.getHandValue(player.getHand().getHand()) < hand.getHandValue(dealer.getHand().getHand())) {
			System.out.print("\nPlayer:");
			hand.displayHand(player.getHand().getHand());
			System.out.println("\nYou lose.");
		} else if (hand.getHandValue(player.getHand().getHand()) > hand.getHandValue(dealer.getHand().getHand())) {
			if (hand.getHandValue(player.getHand().getHand()) == 21) {
				System.out.println("21!");
			}
			System.out.print("\nPlayer:");
			hand.displayHand(player.getHand().getHand());
			System.out.println("\nYou win!");
		}
	}
}

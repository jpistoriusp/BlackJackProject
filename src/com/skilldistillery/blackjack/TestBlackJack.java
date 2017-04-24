package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestBlackJack {
	Scanner kb = new Scanner(System.in);
	Player player = new Player();
	Dealer dealer = new Dealer();
	Hand hand = new Hand();
	Deck deck = new Deck();
	String choice;
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
		
		checkIfDealerHasBlackjack();
		playerChoosesToHitOrStay();
		dealerHitsUntilHandValueIs17();
		winCondition();
		endGameOption();
	}

	// Checks to see if dealer has blackjack. If dealer has blackjack the
	// game ends immediately. If not the game continues.
	public void checkIfDealerHasBlackjack() {
		if (dealer.getHand().getHand().get(0).getValue() >= 10) {
			System.out.println("\nDealer is checking for blackjack...");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException exp) {
			}
			if (dealer.returnsTrueIfDealerHasBlackjack(dealer.getHand().getHand())) {
				System.out.println("Dealer has blackjack. You Lose.");
				endGameOption();
			} else {
				System.out.println("Dealer does not have blackjack.");
			}
		}
	}
	
	public void playerChoosesToHitOrStay() {
		// Runs if player hand value is less than 21.
		if (hand.getHandValue(player.getHand().getHand()) < 21) {
			do {
				System.out.println("\nWould you like to hit? (y or n) ");
				choice = kb.next();
			
				if (choice.toLowerCase().equals("y")) {
					player.receiveOneCardFromDealer(dealer.dealOneCardFromDeck());
					System.out.print("Your drew a: ");
					
					hand.displayLastCard(player.getHand().getHand());
					System.out.print("Player hand: ");
					hand.displayHand(player.getHand().getHand());
					if (hand.getHandValue(player.getHand().getHand()) > 21) {
						System.out.println("\nYou busted! Dealer wins.");
						endGameOption();
					}
				} 
			} while (choice.toLowerCase().equals("y"));
		}
		else {
			System.out.println("\nPlayer has Blackjack!");
			endGameOption();
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
				endGameOption();
			}
		}
	}

	public void winCondition() {
		if (hand.getHandValue(player.getHand().getHand()) < 21)

			if (hand.getHandValue(player.getHand().getHand()) == hand.getHandValue(dealer.getHand().getHand())) {
				System.out.print("Dealer final hand:");
				hand.displayHand(dealer.getHand().getHand());
				System.out.print("\nPlayer final hand:");
				hand.displayHand(player.getHand().getHand());
				System.out.println("\nThe result is a push.");
			} else if (hand.getHandValue(player.getHand().getHand()) < hand.getHandValue(dealer.getHand().getHand())) {
				System.out.print("\nDealer final hand:");
				hand.displayHand(dealer.getHand().getHand());
				System.out.print("\nPlayer final hand:");
				hand.displayHand(player.getHand().getHand());
				System.out.println("\nYou lose.");
			} else if (hand.getHandValue(player.getHand().getHand()) > hand.getHandValue(dealer.getHand().getHand())) {
				System.out.print("\nPlayer final hand:");
				hand.displayHand(player.getHand().getHand());
				System.out.println("\nYou win!");
			}
	}
	//Prompts the user to play again. If yes clears the deck and hands. If no the program exits.
	public void endGameOption() {
		System.out.println("\nWould you like to play again? (y/n): ");
		choice = kb.next();
		if (choice.toLowerCase().equals("y")) {
			deck.clearDeck();
			dealer.getHand().getHand().clear();
			choice = null;
			play();
		} else {
			System.exit(0);
		}
	}
}

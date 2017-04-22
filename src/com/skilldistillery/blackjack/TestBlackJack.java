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
		Scanner kb = new Scanner(System.in);
		boolean win = true;

		deck = de.generate_52_Cards();
		Collections.shuffle(deck);
		playerHand = player.getStartingHand(deck);
		dealerHand = dealer.getStartingHand(deck);
		System.out.println("dealer shows:" + dealerHand.get(0));
		System.out.println("Hidden card:" + dealerHand.get(1));
		System.out.println("player hand:" + playerHand);

		if (hand.calculateHandValue(dealerHand) == 21) {
			System.out.println("Dealer has blackjack. You lose.");
		} 
		else {
			playerChoosesToHitOrStay(playerHand, deck);
		}
	}

	// check to see if it is needed to pass Lists.
	public void playerChoosesToHitOrStay(List<Card> playerHand, List<Card> deck) {
		while (hand.calculateHandValue(playerHand) < 21) {
			System.out.println("Would you like to hit? (y or n) ");
			String choice = kb.next();
			if (choice.toLowerCase() == "y") {
				player.playerChoosesToHit(playerHand, deck);
				playerChoosesToHitOrStay(playerHand, deck);
			} else {
				break;
			}
		}
		comparePlayerHandToDealerHand();
	}

	public void comparePlayerHandToDealerHand() {
		if (hand.calculateHandValue(playerHand) == hand.calculateHandValue(dealerHand)) {
			System.out.println("The result is a push.");
			System.out.println(playerHand);
			System.out.println(dealerHand);
		}
		else if (hand.calculateHandValue(playerHand) < hand.calculateHandValue(dealerHand)) {
			System.out.println("You lose.");
			System.out.println("Player:"+hand.calculateHandValue(playerHand));
			System.out.println("Dealer:" +hand.calculateHandValue(dealerHand));
		}
		else if (hand.calculateHandValue(playerHand) > hand.calculateHandValue(dealerHand)) {
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
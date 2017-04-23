package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	int value;
	List<Card> hand = new ArrayList<>();

	public int getHandValue(List<Card> hand) {
		value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}

	public void displayLastCard(List<Card> hand) {
		System.out.println("[" + hand.get(hand.size() - 1).getRank() + hand.get(hand.size() - 1).getSuit() + "]" + " ");
	}

	public void displayHand(List<Card> hand) {
		for (Card card : hand) {
			System.out.print("[" + card.getRank() + card.getSuit() + "]" + " ");
		}
	}

	public void displayFirstCard(List<Card> hand) {
		System.out.print("[" + hand.get(0).getRank() + hand.get(0).getSuit() + "]" + "");
		System.out.println(" [??]");
	}

	public void addCard(Card card) {
		hand.add(card);
	}
}

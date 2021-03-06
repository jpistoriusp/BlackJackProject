package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	int value;
	List<Card> hand = new ArrayList<>();

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	

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
	public void clearHand() {
		this.hand.clear();
	}
//	public void aceValueCheck(List<Card> hand) {
//		if (hand.get(hand.size() - 1).getRank().equals("A") && getHandValue(hand) > 21) {
//				getValue(hand);
//		}
//	}
}

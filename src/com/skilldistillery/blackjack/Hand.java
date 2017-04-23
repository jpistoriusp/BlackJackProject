package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	int value;

	public int getHandValue(List<Card> hand) {
		value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}
	public void displayCurrentHand(List<Card> hand) {
		for (Card card : hand) {
			System.out.print("["+ card.getRank()+ card.getSuit()+"]"+" ");
		}
	}
	public void displayFirstCard(List<Card> hand) {
		System.out.print( "["+hand.get(0).getRank()+ hand.get(0).getSuit()+"]"+"");
		System.out.println(" [??]");
	}
}

package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;


public class Deck {
	List<Card> deck = new ArrayList<>(52);
	
	public List<Card> createDeckFromCards() {
		
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	public void printSize(){
		System.out.println(deck.size());
	}
	
	public void clearDeck() {
		this.deck.clear();
	}
}

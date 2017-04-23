package com.skilldistillery.blackjack;

public enum Suit {
	// Small finite number of names. Perfect for eNums.
	HEARTS("\u2665"), DIAMONDS("\u2666"), SPADES("\u2663"), CLUBS("\u2660");

	private String name;
	
	private Suit(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

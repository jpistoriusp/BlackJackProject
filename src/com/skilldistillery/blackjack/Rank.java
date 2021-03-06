package com.skilldistillery.blackjack;

public enum Rank {
	// Small finite number of Strings. Use eNum.
	TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("10", 10), JACK("J", 10), QUEEN("Q", 10), KING("K", 10), ACE("A", 11);
	
	private String name;
	private int value;
	
	private Rank(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public void setName(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
	
}

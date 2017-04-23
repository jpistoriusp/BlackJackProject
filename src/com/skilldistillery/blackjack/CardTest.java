package com.skilldistillery.blackjack;

public class CardTest {

	private String suit;
	private String rank;
	private int value;
	
	public CardTest(String r, String s) {
		// setRank(r);
		rank = r;
		suit = s;
		value = getValue();
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

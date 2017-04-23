package com.skilldistillery.blackjack;

public class Card {

	private String rank;
	private String suit;
	private int value;

	public Card(Rank r, Suit s) {
		// setRank(r);
		rank = r.getName();
		suit = s.getName();
		value = r.getValue();
	}

	public Card() {
		// TODO Auto-generated constructor stub
	}
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [rank=");
		builder.append(rank);
		builder.append(", suit=");
		builder.append(suit);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}

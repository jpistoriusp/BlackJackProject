package com.skilldistillery.blackjack;

public class Card {

	private Rank rank;
	private Suit suit;
	private int value;

	public Card(Rank r, Suit s) {
		// setRank(r);
		rank = r;
		suit = s;
		value = getValue();
	}

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		if (rank.ordinal() <= 8) {
			value = rank.ordinal() + 2;
		} else if (rank.ordinal() == 13) {
			value = 11;
		} else {
			value = 10;
		}
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

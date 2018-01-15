package com.sonandhan.boardit.dto;

import java.sql.Timestamp;

public class CardDTO {

	private int cardNum;
	private String cardId;
	private String cardComment;
	private Timestamp cardDate;
	private int cardParent;

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardComment() {
		return cardComment;
	}

	public void setCardComment(String cardComment) {
		this.cardComment = cardComment;
	}

	public Timestamp getCardDate() {
		return cardDate;
	}

	public void setCardDate(Timestamp cardDate) {
		this.cardDate = cardDate;
	}

	public int getCardParent() {
		return cardParent;
	}

	public void setCardParent(int cardParent) {
		this.cardParent = cardParent;
	}

}

package pl.codedesign.tausend.game.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentuj¹ca model talii kart na stole, przed rozdaniem
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class Deck {

	/** Ca³a talia 24 kart */
	private List<Card> cards;
	
	/** Musik - 4 lub 3 karty */
	private List<Card> booster;
	
	public Deck(List<Card> cards){
		this.cards = cards;
	}
	
	public static Deck of(List<Card> cards){
		return new Deck(cards);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public void addCard(Card card){
		if(cards == null){
			cards = new ArrayList<Card>();
		}
		
		cards.add(card);
	}
	
	public Card getCard(int index){
		if(cards == null){
			return null;
		}
		
		return cards.get(index);
	}

	public List<Card> getBooster() {
		return booster;
	}

	public void setBooster(List<Card> booster) {
		this.booster = booster;
	}
	
	public void addBoosterCard(Card card){
		if(booster == null){
			booster = new ArrayList<Card>();
		}
		
		booster.add(card);
	}
}

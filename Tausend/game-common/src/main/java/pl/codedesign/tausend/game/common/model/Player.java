package pl.codedesign.tausend.game.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentuj¹ca model gracza.
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class Player {

	/** Nazwa gracza */
	private String name;
	
	/** Karty którymi dysponuje gracz */
	private List<Card> hand;
	
	/** Meldunek - ile gracz zadeklarowa³ minimalnie, ¿e ugra. */
	private Integer bid;
	
	/** Zaczynaj¹cy licytacjê - posiada 9 serce. */
	private boolean beginning;
	
	/** Ustalona kolejnoœæ w grze. */
	private Integer turn;
	
	/** Zebrana iloœæ punktów. */
	private Integer score = 0;

	public static Player of(String name){
		Player p = new Player();
		p.setName(name);
		
		return p;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getHand() {
		if(hand == null){
			hand = new ArrayList<Card>();
		}
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void addCard(Card card) {
		if(hand == null){
			hand = new ArrayList<Card>();
		}
		hand.add(card);
		
		if(card.isStarting()){
			this.setBeginning(true);
		}
	}
	
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public boolean isBeginning() {
		return beginning;
	}

	public void setBeginning(boolean beginning) {
		this.beginning = beginning;
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public Integer getScore() {
		return score;
	}
	
	public void appendScore(Integer points){
		score += points;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}

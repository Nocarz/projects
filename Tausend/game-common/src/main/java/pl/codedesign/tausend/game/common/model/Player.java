package pl.codedesign.tausend.game.common.model;

import java.util.ArrayList;
import java.util.List;


public class Player {

	/** Nazwa gracza */
	private String name;
	
	/** Karty którymi dysponuje gracz */
	private List<Card> hand;
	
	/** Meldunek - ile gracz zadeklarowa³ minimalnie, ¿e ugra. */
	private Integer annoucement;

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
	}
	
	public Integer getAnnoucement() {
		return annoucement;
	}

	public void setAnnoucement(Integer annoucement) {
		this.annoucement = annoucement;
	}
	
	
	
}

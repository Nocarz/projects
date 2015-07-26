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
	
	/** Zaczynaj¹cy licytacjê - posiada 9 serce. */
	private boolean beginning;

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
	
	public Integer getAnnoucement() {
		return annoucement;
	}

	public void setAnnoucement(Integer annoucement) {
		this.annoucement = annoucement;
	}

	public boolean isBeginning() {
		return beginning;
	}

	public void setBeginning(boolean beginning) {
		this.beginning = beginning;
	}
	
	
	
}

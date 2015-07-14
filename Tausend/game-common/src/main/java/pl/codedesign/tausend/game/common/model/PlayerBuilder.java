package pl.codedesign.tausend.game.common.model;

import java.util.List;

public class PlayerBuilder {

	private String name;	
	private List<Card> hand;
	private Integer annoucement;
	
	private PlayerBuilder(){
		
	}
	
	public static PlayerBuilder builder(){
		return new PlayerBuilder();
	}
	
	public PlayerBuilder name(String name){
		this.name = name;
		return this;
	}
	
	public PlayerBuilder hand(List<Card> hand){
		this.hand = hand;
		return this;
	}
	
	public PlayerBuilder annoucement(Integer annoucement){
		this.annoucement = annoucement;
		return this;
	}
	
	public Player build(){
		Player p = new Player();
		p.setAnnoucement(annoucement);
		p.setHand(hand);
		p.setName(name);
		
		return p;
	}
}

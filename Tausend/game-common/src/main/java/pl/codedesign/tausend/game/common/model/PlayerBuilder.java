package pl.codedesign.tausend.game.common.model;

import java.util.List;

public class PlayerBuilder {

	private String name;	
	private List<Card> hand;
	private Integer bid;
	private Integer turn;
	private Integer score;
	
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
	
	public PlayerBuilder bid(Integer bid){
		this.bid = bid;
		return this;
	}
	
	public PlayerBuilder turn(Integer turn){
		this.turn = turn;
		return this;
	}
	
	public PlayerBuilder score(Integer score){
		this.score = score;
		return this;
	}
	
	public Player build(){
		Player p = new Player();
		p.setBid(bid);
		p.setHand(hand);
		p.setName(name);
		p.setScore(score);
		p.setTurn(turn);
		
		return p;
	}
}

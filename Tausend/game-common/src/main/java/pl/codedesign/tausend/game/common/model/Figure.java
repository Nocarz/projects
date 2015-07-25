package pl.codedesign.tausend.game.common.model;

/**
 * Typ wyliczja�cy mo�liwe figury kart wraz z ich punktacj� do podsumowania.
 * 
 * @author Boles�aw Denk
 * @version 1.0
 */
public enum Figure {

	C9(0),
	
	JACK(2),
	
	QUEEN(3),
	
	KING(4),
	
	C10(10),
	
	ACE(11);
	
	/** Warto�� punktowa figury. */
	private final Integer points;
	
	private Figure(Integer points){
		this.points = points;
	}
	
	public Integer points(){
		return this.points;
	}
}

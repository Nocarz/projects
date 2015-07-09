package pl.codedesign.tausend.game.common.model;

/**
 * Typ wyliczaj�cy mo�liwe figury kart.
 * @author Boles�aw Denk
 * @version 1.0
 */
public enum Figure {

	/** Serce */
	HEARTS(100),
	
	/** Karo */
	DIAMONDS(80),
	
	/** Trefl */
	CLUBS(60), 
	
	/** Pik */
	SPADES(40);
	
	/** Warto�� koloru do meldunku. */
	private final Integer value;
	
	private Figure(Integer value){
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}	
}

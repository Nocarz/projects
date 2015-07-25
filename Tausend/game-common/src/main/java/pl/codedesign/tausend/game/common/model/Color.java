package pl.codedesign.tausend.game.common.model;

/**
 * Typ wyliczaj¹cy mo¿liwe kolory kart wraz z ich wartoœci¹ atutu.
 * 
 * @author Boles³aw Denk
 * @version 1.1
 */
public enum Color {

	/** Serce */
	HEARTS(100),
	
	/** Karo */
	DIAMONDS(80),
	
	/** Trefl */
	CLUBS(60), 
	
	/** Pik */
	SPADES(40);
	
	/** Wartoœæ atutu koloru do meldunku. */
	private final Integer value;
	
	private Color(Integer value){
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}	
}

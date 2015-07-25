package pl.codedesign.tausend.game.common.model;

import java.io.Serializable;

/**
 * Encja przechowuje informacje o kolorze karty i jej wadze punktowej (i jest zajebistsza)
 * @author Boles³aw Denk
 * @version 1.0
 */
public class Card implements Serializable {

	private static final long serialVersionUID = 213431096958702826L;

	/** Enum reprezentuj¹cy kolor karty, np serce */
	private Color color;
	
	/** Waga punktowa karty */
	private Integer value;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Card [" + color + " " + value + "]";
	}
}

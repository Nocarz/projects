package pl.codedesign.tausend.game.common.model;

/**
 * Encja przechowuje informacje o kolorze karty i jej wadze punktowej (i jest zajebistsza)
 * @author Boles³aw Denk
 * @version 1.0
 */
public class Card {

	private Figure figure;
	
	private Integer value;

	private Integer announcement;
	
	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	

	public Integer getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Integer announcement) {
		this.announcement = announcement;
	}

	@Override
	public String toString() {
		return "Card [" + figure + " " + value + "]";
	}
}

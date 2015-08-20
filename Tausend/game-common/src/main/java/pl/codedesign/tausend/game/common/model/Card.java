package pl.codedesign.tausend.game.common.model;

import java.io.Serializable;

/**
 * Encja przechowuje informacje o kolorze karty i jej wadze punktowej (i jest
 * zajebistsza)
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class Card implements Serializable {

	private static final long serialVersionUID = 213431096958702826L;

	/** Enum reprezentuj¹cy kolor karty, np. serce */
	private Color color;

	/** Enum reprezentuj¹cy figurê karty, np. król */
	private Figure figure;

	/** Referencja do gracza, który jest w³aœcicielem karty na stole. */
	private Player owner;

	/** Czy ta karta otwiera gre - 9 serce. */
	private boolean starting = false;

	/** Czy gracz zaznaczy³ kartê do gry. */
	private boolean selected = false;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public boolean isStarting() {
		return starting;
	}

	public void setStarting(boolean starting) {
		this.starting = starting;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "[" + figure.name() + " of " + color.name() + "]";
	}
}

package pl.codedesign.tausend.game.common.model;

/**
 * Klasa implementuj�ca wzorzec projektowy builder. 
 * Przy�piesza inicjalizacj� i wp�ywa dodatnie na czytelno�� kodu. 
 * 
 * @author Boles�aw Denk
 * @version 1.0
 */
public class CardBuilder {

	private Figure figure;
	
	private Integer value;
	
	private Integer announcement;
	
	protected CardBuilder(){ }
	
	public static CardBuilder builder(){
		return new CardBuilder();
	}
	
	public CardBuilder figure(Figure figure) {
		this.figure = figure;
		return this;
	}

	public CardBuilder value(Integer value) {
		this.value = value;
		return this;
	}
	
	public CardBuilder announcement(Integer announcement) {
		this.announcement = announcement;
		return this;
	}
	
	public Card build(){
		Card c = new Card();
		c.setFigure(figure);
		c.setValue(value);
		c.setAnnouncement(announcement);
		
		return c;
	}

}
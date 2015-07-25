package pl.codedesign.tausend.game.common.model;

/**
 * Klasa implementuj�ca wzorzec projektowy builder. 
 * Przy�piesza inicjalizacj� i wp�ywa dodatnie na czytelno�� kodu. 
 * 
 * @author Boles�aw Denk
 * @version 1.1
 */
public class CardBuilder {

	private Color color;
	
	private Figure figure;
	
	private Integer value;
		
	protected CardBuilder(){ }
	
	public static CardBuilder builder(){
		return new CardBuilder();
	}
	
	public CardBuilder of(Color color) {
		this.color = color;
		return this;
	}
	
	public CardBuilder card(Figure figure) {
		this.figure = figure;
		return this;
	}

	public CardBuilder value(Integer value) {
		this.value = value;
		return this;
	}
	
	public Card build(){
		Card c = new Card();
		c.setColor(color);
		c.setFigure(figure);
		c.setValue(value);
		
		return c;
	}

}

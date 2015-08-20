package pl.codedesign.tausend.game.common.model;

/**
 * Klasa implementuj¹ca wzorzec projektowy builder. 
 * Przyœpiesza inicjalizacjê i wp³ywa dodatnie na czytelnoœæ kodu. 
 * 
 * @author Boles³aw Denk
 * @version 1.1
 */
public class CardBuilder {

	private Color color;
	
	private Figure figure;
	
	private boolean starting = false;
	
	protected CardBuilder(){ }
	
	public static CardBuilder builder(){
		return new CardBuilder();
	}
	
	public CardBuilder of(Color color) {
		this.color = color;
		return this;
	}
	
	public CardBuilder figure(Figure figure) {
		this.figure = figure;
		return this;
	}

	public CardBuilder starting(boolean starting) {
		this.starting = starting;
		return this;
	}
	
	public Card build(){
		Card c = new Card();
		c.setColor(color);
		c.setFigure(figure);
		c.setStarting(starting);
		
		return c;
	}

}

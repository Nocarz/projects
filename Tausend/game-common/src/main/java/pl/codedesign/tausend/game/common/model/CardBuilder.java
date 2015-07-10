package pl.codedesign.tausend.game.common.model;

/**
 * Klasa implementuj¹ca wzorzec projektowy builder. 
 * Przyœpiesza inicjalizacjê i wp³ywa dodatnie na czytelnoœæ kodu. 
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class CardBuilder {

	private Figure figure;
	
	private Integer value;
		
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
	
	public Card build(){
		Card c = new Card();
		c.setFigure(figure);
		c.setValue(value);
		
		return c;
	}

}

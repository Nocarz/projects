package pl.codedesign.tausend.game.common.model.util;

import static org.fest.assertions.api.Assertions.assertThat;
import static pl.codedesign.tausend.game.common.model.CardBuilder.builder;

import org.junit.Before;
import org.junit.Test;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Color;
import pl.codedesign.tausend.game.common.model.Figure;

public class CardComparatorTest {
	
	private CardHandComparator comparator;
	
	@Before
	public void setup(){
		comparator = new CardHandComparator();
	}
	
	@Test
	public void compareColor_KHKD() {
		Card c1 = builder().figure(Figure.KING).of(Color.HEARTS).build();
		Card c2 = builder().figure(Figure.KING).of(Color.DIAMONDS).build();
		
		int result = comparator.compare(c1, c2);
		
		assertThat(result).isEqualTo(-1);
	}

	@Test
	public void compareColor_KDKH() {
		Card c1 = builder().figure(Figure.KING).of(Color.DIAMONDS).build();
		Card c2 = builder().figure(Figure.KING).of(Color.HEARTS).build();
		
		int result = comparator.compare(c1, c2);
		
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	public void compareColor_KHKH() {
		Card c1 = builder().figure(Figure.KING).of(Color.HEARTS).build();
		Card c2 = builder().figure(Figure.KING).of(Color.HEARTS).build();
		
		int result = comparator.compare(c1, c2);
		
		assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void compareColor_QHKH() {
		Card c1 = builder().figure(Figure.QUEEN).of(Color.HEARTS).build();
		Card c2 = builder().figure(Figure.KING).of(Color.HEARTS).build();
		
		int result = comparator.compare(c1, c2);
		
		assertThat(result).isEqualTo(-1);
	}
	
}

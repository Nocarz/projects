package pl.codedesign.tausend.game.common.model.util;

import java.util.Comparator;

import pl.codedesign.tausend.game.common.model.Card;

public class CardTableComparator implements Comparator<Card> {

	public int compare(Card c1, Card c2) {
		return c2.getFigure().points().compareTo(c1.getFigure().points());
	}

}

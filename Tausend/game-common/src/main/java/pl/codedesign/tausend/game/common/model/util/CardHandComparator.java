package pl.codedesign.tausend.game.common.model.util;

import java.util.Comparator;

import pl.codedesign.tausend.game.common.model.Card;

/**
 * Obiekt komparatora kart do posortowania ich wg kolorów, figur i wartoœci.
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class CardHandComparator implements Comparator<Card> {

	public int compare(Card c1, Card c2) {
		if(c1 == null && c2 == null){
			return 0;
		} else if(c1 != null && c2 == null) {
			return 1;
		} else if (c1 == null && c2 != null) {
			return -1;
		} else {
			if(c2.getColor().getValue().equals(c1.getColor().getValue())){
				return c1.getFigure().points().compareTo(c2.getFigure().points());
			} else {
				return c2.getColor().getValue().compareTo(c1.getColor().getValue());
			}
		}
	}
}

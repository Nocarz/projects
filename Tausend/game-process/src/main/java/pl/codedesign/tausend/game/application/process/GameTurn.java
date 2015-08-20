package pl.codedesign.tausend.game.application.process;

import java.util.Collections;
import java.util.List;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.util.CardTableComparator;

/**
 * Utils for game turn mechanics.
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class GameTurn {

	public static void summarize(List<Card> table){
		Collections.sort(table, new CardTableComparator());
		
		Integer points = 0;
		for(Card c : table){
			points += c.getFigure().points();
		}
		
		table.get(0).getOwner().appendScore(points);
	}	
}
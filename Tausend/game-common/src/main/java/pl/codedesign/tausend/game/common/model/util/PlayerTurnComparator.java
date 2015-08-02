package pl.codedesign.tausend.game.common.model.util;

import java.util.Comparator;

import pl.codedesign.tausend.game.common.model.Player;

/**
 * Komparator do sortowania listy graczy po ich kolejnoœci.
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class PlayerTurnComparator implements Comparator<Player> {

	public int compare(Player p1, Player p2) {
		if(p1 != null && p2 != null){
			return p1.getTurn().compareTo(p2.getTurn());
		} else if (p1 != null && p2 == null){
			return 1;
		} else if (p1 == null && p2 != null){
			return -1;
		} else {
			return 0;
		}
	}

}

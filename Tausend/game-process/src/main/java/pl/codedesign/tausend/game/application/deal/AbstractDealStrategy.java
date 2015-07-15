package pl.codedesign.tausend.game.application.deal;

import java.util.List;
import java.util.Random;

import pl.codedesign.tausend.game.common.model.Deck;
import pl.codedesign.tausend.game.common.model.Player;

/**
 * Mo�e troch� na wyrost, ale oba alborytmy maj� pewne cz�ci wsp�lne, kt�re tu zamieszczam.
 * 
 * @author Boles�aw Denk
 */
public abstract class AbstractDealStrategy implements DealStrategy {

	protected final Random random = new Random();
	
	protected final Deck deck;
	
	public AbstractDealStrategy(Deck deck){
		this.deck = deck;
	}
	
	public abstract void deal(List<Player> players);
	
	protected int getRandom(int min, int max) { 		
		int r = Math.abs(random.nextInt()); 
		return (r % ((max - min + 1))) + min; 
	}
}

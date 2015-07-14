package pl.codedesign.tausend.game.application.deal;

import java.util.List;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Deck;
import pl.codedesign.tausend.game.common.model.Player;

/**
 * Sposób rozdawnia kart dla gry z dwoma graczami.
 * 
 * @author Boles³aw Denk
 */
public class TwoPlayerDealStrategy extends AbstractDealStrategy {

	TwoPlayerDealStrategy(Deck deck) {
		super(deck);
	}

	public void deal(List<Player> players) {
		for(Player player : players){
			while(player.getHand().size() < 10){
				int randomIndex = getRandom(0,23);
				
				while(deck.getCard(randomIndex) == null) {
					if(randomIndex==23) randomIndex=0;
					else randomIndex++;
				}
				
				player.addCard(deck.getCard(randomIndex));
				deck.getCards().set(randomIndex, null);
			}
		}
		
		for(Card card : deck.getCards()){
			if(card != null){
				deck.addBoosterCard(card);
			}
		}
	}
}

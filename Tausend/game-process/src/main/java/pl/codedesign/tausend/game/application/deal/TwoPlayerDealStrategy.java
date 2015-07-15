package pl.codedesign.tausend.game.application.deal;

import java.util.List;

import com.google.common.base.Preconditions;

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
		Preconditions.checkNotNull(players, "Players cannot be null!");
		Preconditions.checkNotNull(deck, "Deck of cards cannot be null!");
		Preconditions.checkElementIndex(23, deck.getCards().size(), "Cards are missing in deck!");
		
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

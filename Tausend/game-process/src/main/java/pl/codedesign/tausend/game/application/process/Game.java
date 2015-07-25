package pl.codedesign.tausend.game.application.process;

import java.util.List;

import pl.codedesign.tausend.game.application.deal.DealStrategyFactory;
import pl.codedesign.tausend.game.application.init.DeckCreator;
import pl.codedesign.tausend.game.common.model.Deck;
import pl.codedesign.tausend.game.common.model.Player;

/**
 * Klasa uruchamiaj¹ca poszczególne fazy gry
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class Game {

	private final List<Player> players;
	
	public Game of(List<Player> players) {
		return new Game(players);		
	}
	
	protected Game(List<Player> players) {
		this.players = players;
	}
	
	public void play(){
		Deck deck = DeckCreator.build();
		
		//Rozdanie kart
		DealStrategyFactory.create(players.size(), deck).deal(players);
	}
	
}

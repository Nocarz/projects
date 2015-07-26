package pl.codedesign.tausend.game.application.process;

import java.util.Collections;
import java.util.List;

import pl.codedesign.tausend.game.application.deal.DealStrategyFactory;
import pl.codedesign.tausend.game.application.init.DeckCreator;
import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Deck;
import pl.codedesign.tausend.game.common.model.Player;
import pl.codedesign.tausend.game.common.model.util.CardComparator;

import com.google.common.collect.Lists;

/**
 * Klasa uruchamiaj¹ca poszczególne fazy gry
 * 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class Game {

	private final List<Player> players;
	
	public static Game of(List<Player> players) {
		return new Game(players);		
	}
	
	public static Game of(Player... players) {
		return new Game(Lists.newArrayList(players));		
	}
	
	protected Game(List<Player> players) {
		this.players = players;
	}
	
	public void play(){
		Deck deck = DeckCreator.build();
		
		//Rozdanie kart
		DealStrategyFactory.create(players.size(), deck).deal(players);
				
		for(Player player : players){
			Collections.sort(player.getHand(), new CardComparator());
			
			System.out.print(player.getName() + "[");
			for(Card c : player.getHand()){
				System.out.print(c.toString() + ", ");
			}
			System.out.println("]\n");
		}
	}
	
	public static void main(String... args){
		Game.of(Player.of("Janek"), Player.of("Franek")).play();
	}
	
}

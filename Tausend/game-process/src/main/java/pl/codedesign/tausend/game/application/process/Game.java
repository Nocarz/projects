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
 * Klasa uruchamiająca poszczególne fazy gry
 * 
 * @author Bolesław Denk
 * @version 1.0
 */
public class Game {

	private Deck deck;
	
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
		deck = DeckCreator.build();
		
		//Rozdanie kart
		DealStrategyFactory.create(players.size(), deck).deal(players);
				
		for(Player player : players){
			Collections.sort(player.getHand(), new CardComparator());
		}	
	}
		
	Deck getDeck(){
		return deck;
	}
	
	public static void main(String... args){
		List<Player> players = Lists.newArrayList(Player.of("Janek"), Player.of("Franek"));
		
		Game game = Game.of(players);
		game.play();
		
		for(Player player : players){			
			System.out.print(player.getName() + (player.isBeginning() ? "! " : " ") + "[");
			for(Card c : player.getHand()){
				System.out.print(c.toString() + ", ");
			}
			System.out.println("]\n");
		}
		
		System.out.print("Booster [");
		for(Card c : game.getDeck().getBooster()){
			System.out.print(c.toString() + ", ");
		}
		System.out.println("]\n");
	}	
}

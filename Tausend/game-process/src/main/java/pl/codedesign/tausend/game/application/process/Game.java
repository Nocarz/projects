package pl.codedesign.tausend.game.application.process;

import java.util.Collections;
import java.util.List;

import pl.codedesign.tausend.game.application.bidding.AssetSupport;
import pl.codedesign.tausend.game.application.deal.DealStrategyFactory;
import pl.codedesign.tausend.game.application.init.DeckCreator;
import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Color;
import pl.codedesign.tausend.game.common.model.Deck;
import pl.codedesign.tausend.game.common.model.Player;
import pl.codedesign.tausend.game.common.model.util.CardHandComparator;

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
	
	public void deal(Deck deck){
		//Rozdanie kart
		DealStrategyFactory.create(players.size(), deck).deal(players);
				
		for(Player player : players){
			Collections.sort(player.getHand(), new CardHandComparator());
		}	
	}
	
	public static void main(String... args){
		StringBuilder summary = new StringBuilder("------------\n");
		List<Player> players = Lists.newArrayList(Player.of("Janek"), Player.of("Franek"));
		Deck deck = DeckCreator.build();
		
		Game game = Game.of(players);
		game.deal(deck);
		
		for(Player player : players){			
			summary.append(player.getName()).append((player.isBeginning() ? "! " : " ")).append("[");
			for(Card c : player.getHand()){
				summary.append(c.toString()).append(", ");
			}
			summary.append("],\n assets: ");
			
			List<Color> assets = AssetSupport.check(player);
			if(assets.isEmpty()){
				summary.append("none");
			} else {
				for(Color asset : assets){
					summary.append(asset.getValue()).append(", ");
				}				
			}
			summary.append("\n\n");
		}
		
		summary.append("Booster [");
		for(Card c : deck.getBooster()){
			summary.append(c.toString()).append(", ");
		}
		summary.append("]\n");
		
		System.out.println(summary.toString());
	}	
}

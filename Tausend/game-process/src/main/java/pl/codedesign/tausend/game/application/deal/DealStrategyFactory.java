package pl.codedesign.tausend.game.application.deal;

import pl.codedesign.tausend.game.common.model.Deck;

import com.google.common.base.Preconditions;

public class DealStrategyFactory {
	
	public static DealStrategy create(int players, Deck deck){
		Preconditions.checkArgument(players >= 2);
		
		if(players == 2) {
			return new TwoPlayerDealStrategy(deck);
		} else {
			return new MultiplePlayersDealStrategy(deck);
		} 
	}
	
}

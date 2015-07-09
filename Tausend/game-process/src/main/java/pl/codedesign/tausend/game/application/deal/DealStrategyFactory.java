package pl.codedesign.tausend.game.application.deal;

import com.google.common.base.Preconditions;

public class DealStrategyFactory {
	
	public static DealStrategy create(int players){
		Preconditions.checkArgument(players >= 2);
		
		if(players == 2) {
			return new TwoPlayerDealStrategy();
		} else {
			return new MultiplePlayersDealStrategy();
		} 
	}
	
}

package pl.codedesign.tausend.game.application.deal;

import java.util.List;
import java.util.Random;

import pl.codedesign.tausend.game.common.model.Player;

public abstract class AbstractDealStrategy implements DealStrategy {

	protected final Random random = new Random();
	
	public abstract void deal(List<Player> players);
	
}

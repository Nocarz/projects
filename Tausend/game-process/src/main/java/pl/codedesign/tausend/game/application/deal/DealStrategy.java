package pl.codedesign.tausend.game.application.deal;

import java.util.List;

import pl.codedesign.tausend.game.common.model.Player;

public interface DealStrategy {

	public void deal(List<Player> players);
	
}

package pl.codedesign.tausend.game.application.deal;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.CardBuilder;
import pl.codedesign.tausend.game.common.model.Deck;
import pl.codedesign.tausend.game.common.model.Player;
import pl.codedesign.tausend.game.common.model.PlayerBuilder;

class TwoPlayerDealStrategyTest {

	private Deck deck;
	private TwoPlayerDealStrategy strategy;
	
	private Player p1;
	private Player p2;
	
	private List<Player> players;
	private List<Card> cards;
	
	@BeforeEach
	void setUp(){
		cards = Lists.newArrayList();
		
		for(int i=0; i < 24; i++){
			cards.add(CardBuilder.builder().build());
		}
		
		deck = Deck.of(cards);
				
		strategy = spy(new TwoPlayerDealStrategy(deck));
		
		p1 = PlayerBuilder.builder().name("Player 1").build();
		p2 = PlayerBuilder.builder().name("Player 2").build();
		
		players = Lists.newArrayList();
		players.add(p1);
		players.add(p2);
	}
	
	@Test
	void deal_ok() {		
		//when
		strategy.deal(players);
		
		//then
		assertThat(p1.getHand()).isNotNull().isNotEmpty().hasSize(10);
		assertThat(p2.getHand()).isNotNull().isNotEmpty().hasSize(10);
		assertThat(deck.getBooster()).isNotNull().isNotEmpty().hasSize(4);
	}
	
	@Test
	void deal_playersNPE() {				
	    Assertions.assertThrows(NullPointerException.class, () -> {
	    	strategy.deal(null);
	    });		
	}
	
	@Test
	void deal_deckNPE() {
		//given
		strategy = spy(new TwoPlayerDealStrategy(null));

		//when
		Assertions.assertThrows(NullPointerException.class, () -> {
			strategy.deal(players);
		});
		
		//then exception is thrown
	}
	
	@Test
	void deal_deckMissing() {
		//given
		deck = Deck.of(cards.subList(0, 22));
		strategy = spy(new TwoPlayerDealStrategy(deck));

		//when
		Assertions.assertThrows(NullPointerException.class, () -> {
			strategy.deal(players);
		});
		
		//then exception is thrown
	}
	
}

package pl.codedesign.tausend.game.application.bidding;

import static org.fest.assertions.api.Assertions.assertThat;
import static pl.codedesign.tausend.game.common.model.CardBuilder.builder;
import static pl.codedesign.tausend.game.common.model.Color.CLUBS;
import static pl.codedesign.tausend.game.common.model.Color.DIAMONDS;
import static pl.codedesign.tausend.game.common.model.Color.HEARTS;
import static pl.codedesign.tausend.game.common.model.Color.SPADES;
import static pl.codedesign.tausend.game.common.model.Figure.C10;
import static pl.codedesign.tausend.game.common.model.Figure.JACK;
import static pl.codedesign.tausend.game.common.model.Figure.KING;
import static pl.codedesign.tausend.game.common.model.Figure.QUEEN;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Color;
import pl.codedesign.tausend.game.common.model.Player;

import com.google.common.collect.Lists;

public class AssetSupportTest {
		
	private Player player;
	
	private List<Card> hand;
	
	@Before
	public void setup(){		
		player = Player.of("Janek");
		
		hand = Lists.newArrayList();
	}

	@Test
	public void check_none() {
		hand.add(builder().card(JACK).of(CLUBS).build());
		hand.add(builder().card(C10).of(HEARTS).build());
		hand.add(builder().card(C10).of(DIAMONDS).build());
		hand.add(builder().card(C10).of(CLUBS).build());
		hand.add(builder().card(C10).of(SPADES).build());
		player.setHand(hand);
		
		List<Color> assets = AssetSupport.check(player);
		
		assertThat(assets).isNotNull().isEmpty();
	}
	
	@Test
	public void check_hearts() {
		hand.add(builder().card(QUEEN).of(HEARTS).build());
		hand.add(builder().card(C10).of(DIAMONDS).build());
		hand.add(builder().card(C10).of(CLUBS).build());
		hand.add(builder().card(KING).of(HEARTS).build());
		hand.add(builder().card(C10).of(SPADES).build());
		player.setHand(hand);
		
		List<Color> assets = AssetSupport.check(player);
		
		assertThat(assets).isNotNull().isNotEmpty().hasSize(1);
		assertThat(assets.get(0)).isNotNull().isEqualTo(Color.HEARTS);
	}
	
	@Test
	public void check_hearts_diamonds() {
		hand.add(builder().card(QUEEN).of(HEARTS).build());
		hand.add(builder().card(KING).of(DIAMONDS).build());
		hand.add(builder().card(C10).of(CLUBS).build());
		hand.add(builder().card(KING).of(HEARTS).build());
		hand.add(builder().card(C10).of(SPADES).build());
		hand.add(builder().card(QUEEN).of(DIAMONDS).build());
		player.setHand(hand);
		
		List<Color> assets = AssetSupport.check(player);
		
		assertThat(assets).isNotNull().isNotEmpty().hasSize(2);
		assertThat(assets.get(0)).isNotNull().isEqualTo(Color.HEARTS);
		assertThat(assets.get(1)).isNotNull().isEqualTo(Color.DIAMONDS);
	}

}

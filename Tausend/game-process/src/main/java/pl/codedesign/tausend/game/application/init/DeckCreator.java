package pl.codedesign.tausend.game.application.init;

import static pl.codedesign.tausend.game.common.model.CardBuilder.builder;
import static pl.codedesign.tausend.game.common.model.Color.CLUBS;
import static pl.codedesign.tausend.game.common.model.Color.DIAMONDS;
import static pl.codedesign.tausend.game.common.model.Color.HEARTS;
import static pl.codedesign.tausend.game.common.model.Color.SPADES;
import static pl.codedesign.tausend.game.common.model.Figure.ACE;
import static pl.codedesign.tausend.game.common.model.Figure.C10;
import static pl.codedesign.tausend.game.common.model.Figure.C9;
import static pl.codedesign.tausend.game.common.model.Figure.JACK;
import static pl.codedesign.tausend.game.common.model.Figure.KING;
import static pl.codedesign.tausend.game.common.model.Figure.QUEEN;

import java.util.List;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Deck;

import com.google.common.collect.Lists;

/**
 * Tworzy taliê kart do tysiaca. 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class DeckCreator {

	public static Deck build(){				
		List<Card> cards = Lists.newArrayList();
		
		cards.add(builder().figure(C9).of(HEARTS).starting(true).build());
		cards.add(builder().figure(C9).of(DIAMONDS).build());
		cards.add(builder().figure(C9).of(CLUBS).build());
		cards.add(builder().figure(C9).of(SPADES).build());
		
		cards.add(builder().figure(JACK).of(HEARTS).build());
		cards.add(builder().figure(JACK).of(DIAMONDS).build());
		cards.add(builder().figure(JACK).of(CLUBS).build());
		cards.add(builder().figure(JACK).of(SPADES).build());
		
		cards.add(builder().figure(QUEEN).of(HEARTS).build());
		cards.add(builder().figure(QUEEN).of(DIAMONDS).build());
		cards.add(builder().figure(QUEEN).of(CLUBS).build());
		cards.add(builder().figure(QUEEN).of(SPADES).build());
		
		cards.add(builder().figure(KING).of(HEARTS).build());
		cards.add(builder().figure(KING).of(DIAMONDS).build());
		cards.add(builder().figure(KING).of(CLUBS).build());
		cards.add(builder().figure(KING).of(SPADES).build());
		
		cards.add(builder().figure(C10).of(HEARTS).build());
		cards.add(builder().figure(C10).of(DIAMONDS).build());
		cards.add(builder().figure(C10).of(CLUBS).build());
		cards.add(builder().figure(C10).of(SPADES).build());
		
		cards.add(builder().figure(ACE).of(HEARTS).build());
		cards.add(builder().figure(ACE).of(DIAMONDS).build());
		cards.add(builder().figure(ACE).of(CLUBS).build());
		cards.add(builder().figure(ACE).of(SPADES).build());
		
		return Deck.of(cards);
	}	
}
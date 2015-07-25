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

import com.google.common.collect.Lists;

/**
 * Tworzy taliê kart do tysiaca. 
 * @author Boles³aw Denk
 * @version 1.0
 */
public class DeckCreator {

	public static List<Card> build(){
		List<Card> deck = Lists.newArrayList();
		
		deck.add(builder().card(C9).of(HEARTS).build());
		deck.add(builder().card(C9).of(DIAMONDS).build());
		deck.add(builder().card(C9).of(CLUBS).build());
		deck.add(builder().card(C9).of(SPADES).build());
		
		deck.add(builder().card(JACK).of(HEARTS).build());
		deck.add(builder().card(JACK).of(DIAMONDS).build());
		deck.add(builder().card(JACK).of(CLUBS).build());
		deck.add(builder().card(JACK).of(SPADES).build());
		
		deck.add(builder().card(QUEEN).of(HEARTS).build());
		deck.add(builder().card(QUEEN).of(DIAMONDS).build());
		deck.add(builder().card(QUEEN).of(CLUBS).build());
		deck.add(builder().card(QUEEN).of(SPADES).build());
		
		deck.add(builder().card(KING).of(HEARTS).build());
		deck.add(builder().card(KING).of(DIAMONDS).build());
		deck.add(builder().card(KING).of(CLUBS).build());
		deck.add(builder().card(KING).of(SPADES).build());
		
		deck.add(builder().card(C10).of(HEARTS).build());
		deck.add(builder().card(C10).of(DIAMONDS).build());
		deck.add(builder().card(C10).of(CLUBS).build());
		deck.add(builder().card(C10).of(SPADES).build());
		
		deck.add(builder().card(ACE).of(HEARTS).build());
		deck.add(builder().card(ACE).of(DIAMONDS).build());
		deck.add(builder().card(ACE).of(CLUBS).build());
		deck.add(builder().card(ACE).of(SPADES).build());
		
		return deck;
	}	
}
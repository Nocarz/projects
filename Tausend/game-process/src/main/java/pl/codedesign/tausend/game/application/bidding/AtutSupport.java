package pl.codedesign.tausend.game.application.bidding;

import java.util.List;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Color;
import pl.codedesign.tausend.game.common.model.Figure;
import pl.codedesign.tausend.game.common.model.Player;

import com.google.common.collect.Lists;

/**
 * Klasa sprawdza ile gracz posiada par Król-Dama tego samego koloru,
 * co daje mu mo¿liwoœæ zalicytowania odpowiedniego pu³apu punktów.
 * 
 * @author Boles³aw Denk
 * @version 1.0
 *
 */
public class AtutSupport {

	public void check(Player player){
		List<Color> atuty = Lists.newArrayList();
		
		for(Color color : Color.values()){
			Integer atutOfColor = 0;
			
			for(Card card : player.getHand()){
				if(color.equals(card.getColor())){
					if(Figure.QUEEN.equals(card.getFigure()) || Figure.KING.equals(card.getFigure())){
						atutOfColor += color.getValue();
					}
				}
			}

			atutOfColor /= 2;
			
			if(atutOfColor.equals(color.getValue())){
				atuty.add(color);
			}			
		}		
	}
	
}

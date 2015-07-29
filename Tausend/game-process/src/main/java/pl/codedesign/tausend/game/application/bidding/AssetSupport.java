package pl.codedesign.tausend.game.application.bidding;

import java.util.List;

import pl.codedesign.tausend.game.common.model.Card;
import pl.codedesign.tausend.game.common.model.Color;
import pl.codedesign.tausend.game.common.model.Figure;
import pl.codedesign.tausend.game.common.model.Player;

import com.google.common.collect.Lists;

/**
 * Klasa sprawdza ile gracz posiada par Kr�l-Dama tego samego koloru,
 * co daje mu mo�liwo�� zalicytowania odpowiedniego pu�apu punkt�w.
 * 
 * @author Boles�aw Denk
 * @version 1.0
 *
 */
public class AssetSupport {

	public static List<Color> check(Player player){
		List<Color> assets = Lists.newArrayList();
		
		for(Color color : Color.values()){
			Integer currentAsset = 0;
			
			for(Card card : player.getHand()){
				if(color.equals(card.getColor())){
					if(Figure.QUEEN.equals(card.getFigure()) || Figure.KING.equals(card.getFigure())){
						currentAsset += color.getValue();
					}
				}
			}

			currentAsset /= 2;
			
			if(currentAsset.equals(color.getValue())){
				assets.add(color);
			}			
		}
		
		return assets;
	}
	
}

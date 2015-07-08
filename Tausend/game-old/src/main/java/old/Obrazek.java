package old;

import javax.microedition.lcdui.Image;

/** Klasa Obrazek - posrednik mi�dzy klasami Karciochy i Img
 * @author Boles�aw Denk
 * @version 0.75
 */ 

public class Obrazek
{
	public Image obr;
	public int indeks;
		
	/** Konstruktor domy�lny
	 * @param img obiekt graficnzy karty
	 * @param index indeks karty
	 */
	public Obrazek(Image img, int index)
	{
		obr = img;
		indeks = index;
	}
	
	/** Konstruktor dodatkowy
	 * @param obrazek obiekt klasy Obrazek
	 */
	public Obrazek(Obrazek obrazek)
	{
		obr = obrazek.obr;
		indeks = obrazek.indeks;
	}
	
	/** Metoda zwracaj�ca obiekt klasy Image
	 * @return obr obiekt klasy Image */
	public Image getImageFormObrazek()
	{
		return obr;
	}
	
	/** Metoda zwracaj�ca indeks karty
 	 * @return indeks indeks obrazka */
	public int getIndexFormObrazek()
	{
		return indeks;
	}

}
package old;

import javax.microedition.lcdui.Image;
import java.io.*;

/** Podstawa dzia�ania ca�ego lagorytmu gry Tausend. <br>
 * Przechowuje informacje o kolorze karty i jej wadze punktowej w postaci pary String, integer i jest zajebista
 * @author Boles�aw Denk
 * @version 0.85
 */ 

public class Karciochy implements Serializer
{ 	
	String kolorFigura;
	int punkty;
	int meldunek;
	Obrazek img;
	
	/** Podstawowy konstruktor domy�lny, pobierajacy par� String, integer
	 * @param x zmienna koloru karty
	 * @param y zmienna wagi punktowej karty
	 * @param jj obiekt klasy Image
	 */
	public Karciochy(String x, int y, Obrazek jj)
	{
		kolorFigura = x;
		punkty = y;
		img = jj;
	}
	
	/** Konstruktor, pobierajacy tr�jk� zmiennych String, int, int. Trzecia zmienna odpowiada za meldunek
	 * @param x zmienna koloru karty
	 * @param y zmienna wagi punktowej karty
	 * @param z zmienna meldunku
	 * @param jj obiekt klasy Image
	 */
	public Karciochy(String x, int y, int z, Obrazek jj)
	{
		kolorFigura = x;
		punkty = y;
		meldunek = z;
		img = jj;
	}
	
	/** Konstruktor tworzacy obiekt ze zmiennych wewn�trznych innego obiektu klasy karciochy
	 *  @param k obiekt klasy Karciochy */
	public Karciochy(Karciochy k)
	{
		kolorFigura = k.kolorFigura;
		punkty = k.punkty;
		meldunek = k.meldunek;
		img = k.img;
	}

	
	/** Metoda pobieraj�ca obiekt klasy Karciochy i przypisuj�ca go do innego obiektu tej klasy
	 *  @param k obiekt klasy Karciochy */
	public void setKart(Karciochy k)
	{
		kolorFigura = k.kolorFigura;
		punkty = k.punkty;
		meldunek = k.meldunek;
		img = k.img;
	}
	
	/** Metoda ustawia pobran� warto�� typu int jako meldunek karty
	 *  @param z zmienna meldunku */
	public void setMeld(int z)
	{
		meldunek = z;
	}
	
	/** Metoda zwracaj�ca kolor karty */
	/** @return a zwracany kolorkarty */
	public String getKolor()
	{		
		return kolorFigura;
	}
	
	/** Metoda zwracaj�ca litere koloru karty na zadanej pozycji ze Stringu
	 * @param f pozycja znaku do zwrucenia
	 * @return a zwracany 1 liter� koloru karty */
	public char getKolor(int f)
	{		
		return kolorFigura.charAt(f);
	}
	
	/** Metoda zwracaj�ca wage punktow� karty */
	/** @return b zwracana waga punktowa karty */
	public int getPt()
	{		
		return punkty;
	}
	
	/** Metoda zwracaj�ca atut karty (istotne do meldunku) */
	/** @return c zwracany atut karty (jesli zajdzie taka potrzbea) */
	public int getAtut()
	{		
		return meldunek;
	}


	public Obrazek getObrazek()
	{
		return img;
	}

	/** Metoda zwracaj�ca obrazek karty */
	/** @return c zwracany obrazek karty */
	public Image getImg()
	{
		return img.getImageFormObrazek();
	}

	public int getIndexImg()
	{
		return img.getIndexFormObrazek();
	}
	
	/** Metoda zeruj�ca zadan� ilo�� zmiennych obiektu 
	 * @param ile zmienna okre�laj�ca ile wyzerowa� zmiennych */
	public void zeruj(int ile)
	{
		if(ile==2)
		{
			kolorFigura = "0";
			punkty = 0;
		}
		else if(ile==3)
		{
			kolorFigura = "0";
			punkty = 0;
			meldunek = 0;	
		}			
	}
		
	/** Metoda wy�wietlaj�ca w konsoli kompilatora dan� par� String int <br>
	 * inaczej: zwraca do konsoli ca�� kart� (u�ywana do test�w) */
	public void show()
	{
		System.out.print("[" + kolorFigura + "," + punkty + "]");
	}

	/** Metoda serialuzyj�ca dane odziedziczona przez interface serializuj�cy */
    public byte[] serializuj() throws IOException 
    {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream dout =  new DataOutputStream( bout );
        
        dout.writeUTF( getKolor() );
        dout.writeInt( getPt() );
        dout.writeInt( getAtut() );
        dout.writeInt( getIndexImg() );
        dout.flush();

        return bout.toByteArray();
    }

    /** Metoda deserialuzyj�ca dane odziedziczona przez interface serializuj�cy */
    public void deserializuj( byte[] data ) throws IOException 
    {
        ByteArrayInputStream bin = new ByteArrayInputStream( data );
        DataInputStream din = new DataInputStream( bin );
 
        
        kolorFigura = din.readUTF();
        punkty = din.readInt();
        meldunek = din.readInt();
        img = Img.obrazkiKart[din.readInt()];
    }	
    
    
	
}


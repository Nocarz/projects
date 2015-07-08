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
	String a;
	int b;
	int c;
	Obrazek ii;
	
	/** Podstawowy konstruktor domy�lny, pobierajacy par� String, integer
	 * @param x zmienna koloru karty
	 * @param y zmienna wagi punktowej karty
	 * @param jj obiekt klasy Image
	 */
	public Karciochy(String x, int y, Obrazek jj)
	{
		a = x;
		b = y;
		ii = jj;
	}
	
	/** Konstruktor, pobierajacy tr�jk� zmiennych String, int, int. Trzecia zmienna odpowiada za meldunek
	 * @param x zmienna koloru karty
	 * @param y zmienna wagi punktowej karty
	 * @param z zmienna meldunku
	 * @param jj obiekt klasy Image
	 */
	public Karciochy(String x, int y, int z, Obrazek jj)
	{
		a = x;
		b = y;
		c = z;
		ii = jj;
	}
	
	/** Konstruktor tworzacy obiekt ze zmiennych wewn�trznych innego obiektu klasy karciochy
	 *  @param k obiekt klasy Karciochy */
	public Karciochy(Karciochy k)
	{
		a = k.a;
		b = k.b;
		c = k.c;
		ii = k.ii;
	}

	
	/** Metoda pobieraj�ca obiekt klasy Karciochy i przypisuj�ca go do innego obiektu tej klasy
	 *  @param k obiekt klasy Karciochy */
	public void setKart(Karciochy k)
	{
		a = k.a;
		b = k.b;
		c = k.c;
		ii = k.ii;
	}
	
	/** Metoda ustawia pobran� warto�� typu int jako meldunek karty
	 *  @param z zmienna meldunku */
	public void setMeld(int z)
	{
		c = z;
	}
	
	/** Metoda zwracaj�ca kolor karty */
	/** @return a zwracany kolorkarty */
	public String getKolor()
	{		
		return a;
	}
	
	/** Metoda zwracaj�ca litere koloru karty na zadanej pozycji ze Stringu
	 * @param f pozycja znaku do zwrucenia
	 * @return a zwracany 1 liter� koloru karty */
	public char getKolor(int f)
	{		
		return a.charAt(f);
	}
	
	/** Metoda zwracaj�ca wage punktow� karty */
	/** @return b zwracana waga punktowa karty */
	public int getPt()
	{		
		return b;
	}
	
	/** Metoda zwracaj�ca atut karty (istotne do meldunku) */
	/** @return c zwracany atut karty (jesli zajdzie taka potrzbea) */
	public int getAtut()
	{		
		return c;
	}


	public Obrazek getObrazek()
	{
		return ii;
	}

	/** Metoda zwracaj�ca obrazek karty */
	/** @return c zwracany obrazek karty */
	public Image getImg()
	{
		return ii.getImageFormObrazek();
	}

	public int getIndexImg()
	{
		return ii.getIndexFormObrazek();
	}
	
	/** Metoda zeruj�ca zadan� ilo�� zmiennych obiektu 
	 * @param ile zmienna okre�laj�ca ile wyzerowa� zmiennych */
	public void zeruj(int ile)
	{
		if(ile==2)
		{
			a = "0";
			b = 0;
		}
		else if(ile==3)
		{
			a = "0";
			b = 0;
			c = 0;	
		}			
	}
		
	/** Metoda wy�wietlaj�ca w konsoli kompilatora dan� par� String int <br>
	 * inaczej: zwraca do konsoli ca�� kart� (u�ywana do test�w) */
	public void show()
	{
		System.out.print("[" + a + "," + b + "]");
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
 
        
        a = din.readUTF();
        b = din.readInt();
        c = din.readInt();
        ii = Img.obrazkiKart[din.readInt()];
    }	
    
    
	
}


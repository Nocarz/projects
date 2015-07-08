package old;

import javax.microedition.lcdui.Image;
import java.io.*;

/** Podstawa dzia³ania ca³ego lagorytmu gry Tausend. <br>
 * Przechowuje informacje o kolorze karty i jej wadze punktowej w postaci pary String, integer i jest zajebista
 * @author Boles³aw Denk
 * @version 0.85
 */ 

public class Karciochy implements Serializer
{ 	
	String a;
	int b;
	int c;
	Obrazek ii;
	
	/** Podstawowy konstruktor domyœlny, pobierajacy parê String, integer
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
	
	/** Konstruktor, pobierajacy trójkê zmiennych String, int, int. Trzecia zmienna odpowiada za meldunek
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
	
	/** Konstruktor tworzacy obiekt ze zmiennych wewnêtrznych innego obiektu klasy karciochy
	 *  @param k obiekt klasy Karciochy */
	public Karciochy(Karciochy k)
	{
		a = k.a;
		b = k.b;
		c = k.c;
		ii = k.ii;
	}

	
	/** Metoda pobieraj¹ca obiekt klasy Karciochy i przypisuj¹ca go do innego obiektu tej klasy
	 *  @param k obiekt klasy Karciochy */
	public void setKart(Karciochy k)
	{
		a = k.a;
		b = k.b;
		c = k.c;
		ii = k.ii;
	}
	
	/** Metoda ustawia pobran¹ wartoœæ typu int jako meldunek karty
	 *  @param z zmienna meldunku */
	public void setMeld(int z)
	{
		c = z;
	}
	
	/** Metoda zwracaj¹ca kolor karty */
	/** @return a zwracany kolorkarty */
	public String getKolor()
	{		
		return a;
	}
	
	/** Metoda zwracaj¹ca litere koloru karty na zadanej pozycji ze Stringu
	 * @param f pozycja znaku do zwrucenia
	 * @return a zwracany 1 literê koloru karty */
	public char getKolor(int f)
	{		
		return a.charAt(f);
	}
	
	/** Metoda zwracaj¹ca wage punktow¹ karty */
	/** @return b zwracana waga punktowa karty */
	public int getPt()
	{		
		return b;
	}
	
	/** Metoda zwracaj¹ca atut karty (istotne do meldunku) */
	/** @return c zwracany atut karty (jesli zajdzie taka potrzbea) */
	public int getAtut()
	{		
		return c;
	}


	public Obrazek getObrazek()
	{
		return ii;
	}

	/** Metoda zwracaj¹ca obrazek karty */
	/** @return c zwracany obrazek karty */
	public Image getImg()
	{
		return ii.getImageFormObrazek();
	}

	public int getIndexImg()
	{
		return ii.getIndexFormObrazek();
	}
	
	/** Metoda zeruj¹ca zadan¹ iloœæ zmiennych obiektu 
	 * @param ile zmienna okreœlaj¹ca ile wyzerowaæ zmiennych */
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
		
	/** Metoda wyœwietlaj¹ca w konsoli kompilatora dan¹ parê String int <br>
	 * inaczej: zwraca do konsoli ca³¹ kartê (u¿ywana do testów) */
	public void show()
	{
		System.out.print("[" + a + "," + b + "]");
	}

	/** Metoda serialuzyj¹ca dane odziedziczona przez interface serializuj¹cy */
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

    /** Metoda deserialuzyj¹ca dane odziedziczona przez interface serializuj¹cy */
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


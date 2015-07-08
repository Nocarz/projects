package old;

import java.io.IOException;
import javax.microedition.lcdui.Image;

/** Przechowuje tablice sta³ych obiektów klasy Image
 * @author Boles³aw Denk
 * @version 0.75
 */ 

public class Img 
{
	Image iAS, iAK, iAT, iAP;
	Image i10S, i10K, i10T, i10P;
	Image iKS, iKK, iKT, iKP;
	Image iQS, iQK, iQT, iQP;
	Image iJS, iJK, iJT, iJP;
	Image i9S, i9K, i9T, i9P;
	static Image iB, empty, iMenL, iMenR, iTitle;
	static Image iB_rose, iB_metal, iB_tulip;
	
	/** Tablica typu Image zawieraj¹ca sta³e obiekty klasy Image */	
	public static Obrazek[] obrazkiKart = new Obrazek[24];
	static Obrazek oB, oEmpty, oMenL, oMenR;
	static Obrazek oB_rose, oB_metal, oB_tulip;
	public static Obrazek[] rewersy = new Obrazek[4];
	
	/** Metoda tworz¹ca obiekty kart i przypisuj¹ca je odpowiednim miejscom w tablicy 
	 * @exception tworzenie obiektu Image mo¿e siê nie udaæ w przypadku gdy brakuje obrazka*/
    public void makeKarty()
    {
	    try 
	    {
	    	obrazkiKart[0] = new Obrazek(i9S = Image.createImage("/9S.gif"), 0); 
	    	obrazkiKart[1] = new Obrazek(i9K = Image.createImage("/9K.gif"), 1); 
	    	obrazkiKart[2] = new Obrazek(i9T = Image.createImage("/9T.gif"), 2);
	    	obrazkiKart[3] = new Obrazek(i9P = Image.createImage("/9P.gif"), 3);
		    
	    	obrazkiKart[4] = new Obrazek(iJS = Image.createImage("/JS.gif"), 4); 
	    	obrazkiKart[5] = new Obrazek(iJK = Image.createImage("/JK.gif"), 5);
		    obrazkiKart[6] = new Obrazek(iJT = Image.createImage("/JT.gif"), 6); 
		    obrazkiKart[7] = new Obrazek(iJP = Image.createImage("/JP.gif"), 7);
		    
		    obrazkiKart[8] = new Obrazek(iQS = Image.createImage("/DS.gif"), 8);
		    obrazkiKart[9] = new Obrazek(iQK = Image.createImage("/DK.gif"), 9);
		    obrazkiKart[10] = new Obrazek(iQT = Image.createImage("/DT.gif"), 10);
		    obrazkiKart[11] = new Obrazek(iQP = Image.createImage("/DP.gif"), 11);
		    
		    obrazkiKart[12] = new Obrazek(iKS = Image.createImage("/KS.gif"), 12);
		    obrazkiKart[13] = new Obrazek(iKK = Image.createImage("/KK.gif"), 13);
		    obrazkiKart[14] = new Obrazek(iKT = Image.createImage("/KT.gif"), 14); 
		    obrazkiKart[15] = new Obrazek(iKP = Image.createImage("/KP.gif"), 15);
		    
		    obrazkiKart[16] = new Obrazek(i10S = Image.createImage("/10S.gif"), 16);
		    obrazkiKart[17] = new Obrazek(i10K = Image.createImage("/10K.gif"), 17);
		    obrazkiKart[18] = new Obrazek(i10T = Image.createImage("/10T.gif"), 18); 
		    obrazkiKart[19] = new Obrazek(i10P = Image.createImage("/10P.gif"), 19);
		    
		    obrazkiKart[20] = new Obrazek(iAS = Image.createImage("/AS.gif"), 20);
		    obrazkiKart[21] = new Obrazek(iAK = Image.createImage("/AK.gif"), 21);
		    obrazkiKart[22] = new Obrazek(iAT = Image.createImage("/AT.gif"), 22);
		    obrazkiKart[23] = new Obrazek(iAP = Image.createImage("/AP.gif"), 23);
		    		    					    
		    rewersy[0] = new Obrazek( oB = new Obrazek(iB = Image.createImage("/back.gif"), 88));
		    rewersy[1] = new Obrazek( oB_rose = new Obrazek(iB_rose = Image.createImage("/back_rose.gif"), 89));
		    rewersy[2] = new Obrazek( oB_metal = new Obrazek(iB_metal = Image.createImage("/back_steel.gif"), 90));
		    rewersy[3] = new Obrazek( oB_tulip = new Obrazek(iB_tulip = Image.createImage("/back_tulip.gif"), 91));
			oEmpty = new Obrazek(empty = Image.createImage("/empty.gif"), -88);
			
			oMenL = new Obrazek(iMenL = Image.createImage("/men_L.gif"), 98);
			oMenR = new Obrazek(iMenR = Image.createImage("/men_R.gif"), 99);
			
			iTitle = Image.createImage("/title.gif");
		} 
	    catch (IOException e) { e.printStackTrace(); } 
	    
	    
    }    
}



package old;

import java.util.Random;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/** Klasa AlonePlayer - wykonuje algorytm w trybie "sam ze sob¹"
 * @author Boles³aw Denk
 * @version 0.77
 */ 

public class AlonePlayer
{
	
	Object semafor;
	
	public Tausend mid;
	
	int karta1=0 , karta2=0;	
	int MELD_1=0, MELD_2=0, nMeldunek;
	public int zaczynajacy;
	int nA = 11;
	int n10 = 10;
	int nK = 4;
	int nD = 3;
	int nJ = 2;
	int n9 = 0;	
	
	int punktacja[] = {0, 0, 0};	
	int MELD[] = {0, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 
			200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300};	
	int ATUT[] = {100, 80, 60, 40}; //wartosc atutu na pozycji odpow. nazwom kart z NAZWY[]
	int testA2T[] = {0, 0, 0, 0}; //porownywanie z tablica ATUT, czy jest atut
	
	String NAZWY[] = {"S","K","T","P"}; // skrocone nazwy kart

	boolean BOMBA = false;
	boolean PODBICIE = false;
	boolean atut1 = false, atut2 = false;
		
	/** Tablica kart pierwszego gracza */
	public Karciochy[] gracz1 = new Karciochy[10];
	/** Tablica kart drugiego gracza */
	public Karciochy[] gracz2 = new Karciochy[10];
	
	Karciochy[] musik1 = new Karciochy[2];
	Karciochy[] musik2 = new Karciochy[2];

	Karciochy[] sort = new Karciochy[10];
	
	Random random = new Random();
	
	/** Metoda generuj¹ca liczbê losow¹ z podanego przedzia³u liczbowego
	* @param min dolny przedzia³ liczbowy
	* @param max gówny przedzia³ liczbowy */
	/** @return zwraca wygenerowan¹ liczbê w postaci ca³kowitej */
	private int getRand(int min, int max) 
	{ 		
		int r = Math.abs(random.nextInt()); 
		return (r % ((max - min + 1))) + min; 
	}
	
	/** Metoda obs³uguj¹ca rozdanie kart do poszczególnych graczy */
	public void rozdanie()
	{		
		
		String karty[] = {"Sn9", "Kn9", "Tn9", "Pn9", "SnJ", "KnJ", "TnJ", "PnJ", 
		          "SnD", "KnD", "TnD", "PnD", "SnK", "KnK", "TnK", "PnK", 
		          "Sn10", "Kn10", "Tn10", "Pn10", "SnA", "KnA", "TnA", "PnA"};	
		
		int punkty[] = {n9, n9, n9, n9, nJ, nJ, nJ, nJ, nD, nD, nD, nD, 
		        nK, nK, nK, nK, n10, n10, n10, n10, nA ,nA ,nA ,nA};
		
	
		//T_Img img = new T_Img();
						
		for(int i=0; i<10; i++) /* rozdanie do graczy */
		{
			
			int rand = getRand(0,23);		
			while(karty[rand] == "nic")
			{ 
				if(rand==23) rand=0;
				else rand++;
			}
			gracz1[i] = new Karciochy(karty[rand],punkty[rand],0,Img.obrazkiKart[rand]);
			karty[rand] = "nic";

			rand = getRand(0,23);			
			while(karty[rand] == "nic")
			{ 
				if(rand==23) rand=0;
				else rand++;
			}
			gracz2[i] = new Karciochy(karty[rand],punkty[rand],0,Img.obrazkiKart[rand]);
			karty[rand] = "nic";		
			
			sort[i] = new Karciochy("nic",0, null);
			
		}
		
		for(int i=0; i<2; i++) /* rodanie musikow */
		{
			int rand = getRand(0,23);			
			while(karty[rand] == "nic")
			{ 
				if(rand==23) rand=0;
				else rand++;
			}
			musik1[i] = new Karciochy(karty[rand],punkty[rand],0,Img.obrazkiKart[rand]);
			karty[rand] = "nic";

			rand = getRand(0,23);			
			while(karty[rand] == "nic")
			{ 
				if(rand==23) rand=0;
				else rand++;
			}
			musik2[i] = new Karciochy(karty[rand],punkty[rand],0,Img.obrazkiKart[rand]);
			karty[rand] = "nic";			
		}
		
	}				

	/** Metoda sortuj¹ca karty w talii zadanego gracza, by by³y pouk³adane wg koloró i wag punktowych
	* @param tmp obiekt klasy Karciochy
	* @param num numer gracza */
	public void sortowanie(Karciochy[] tmp, int num)
	{
		int next=0, prev=0;
		char a='1', b='2';		
		Karciochy tmpBS;
		
		for(int i=0; i<10; i++) { sort[i] = new Karciochy("0",0,null); }
		
		for(int i=0; i<4; i++)/** sortowanie po kolorach */
		{
			for(int j=0; j<10; j++) 
			{				
				String abc = tmp[j].getKolor();							
				if(abc.startsWith(NAZWY[i]))
				{
					for(int l=0; l<10; l++)
					{						
						if(sort[l].getKolor()!="0") continue;
						else if(sort[l].getKolor()=="0")
						{							
							sort[l].setKart(tmp[j]);
							break;
						}
					}
				}
			}
		}
		
		for (int j=0; j<10; j++) /**sortowanie b¹belkowe */
		{	
			for (int l=0; l<9; l++)
			{
				prev = sort[l].getPt();
				next = sort[l+1].getPt();
				
				a = sort[l].getKolor(0);
				b = sort[l+1].getKolor(0);
				
				if(prev<next && a==b)
				{
					tmpBS = new Karciochy(sort[l].getKolor(), sort[l].getPt(), sort[l].getObrazek());
		            sort[l] = sort[l+1];
		            sort[l+1] = new Karciochy(tmpBS.getKolor(), tmpBS.getPt(), tmpBS.getObrazek());
				}
			}
			//atut_test[i] = new Karciochy(NAZWY[i],ATUT[i]);
		}
				
		przepisanie(sort, num);
	}
	
	/** Metoda przepisuj¹ca posortowan¹ tablice z kartami do tablicy danego gracza okreslonego parametrem num
	* @param ka obiekt klasy Karciochy
	* @param num numer gracza */
	/** Metoda przepisuj¹ca posortowane karty do tali odpowiedniego gracza*/
	public void przepisanie(Karciochy[] ka, int num)
	{
		if(num == 1)
		{
			for(int i=0; i<10; i++)
			{
				gracz1[i] = sort[i];
				if(gracz1[i].getKolor()=="Sn9") zaczynajacy = 1;
			}
		}
		if(num == 2)
		{
			for(int i=0; i<10; i++)
			{
				gracz2[i] = sort[i];
				if(gracz2[i].getKolor()=="Sn9") zaczynajacy = 2;
			}
		}
	}

	/** Metoda sprawdzaj¹ca iloœæ atutów dla danego gracza - przydatna przy meldunkach
	 * @param num numer gracza*/
	public void sprawdzenieA22(int num)
	{
		System.out.print("\n");
		
		if(num == 1)
		{
			for(int i=0; i<4; i++)
			{	testA2T[i] = 0;
				for(int j=0; j<10; j++) //szukamy pary K&D do atutu G1
				{
					String abc = gracz1[j].getKolor();
					if(abc.startsWith(NAZWY[i]) && (abc.endsWith("K") || abc.endsWith("D")))
					{
						testA2T[i] += ATUT[i]; 
						gracz1[j].setMeld(ATUT[i]);
					}
				}
				
				testA2T[i] /= 2;
				if(testA2T[i]==ATUT[i]) //sumujemy atuty G1 do meldunku
				{
					System.out.println("Atut G1 za: " + ATUT[i] + " ");
					MELD_1 += ATUT[i];
					//A2TY[i] = 1;
					//ile_atu1 += 1;
					//pozycja atutu z tablicy ATUT przep. jest w kolejnosci do pozA22
					//if(pozA22[i]==0) pozA22[i] = i;					
				}
			}
		}
		else if(num == 2)
		{   
			for(int i=0; i<4; i++)
			{   testA2T[i] = 0;
				for(int j=0; j<10; j++) //szukamy pary K&D do atutu G2
				{
					String abc = gracz2[j].getKolor();
					if(abc.startsWith(NAZWY[i]) && (abc.endsWith("K") || abc.endsWith("D")))
					{
						testA2T[i] += ATUT[i]; 
						gracz2[j].setMeld(ATUT[i]);
					}
				}
				
				testA2T[i] /= 2;
				if(testA2T[i]==ATUT[i]) //sumujemy atuty G2 do meldunku
				{
					System.out.println("Atut G2 za: " + ATUT[i] + " ");
					MELD_2 += ATUT[i];
					/*A2TY[i] = 2;
					ile_atu2 += 1;
					for(int j=0; j<4; j++)
					{
						if(pozA22[j]==0) pozA22[j] = i;
					}*/
				}
			}
		}
		
		
	}
	
	public int pobierzWartosc(int num)
	{//pobiera zalicytowana wartosc od gracza o numerze 'num'
		
		if(mid.planszaG2.przedLicytacja == true || mid.planszaG1.przedLicytacja == true)
		{    
				    if(num==1) return mid.planszaG1.nMeldunek;	
				    else if(num==2) return mid.planszaG2.nMeldunek;	
		}
		
		return 0;
	}
	
	/** Metoda sztucznie wystawij¹ca pierwszego gracza
	 * stworzona na potrzeby obecnej konstrukcji projektu */
	public void eliminacje()
	{
		if(zaczynajacy==0) zaczynajacy = getRand(1,2); //maly random z zakresu(1,2)
		
		sprawdzenieA22(1);
		sprawdzenieA22(2);
	}
	
	/** Metoda obs³uguj¹ca licytacjê */
	public void licytacja()
	{				
		MELD_1 = 0;
		MELD_2 = 0;
				
		System.out.print("zaczyna gracz: " + zaczynajacy);
		
		boolean juzBylo = false;
		
		if(zaczynajacy==1) // LICYTUJEMY   <----------
		{	
			MELD_1 = 100;
						
			mid.planszaG2.przedLicytacja = true;
			mid.switchPlayerDisp();	
			System.out.println("\nGracz 1 melduje: 100 \nG2 przebijesz?");			
			MELD_2 = pobierzWartosc(2);
			
			if(MELD_2>MELD_1)
			{
				while(PODBICIE==false)
				{
					
					mid.planszaG1.przedLicytacja = true;
					mid.switchPlayerDisp();	
					System.out.println("\nGracz 2 melduje: " + MELD_2 + "\nG1 przebijesz?");					
					MELD_1  = pobierzWartosc(1);
					if(MELD_1==0) break; //inaczej POBICIE=true no ;p	
					
					mid.planszaG2.przedLicytacja = true;
					mid.switchPlayerDisp();	
					System.out.println("\nGracz 1 melduje: " + MELD_1 + "\nG2 przebijesz?");
					MELD_2 = pobierzWartosc(2);
					if(MELD_2==0) break;					
				}				
			}
			if(MELD_2==0)
			{
				zaczynajacy = 1;
				juzBylo = true;
				System.out.println("\nGracz 1 zaczyna meldunkiem: " + MELD_1);
			}
			else if(MELD_1==0)
			{
				zaczynajacy = 2;
				juzBylo = true;
				System.out.println("\nGracz 2 zaczyna meldunkiem: " + MELD_2);
			}
			
		}
		else if(zaczynajacy == 2 && juzBylo==false)
		{	
			MELD_2 = 100;
						
			mid.planszaG1.przedLicytacja = true;
			mid.switchPlayerDisp();	
			System.out.println("\nGracz 2 melduje: 100 \nG1 przebijesz? ");			
			MELD_1 = pobierzWartosc(1);
			
			if(MELD_1>MELD_2)
			{
				while(PODBICIE==false)
				{
					mid.planszaG2.przedLicytacja = true;
					mid.switchPlayerDisp();
					System.out.println("\nGracz 1 melduje: " + MELD_1 + "\nG2 przebijesz?");					
					MELD_2 = pobierzWartosc(2);
					if(MELD_2==0) break; //inaczej POBICIE=true no ;p
					
					mid.planszaG1.przedLicytacja = true;
					mid.switchPlayerDisp();
					System.out.println("\nGracz 2 melduje: " + MELD_2 + "\nG1 przebijesz?");					
					MELD_1 = pobierzWartosc(1);
					if(MELD_1==0) break;					
				}				
			}			
			if(MELD_2==0)
			{
				zaczynajacy = 1;
				System.out.println("\nGracz 1 zaczyna meldunkiem: " + MELD_1);
			}
			else if(MELD_1==0)
			{
				zaczynajacy = 2;
				System.out.println("\nGracz 2 zaczyna meldunkiem: " + MELD_2);
			}
		}	
	}
	
	/** Metoda obs³uguj¹ca g³ówn¹ czeœc gry */
	public void Gra(int zacz)
	{
		int iloscKart = 10;
		int next=zacz;
			
		while(punktacja[1]<=1000 || punktacja[2]<=1000) //glowna petla tysiaca
		{
			System.out.print("\n------------------GRA----------------------");
			
			boolean koniecTali = false;
			int punkty1=0, punkty2=0;			
			
			while(koniecTali==false) //petla rozdania
			{
				char kolor1, kolor2;
				char nic = '0';
				boolean niMa = false;
				
				if(next==1)
				{
					System.out.print("\nG1 wybierz karte: ");
					
					int k1 = GfxGame.selectedItem;	
					
					kolor1 = gracz1[k1].getKolor(0);
					karta1 = gracz1[k1].getPt();
					
					/*while(kolor1==nic)
					{
						System.out.print("\n" + kolor1 + karta1+ " ju¿ by³a wybierz inna: ");
						k1 = pobierz.GetInt();
						kolor1 = gracz1[k1].getKolor(0);
						karta1 = gracz1[k1].getPt();
					}*/					
					gracz1[k1] = new Karciochy("0",0,null);					
					System.out.print("karta GRACZA 1: " + kolor1 + karta1);
					
					niMa=true;
					for(int i=0; i<10; i++) //sprawdzamy czy G2 ma karte z koloru
					{
						kolor2 = gracz2[i].getKolor(0);
						if(kolor1==kolor2) 
						{
							niMa=false;
							break;
						}
						if(i==9 && niMa==false && kolor1!=kolor2) niMa=true;
						else niMa=false;
					}
					
					System.out.print("\nG2 wybierz karte: ");
					int k2 = pobierz.GetInt();
					kolor2 = gracz2[k2].getKolor(0);
					if(niMa==false || kolor2==nic)
					{
						while(kolor1!=kolor2 || kolor2==nic)
						{
							if(kolor1!=kolor2) System.out.print("--Wybierz karte z KOLORU " + kolor1 + ": ");
							else if(kolor2==nic)System.out.print("--TA ju¿ by³a wybierz inn¹ karte: ");
							k2 = pobierz.GetInt();
							kolor2 = gracz2[k2].getKolor(0);
						}							
					}							
					karta2 = gracz2[k2].getPt();						
					gracz2[k2] = new Karciochy("0",0,null);
					
					System.out.print("karta GRACZA 2: " + kolor2 + karta2 +"\n");
					
					if(karta1>karta2 || niMa==true)
					{
						punkty1 += (karta1+karta2); 
						next=1;
						System.out.print("g1 zdoby³: " + (karta1+karta2) + " ("+ punkty1+")\n");
					}
					else if(karta2>karta1 && niMa==false) 
					{
						punkty2 += (karta1+karta2); 
						next=2;
						System.out.print("g2 zdoby³: " + (karta1+karta2) + " ("+ punkty2+")\n");
					}
					
					iloscKart -= 1;
				}
				else if(next==2)
				{
					System.out.print("\nG2 wybierz karte: ");
					int k2 = pobierz.GetInt();					
					kolor2 = gracz2[k2].getKolor(0);
					karta2 = gracz2[k2].getPt();
					while(kolor2==nic)
					{
						System.out.println("TA ju¿ by³a wybierz inna: ");
						k2 = pobierz.GetInt();
						kolor2 = gracz2[k2].getKolor(0);
						karta2 = gracz2[k2].getPt();
					}					
					gracz2[k2] = new Karciochy("0",0,null);					
					System.out.print("karta GRACZA 2: " + kolor2 + karta2);
					
					niMa=true;
					for(int i=0; i<10; i++) //sprawdzamy czy G2 ma karte z koloru
					{
						kolor1 = gracz1[i].getKolor(0);
						if(kolor1==kolor2) 
						{
							niMa=false;
							break;
						}
						if(i==9 && niMa==false && kolor1!=kolor2) niMa=true;
						else niMa=false;
					}
					
					System.out.print("\nG1 wybierz karte: ");
					int k1 = pobierz.GetInt();
					kolor1 = gracz1[k1].getKolor(0);
					if(niMa==false || kolor1==nic)
					{
						while(kolor1!=kolor2 || kolor1==nic)
						{
							if(kolor1!=kolor2) System.out.print("--Wybierz karte z KOLORU " + kolor2 + ": ");
							else if(kolor1==nic)System.out.print("--TA ju¿ by³a wybierz inn¹ karte: ");
							k1 = pobierz.GetInt();
							kolor1 = gracz1[k1].getKolor(0);
						}							
					}							
					karta1 = gracz1[k1].getPt();						
					gracz1[k1] = new Karciochy("0",0,null);
					
					System.out.print("karta GRACZA 1: " + kolor1 + karta1 +"\n");
					
					if(karta2>karta1 || niMa==true)
					{
						punkty2 += (karta1+karta2); 
						next=2;
						System.out.print("g2 zdoby³: " + (karta1+karta2) + " ("+ punkty2+")\n");
					}
					else if(karta1>karta2 && niMa==false) 
					{
						punkty1 += (karta1+karta2); 
						next=1;
						System.out.print("g1 zdoby³: " + (karta1+karta2) + " ("+ punkty2+")\n");
					}
					
					iloscKart -= 1;
				}
				
				/*if(zacz==1 && iloscKart==0)
				{
					if(punkty1>=MELD_1)	punktacja[1] += punkty1;
					else if(punkty1<MELD_1) punktacja[1] -= MELD_1;
				}
				else if(zacz==2 && iloscKart==0)
				{
					if(punkty2>=MELD_2)	punktacja[2] += punkty2;
					else if(punkty2<MELD_2) punktacja[2] -= MELD_2;
				}*/
				
				if(iloscKart==0)
				{
					koniecTali = true;
					iloscKart = 10;
				}
			}
			
			if(zacz==1)
			{
				if(punkty1>=MELD_1)	punktacja[1] += punkty1;
				else if(punkty1<MELD_1) punktacja[1] -= MELD_1;
			}
			else if(zacz==2)
			{
				if(punkty2>=MELD_2)	punktacja[2] += punkty2;
				else if(punkty2<MELD_2) punktacja[2] -= MELD_2;
			}
			
			System.out.print("\n------G1: " + punktacja[1] + " G2: " + punktacja[2] + "--------\n");
			System.out.print("\n");
			s1();
		}		
		
		if(punktacja[1]>=1000)
		{
			System.out.print("Wygra³ Gracz 1");
		}
		else if(punktacja[2]>=1000)
		{
			System.out.print("Wygra³ Gracz 2");
		}
	}
	
	/*public static void main(String[] args)
	{
		new AlonePlayer();
	}*/
	
	/** Konstruktor domyœlny
	 * @param mid pobiera referencje do midletu */
	public AlonePlayer(Tausend mid)
	{
		super(); 
		this.mid = mid;
		zaczynajacy = 0;
	}

}

package Viikko6Paivamaarat;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.YearMonth;



public class Kalenteri {


	public static void tulostaKalenteri (int vuosi, int kuukausi) {
		
		//Haetaan kuukauden tiedot
		
		YearMonth kuukausiOlio = YearMonth.of(vuosi, kuukausi);
		
		// Viikon ensimmäisen Päivän tiedot
		
		LocalDate ekaPaiva = kuukausiOlio.atDay(1);
		
		// kuukauden viimeisen päivän tiedot
		
		LocalDate vikaPaiva = kuukausiOlio.atEndOfMonth();
		
		System.out.println("Ma Ti Ke To Pe La Su");
		
		// tulostetaan tarvittavat tyhjät kohdat jotta päivät menee oikeaan kohtaan
		
		for(int i = 1; i < ekaPaiva.getDayOfWeek().getValue(); i++) {
			System.out.print("   ");
			
		}
		//Otetaan talteen ensimmäinen päivä, koska ei haluta hukata niitä
		
		LocalDate nykyinen = ekaPaiva;
		
		//silmukka jolla toistetaan päiviä kunnessa ollaan kuukauden viimeisessä päivässä
		
		while(!nykyinen.isAfter(vikaPaiva)) {
			int paiva = nykyinen.getDayOfMonth();
			//tulostetaan numero näytölle
			
			System.out.print(venytaKolmeksi(paiva));
			
			boolean sunnuntai = false;
			
			//Jos päivä on sunnuntai pitää tulostaa rivinvaihto
			
			if (nykyinen.getDayOfWeek().getValue()==7) {
				sunnuntai = true;
			}
			if (sunnuntai == true) {
				System.out.println();
			}
			nykyinen = nykyinen.plusDays(1);	
		}
	}
	
			//Tehdään metodi joka korjaa kalenterin tulostusasun
	
	public static String venytaKolmeksi(int numero) {
		
			//jos numero on yksinumeroinen lisätään ohjelmaan kahdenvälilyönnin venytys
		
			if(numero < 10) {
			return numero + "  ";
		}
		
			//Jos numero on kaksinumeroinen tulee vain yksivälilyönti
		
			return numero + " ";
	
		
	}
	
	public static void main(String[] args) {
		
			Scanner input = new Scanner(System.in);
	
			System.out.print("Syötä vuosi: ");
			int vuosi = input.nextInt();
		
			System.out.print("Syötä kuukausi: ");
			int kuukausi = input.nextInt();
		
			System.out.println();
		
			tulostaKalenteri(vuosi, kuukausi);
	}

}

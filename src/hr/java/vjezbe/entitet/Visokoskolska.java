package hr.java.vjezbe.entitet;

import java.math.BigDecimal;


public interface Visokoskolska {
	
	public BigDecimal izracunajKonacnuOcjenuStudijaZaStudenta(Ispit[] studentIspit, Integer ocjenaPismenogRada, Integer ocjenaObraneZavrsnogRada);
		
	public default BigDecimal odrediProsjekOcjenaNaIspitima(Ispit[] ispit) {
		Integer sum = null;
		Integer prosjekOcjena = null;
		BigDecimal bigDecimal = null;
		
		Ispit[] ispitici = filtrirajPolozeneIspite(ispit);
		
		for (int i = 0; i < ispitici.length && ispitici[i] != null; i++) {
			
			sum =+ ispitici[i].getOcjena();
			
		}	
		prosjekOcjena = sum / ispitici.length;
		
		bigDecimal = BigDecimal.valueOf(prosjekOcjena);
		
		return bigDecimal;
		
	}
		
	private Ispit[] filtrirajPolozeneIspite(Ispit[] ispit) {
	
		Integer counter = 0;
		
		for (int i = 0; i < ispit.length; i++) {
			if (ispit[i].getOcjena() >= 2) {
				counter++;			
			}
		}	
			Ispit[] ispits3 = new Ispit[counter]; 	
			
		for (int j = 0; j < ispit.length; j++) {
			if (ispit[j].getOcjena() >= 2) {
				Ispit ispit2 = ispit[j];	
				ispits3[j] = ispit2;
			}
			
			
		}
			
	return ispits3;
				
	}
	
	
	default public Ispit[] filtrirajIspitePoStudentu(Ispit[] ispit, Student student) {
				
	    Integer counter = 0;
	    
		for (int i = 0; i < ispit.length; i++) {
			if (ispit[i].getStudent().getIme().equals(student.getIme()) && ispit[i].getStudent().getPrezime().equals(student.getPrezime())) {
            	counter++;
			}
		}
		
		Ispit[] ispit3 = new Ispit[counter];
		
		for (int i = 0; i < ispit.length; i++) {
			
            if (ispit[i].getStudent().getIme().equals(student.getIme()) && ispit[i].getStudent().getPrezime().equals(student.getPrezime())) {
            	Ispit ispit2 = ispit[i];
            	ispit3[i] = ispit2;
			}		
			
		}
		
		return ispit3;
	}

}

//pitamo pitanje ?, je li age veci od 50? da ili ne
// ako je vece odnosno da(true) -> ispisi prvi statement
// ako je manje odnosno ne(false) -> ipisi drugi statement
//	System.out.println(age > 50 ? "You are old" : "You are young");

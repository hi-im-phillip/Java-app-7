package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

public class FakultetRacunarstva extends ObrazovnaUstanova implements Diplomski {

	public FakultetRacunarstva(String nazivUstanove, Predmet[] predmetObrazovneUstanove, Profesor[] profesorObrazovneUstanove, 
			                   Student[] studentObrazovneUstanove, Ispit[] ispitObrazovneUstanove) {
		super(nazivUstanove, predmetObrazovneUstanove, profesorObrazovneUstanove, studentObrazovneUstanove, ispitObrazovneUstanove);
		
	}

	@Override
	public Student odrediNajuspjesnijegStudentaNaGodini(Integer godina) {
		
		int counter = 0;
		FakultetRacunarstva obrazovnaUstanova;
		
		for (Student student2 : getStudent()) {
			if (student2.getDatumRodenja().getDayOfYear() == godina) {
				for (Ispit ispitic : getIspit()) {
					if (ispitic.getOcjena() == 5 && ispitic.getStudent().getPrezime().equals(student2.getPrezime())) {
						System.out.println(ispitic.getStudent().getPrezime() + ispitic.getStudent().getIme() + counter++);
						if (counter > 1) {
							
						}
					}
				}
			}
		}
		
		for (Student student2 : getStudent()) {
			if (student2.getDatumRodenja().getDayOfYear() == godina) {
				for (Ispit ispitic : getIspit()) {
					if (ispitic.getOcjena() == 5 && ispitic.getStudent().getPrezime().equals(student2.getPrezime())) {
						System.out.println(ispitic.getStudent().getPrezime() + ispitic.getStudent().getIme() + counter++);
						if (counter > 1) {
							
						}
					}
				}
			}
		}
		
		
		return null;
	}
	
	
	@Override
	public Student odrediStudentaZaRektorovuNagradu() {
		
		return null;
	}
	

	@Override
	public BigDecimal izracunajKonacnuOcjenuStudijaZaStudenta(Ispit[] studentIspit, Integer ocjenaPismenogRada, Integer ocjenaObraneDiplomskogRada) {
		
		
		BigDecimal bDecimal = odrediProsjekOcjenaNaIspitima(studentIspit);
		
		Integer prosjekOcjena = bDecimal.intValue();
		
		Integer konacnaOcjena = ((3 * prosjekOcjena + ocjenaPismenogRada + ocjenaObraneDiplomskogRada) / 5);
		
		BigDecimal bigDecimal = BigDecimal.valueOf(konacnaOcjena);
		
		
			
		return bigDecimal;
		
		
	}
	
	
	public Ispit[] filtrirajIspitePoStudentu(Ispit[] ispit, Student student) {

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
	
	
	public BigDecimal odrediProsjekOcjenaNaIspitima(Ispit[] ispit) {
		Integer sum = null;
		Integer prosjekOcjena = null;
		BigDecimal bigDecimal = null;
		Integer counter = 0;
		
				
		for (int i = 0; i < ispit.length && ispit[i] != null; i++) {
			if (ispit[i].getOcjena() >= 2) {
				sum =+ ispit[i].getOcjena();
				counter++;
			}			
			
		}	
		
		prosjekOcjena = sum / counter;
		
		bigDecimal = BigDecimal.valueOf(prosjekOcjena);
		
		return bigDecimal;
		
	}
	


}

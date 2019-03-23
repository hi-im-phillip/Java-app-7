package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;


public class VeleucilisteJave extends ObrazovnaUstanova implements Visokoskolska{

	public VeleucilisteJave(String nazivUstanove, Predmet[] predmetObrazovneUstanove, Profesor[] profesorObrazovneUstanove, 
			                Student[] studentObrazovneUstanove, Ispit[] ispitObrazovneUstanove) {
		super(nazivUstanove, predmetObrazovneUstanove, profesorObrazovneUstanove, studentObrazovneUstanove, ispitObrazovneUstanove);
		      setNaziv(nazivUstanove);
		      setPredmet(predmetObrazovneUstanove);
		      setProfesor(profesorObrazovneUstanove);
		      setStudent(studentObrazovneUstanove);
		      setIspit(ispitObrazovneUstanove);
		      
	}

	@Override
	public Student odrediNajuspjesnijegStudentaNaGodini(Integer godina) {
		
		Scanner scanner = new Scanner(System.in);
		String nazivObrUst;
		Integer ocjenaPismenogRada;
		Integer ocjenaObraneZavrsnogRada;
		Integer biranjeUstanove;
		int counter = 0;
		Metode metode = new Metode();
		BigDecimal bigDecimal = null;
		Integer parsedBD;
		Integer[] parsedBDArray = new Integer[getStudent().length];
		String[] listaStringa = new String[getStudent().length];
		Student[] studentic = new Student[getStudent().length];
		
//		for (Student student2 : getStudent()) {
//			if (student2.getDatumRodenja().getDayOfYear() == godina) {
//				for (Ispit ispitic : getIspit()) {
//					if (ispitic.getOcjena() == 5 && ispitic.getStudent().getPrezime().equals(student2.getPrezime())) {
//						System.out.println(ispitic.getStudent().getPrezime() + ispitic.getStudent().getIme() + counter++);
//						if (counter > 1) {
//							
//						}
//					}
//				}
//			}
//		}
		
		String msgNazivObrUst = "Unesite naziv obrazovne ustanove:";
		nazivObrUst = metode.emptyCheckerString(scanner, msgNazivObrUst);
		
		String msgOcjenaPism = "Unesite ocjenu završnog rada za studenta:";
		ocjenaPismenogRada = metode.emptyCheckerInteger(scanner, msgOcjenaPism);
		
		String msgOcjenaZavrRad = "Unesite ocjenu obrane završnog rada za studenta:";
		ocjenaObraneZavrsnogRada = metode.emptyCheckerInteger(scanner, msgOcjenaZavrRad);
		
		for (int i = 0; i < getStudent().length; i++) {
			 studentic = getStudent();					
					bigDecimal = izracunajKonacnuOcjenuStudijaZaStudenta(getIspit(), ocjenaPismenogRada, ocjenaObraneZavrsnogRada);
					parsedBD = bigDecimal.intValue();
					listaStringa[i] = Integer.toString(parsedBD) + studentic[i].getIme() + " " + studentic[i].getPrezime();
					parsedBDArray[i] = parsedBD;
					System.out.println("Konacna ocjena studenta " + studentic[i].getIme() + " " + studentic[i].getPrezime() + " je " + parsedBDArray[i]);		
		}
		Arrays.sort(listaStringa, (p1, p2) -> p1.compareTo(p2));
		System.out.println(Arrays.toString(listaStringa));
//		for (int i = 0; i < parsedBDArray.length; i++) {
//			
//		}
//		Arrays.sort(parsedBDArray, (p1, p2) -> p1.compareTo(p2));
//		System.out.println(Arrays.toString(parsedBDArray));

		return studentic[0];
		
	}
// filtiranepostudentu predajemo, te on unutar izracunava prosjekocjene i sa tim prosjekom konacni rezultat
	@Override
	public BigDecimal izracunajKonacnuOcjenuStudijaZaStudenta(Ispit[] studentIspit, Integer ocjenaPismenogRada, Integer ocjenaObraneZavrsnogRada) {
	
				
		BigDecimal bDecimal = odrediProsjekOcjenaNaIspitima(studentIspit);
		
		Integer prosjekOcjena = bDecimal.intValue();
		
		Integer konacnaOcjena = ((2 * prosjekOcjena + ocjenaPismenogRada + ocjenaObraneZavrsnogRada) / 4);
		
		BigDecimal bigDecimal = BigDecimal.valueOf(konacnaOcjena);
		
		
			
		return bigDecimal;
		
		
	}
// filtrira ispite i sa vracenim ispitom se stavlja u izracunajKonancu...
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
//Scanner scanner = new Scanner(System.in);
//Integer ocjenaPismenog = null;
//Integer ocjenaObrane = null;
//BigDecimal konacnaOcjena = null;
//Student[] student = new Student[getStudent().length];
//
//
//for (int i = 0; i < getStudent().length; i++) {
//	student = getStudent();
//	
//	System.out.println("Unesite ocjenu završnog rada za studenta" + student[i].getIme());
//	ocjenaPismenog = scanner.nextInt();
//	
//	System.out.println("Unesite ocjenu obrane završnog rada za studenta:" + student[i].getIme());
//	ocjenaObrane = scanner.nextInt();
//	
//	
//	
//	System.out.println("Konaèna ocjena studija studenta " + student[i].getIme() + " je "  + konacnaOcjena);
//	
//	
//}
//konacnaOcjena = izracunajKonacnuOcjenuStudijaZaStudenta(getIspit(), ocjenaPismenog, ocjenaObrane);
//
//scanner.close();
//
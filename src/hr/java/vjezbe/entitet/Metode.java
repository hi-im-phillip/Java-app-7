package hr.java.vjezbe.entitet;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import hr.java.vjezbe.glavna.Glavna2;


public class Metode {
	
	public static final int BROJ_PROFESORA = 1;
	public static final int BROJ_PREDMETA = 2;
	public static final int BROJ_ISPITA = 2;
	
	public static final String FORMAT_DATE_TIME = "dd.MM.yyyy.'T'HH:mm";
	public static final String FORMAT_DATE = "dd.MM.yyyy.";
	
	public Profesor[] fillProfesor(Scanner scanner) {
		
		Profesor[] profesor = new Profesor[BROJ_PROFESORA];
		String sifraProfesor = "";	
		String imeProfesor = "";
		String prezimeProfesor = "";
		String titulaProfesora = "";
		
		
		for(int i = 0; i < profesor.length; i++) {

			System.out.println("Unesite " + (i+1) + "." + " profesora: ");

			String msgProfesorSifra = "Unesite šifru profesora:  ";
			sifraProfesor = emptyCheckerString(scanner, msgProfesorSifra);
			
			while(!NumberUtils.isDigits(sifraProfesor)) {
				System.out.println("Samo brojevi dozvoljeni!");
				sifraProfesor = emptyCheckerString(scanner, msgProfesorSifra);
			}
			
			for (int k = 0; k < profesor.length && profesor[k] != null; k++) {
				Profesor profesor2 = profesor[k];
				while (profesor2.getSifra().equals(sifraProfesor)) {
					System.out.println("Ta sifra ti je vec zauzeta! Daj drugu neku.");
					sifraProfesor = emptyCheckerString(scanner, msgProfesorSifra);
				}
			}

			String msgProfesorName = "Unesite ime profesora: ";
			imeProfesor = emptyCheckerString(scanner, msgProfesorName);

			String msgProfesorSurname = "Unesite prezime profesora: ";
			prezimeProfesor = emptyCheckerString(scanner, msgProfesorSurname);

			String msgProfesorTitula = "Unesite titulu profesora: ";
			titulaProfesora = emptyCheckerString(scanner, msgProfesorTitula);

			profesor[i] = new Profesor(sifraProfesor, StringUtils.capitalize(imeProfesor), StringUtils.capitalize(prezimeProfesor), titulaProfesora);		

		}		
		return profesor;		
	}
	
	
	public Predmet[] fillPredmet(Scanner scanner, Profesor[] profesorObjekt) {
			
		Predmet[] predmet = new Predmet[BROJ_PREDMETA];	
		Profesor profesorOdabir;
		String sifraPredmet = "";
		String nazivPredmet = "";
		Integer brojEctsBodovaPredmet = 0;
		Integer studentPredmetInt = 0;
		
			
		for(int i = 0; i < predmet.length; i++) {

			int h = 1;
			System.out.println("Unesite " + (i+1) + "." + " predmet: ");

			String msgPredmetSifra = "Unesite šifru predmeta: ";
			sifraPredmet = emptyCheckerString(scanner, msgPredmetSifra);			

			for (int k = 0; k < predmet.length && predmet[k] != null; k++) {
				Predmet predmet2 = predmet[k];
				while (predmet2.getSifra().equals(sifraPredmet)) {
					System.out.println("Nije dostupna unesena šifra. Probaj drugu.");
					sifraPredmet = emptyCheckerString(scanner, msgPredmetSifra);
				}

			}

			String msgPredmetName = "Unesite naziv predmeta: ";
			nazivPredmet = emptyCheckerString(scanner, msgPredmetName);
			
			for (int j = 0; j < predmet.length && predmet[j] != null; j++) {
				Predmet predmet2 = predmet[j];
				while (predmet2.getNaziv().equals(nazivPredmet)) {
					System.out.println("Ime je veæ unešeno. Probaj drugo.");
					nazivPredmet = emptyCheckerString(scanner, msgPredmetName);
				}
				
			}

			String msgPredmetECTS = "Unesite broj ECTS bodova za predmet " + nazivPredmet + ":";
			brojEctsBodovaPredmet = emptyCheckerInteger(scanner, msgPredmetECTS);				

			System.out.println("Odaberite profesora: ");		
			for (Profesor profac : profesorObjekt) {
				System.out.println(h++ + ". " + profac.getIme() + " " + profac.getPrezime());
			}				
			Integer odabirProfesor = scanner.nextInt();
			scanner.nextLine();

			while (odabirProfesor > profesorObjekt.length || odabirProfesor <= 0) {
				System.out.println("Nedozvoljen broj.");
				System.out.println("Odaberite profesora: ");
				odabirProfesor = scanner.nextInt();
				scanner.nextLine();
			}

			profesorOdabir = profesorObjekt[odabirProfesor - 1];
			System.out.println("Vaš odabir profesora je " + odabirProfesor + ". " + profesorObjekt[odabirProfesor - 1].getTitula() + "."
					+ profesorObjekt[odabirProfesor - 1].getIme() + " " + profesorObjekt[odabirProfesor - 1].getPrezime());

			String msgPredmetBrStud = "Unesite broj studenta za predmet " + nazivPredmet + ":";
			studentPredmetInt = emptyCheckerInteger(scanner, msgPredmetBrStud);				
			Student[] studentPredmet = new Student[studentPredmetInt];
			

			predmet[i] = new Predmet(sifraPredmet, StringUtils.capitalize(nazivPredmet), brojEctsBodovaPredmet, profesorOdabir, studentPredmet);

		}			

		return predmet;
	}
	
	
	public Student[] fillStudent(Scanner scanner, Predmet[] predmet) {
		
		int sum = 0;
		
		String imeStudent = "";
		String prezimeStudent = "";
		String jmbagStudent = "";
		LocalDate datumRodenjaStudenta = null;
		
		
		for (Predmet predmetObjekt : predmet) {
			int lengthStudentObjArray = predmetObjekt.getStudent().length;
			  sum = lengthStudentObjArray + sum;
		}
				
		Student[] student = new Student[sum];
		
				
		for(int i = 0; i < student.length; i++) {

			System.out.println("Unesite " + (i+1) + "." + " studenta:");

			String msgStudentName = "Unesite ime studenta: ";
			imeStudent = emptyCheckerString(scanner, msgStudentName);

			String msgStudentSurname = "Unesite prezime studenta: ";
			prezimeStudent = emptyCheckerString(scanner, msgStudentSurname);

			String msgDateStudent = "Unesite datum roðenja za studenta " + prezimeStudent + " " + imeStudent + " u formatu (dd.MM.yyyy.)";
			datumRodenjaStudenta = dateChecker(scanner, msgDateStudent);

			String msgStudentJMBAG = "Unesite JMBAG studenta: ";
			jmbagStudent = emptyCheckerString(scanner, msgStudentJMBAG);

			for (int k = 0; k < student.length && student[k] != null; k++) {
				Student student2 = student[k];
				while (student2.getJmbag().equals(jmbagStudent)) {
					System.out.println("JMBAG veæ postoji. Upiši ti drugi.");
					jmbagStudent = emptyCheckerString(scanner, msgStudentJMBAG);
				}	
			}

			
			student[i] = new Student(StringUtils.capitalize(imeStudent), StringUtils.capitalize(prezimeStudent), jmbagStudent, datumRodenjaStudenta);
	
			
		}

		return student;
	}

	
	public Ispit[] fillIspit(Scanner scanner, Predmet[] predmet, Student[] student) {
		
		Predmet predmetIspita;
		Student studentIspita;
		Ispit[] ispit = new Ispit[BROJ_ISPITA];
		Integer ocjenaIspita = 0;
			
		
		for (int i = 0; i < ispit.length; i++) {

			int s = 1;
			int p = 1;
			
			System.out.println("Unesite " + (i+1) + ". " + "ispitni rok: ");
			
			System.out.println("Odaberite predmet: ");		
			for (Predmet predmetObj : predmet) 
			{
				System.out.println(p++ + ". " + predmetObj.getNaziv());
			}		
			Integer odabirPredmeta = scanner.nextInt();
			scanner.nextLine();				
			while (odabirPredmeta > predmet.length || odabirPredmeta <= 0) {
				System.out.println("Morate odabrati jedan od ponuðenih predmeta.");
				System.out.println("Odaberite predmet: ");	
				odabirPredmeta = scanner.nextInt();
				scanner.nextLine();
			}		
			predmetIspita = predmet[odabirPredmeta - 1];
			System.out.println("Vaš odabir predmeta je " + odabirPredmeta + ". " + predmet[odabirPredmeta - 1].getNaziv());

			System.out.println("Odaberite studenta: ");
			for (Student studentObj : student) 
			{
				System.out.println(s++ + ". " + studentObj.getIme() + " " + studentObj.getPrezime());
			}				
			Integer odabirStudenta = scanner.nextInt();
			scanner.nextLine();	
			while (odabirStudenta > student.length || odabirStudenta == 0) {
				System.out.println("Morate odabrati nešto od ponuðenog.");
				System.out.println("Odaberite studenta: ");
				odabirStudenta = scanner.nextInt();
				scanner.nextLine();
			}		
			studentIspita = student[odabirStudenta - 1];
			predmet[odabirPredmeta - 1].setStudent(Arrays.copyOfRange(student, odabirStudenta - 1, odabirStudenta));
			System.out.println("Vaš odabir studenta je " + odabirStudenta + ". " + student[odabirStudenta - 1].getIme() + " " + student[odabirStudenta - 1].getPrezime());
            
	//		Student[] student3 = new Student[1];
			
	//		addStudent(studentIspita, student3);
	//		System.arraycopy(student3, 0, student4, i, student3.length);
	//		predmet[odabirPredmeta - 1].setStudent(student4);
			
		//	resetStudentArray(student3);
			
			
			// IN PROGRESS
//			for (Predmet predmet2 : predmet) {
//				 Arrays.sort(predmet, (a, b) -> a.getNaziv().compareTo(b.getNaziv()));
//					System.out.println(r++ + ". " + Arrays.asList(predmet2.getNaziv().replace("[]", "")));
//			}
//			Arrays.sort(predmet, (a, b) -> a.getNaziv().compareTo(b.getNaziv()));
//			System.out.println(r++ + ". " + Arrays.asList(predmet.toString()));
            
			String msgIspitOcj = "Unesite ocjenu na ispitu (1-5): ";
			ocjenaIspita = emptyCheckerInteger(scanner, msgIspitOcj);

			while (ocjenaIspita > 5 || ocjenaIspita == 0) {
				System.out.println("Krivo unešena ocjena!. Pokušaj ponovo.");
				ocjenaIspita = emptyCheckerInteger(scanner, msgIspitOcj);
			}

			String msgDatumIVrijemeIspit = "Unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.THH:mm):";
			LocalDateTime datumIVrijemeIspita = dateTimeChecker(scanner, msgDatumIVrijemeIspit);
            
			
			
			
			
			ispit[i] = new Ispit(predmetIspita, studentIspita, ocjenaIspita, datumIVrijemeIspita);

		}
		return ispit;		
	}
	
	
	public ObrazovnaUstanova[] fillObrazovnaUstanova(Scanner scanner, Predmet[] predmetObrazovneUstanove, Profesor[] profesorObrazovneUstanove, 
            Student[] studentObrazovneUstanove, Ispit[] ispitObrazovneUstanove) {
		
		String nazivObrUst;
		Integer ocjenaPismenogRada;
		Integer ocjenaObraneZavrsnogRada;
		Integer biranjeUstanove;
		
		ObrazovnaUstanova[] obrazovnaUstanova = new ObrazovnaUstanova[Glavna2.BROJ_USTANOVA];
		
		for (int i = 0; i < obrazovnaUstanova.length; i++) {
		
		String msgBiranje = "Odaberite obrazovnu ustanovu za navedene podatke koju želite unijeti" + " 1 - " + VeleucilisteJave.class.getSimpleName() + 
				           " 2 - " + FakultetRacunarstva.class.getSimpleName();
		biranjeUstanove = emptyCheckerInteger(scanner, msgBiranje);
		
		while (biranjeUstanove > 2 && biranjeUstanove <= 0) {
			System.out.println("Krivo odabran broj. Probaj ponovo!");
			biranjeUstanove = emptyCheckerInteger(scanner, msgBiranje);
		}
		
		
			
		String msgNazivObrUst = "Unesite naziv obrazovne ustanove:";
		nazivObrUst = emptyCheckerString(scanner, msgNazivObrUst);
		
//		String msgOcjenaPism = "Unesite ocjenu završnog rada za studenta:";
//		ocjenaPismenogRada = emptyCheckerInteger(scanner, msgOcjenaPism);
		
//		String msgOcjenaZavrRad = "Unesite ocjenu obrane završnog rada za studenta:";
//		ocjenaObraneZavrsnogRada = emptyCheckerInteger(scanner, msgOcjenaZavrRad);
		
		if (biranjeUstanove == 1) {
			
			
			
			obrazovnaUstanova[i] = new VeleucilisteJave(nazivObrUst, predmetObrazovneUstanove, profesorObrazovneUstanove, predmetObrazovneUstanove[i].getStudent(), ispitObrazovneUstanove);
			
	//		BigDecimal bigDecimal = ((VeleucilisteJave)obrazovnaUstanova[i]).izracunajKonacnuOcjenuStudijaZaStudenta(ispitObrazovneUstanove, ocjenaPismenogRada, ocjenaObraneZavrsnogRada);
			
	//		System.out.println("Konaèna ocjena studija studenta" + studentObrazovneUstanove[i].getIme() + " " + studentObrazovneUstanove[i].getPrezime() 
	//				           + " je " + bigDecimal);
			
			Student student = ((VeleucilisteJave)obrazovnaUstanova[i]).odrediNajuspjesnijegStudentaNaGodini(2018);
			
			System.out.println("Najbolji student 2018. godine je" + student.getIme() + " " + student.getPrezime() + " " + student.getJmbag());
		} else {
			
			
			obrazovnaUstanova[i] = new FakultetRacunarstva(nazivObrUst, predmetObrazovneUstanove, profesorObrazovneUstanove, studentObrazovneUstanove, ispitObrazovneUstanove);
			
//			BigDecimal bigDecimal = ((FakultetRacunarstva)obrazovnaUstanova[i]).izracunajKonacnuOcjenuStudijaZaStudenta(ispitObrazovneUstanove, ocjenaPismenogRada, ocjenaObraneZavrsnogRada);
			
//			System.out.println("Konaèna ocjena studija studenta" + studentObrazovneUstanove[i].getIme() + " " + studentObrazovneUstanove[i].getPrezime() 
//					           + " je " + bigDecimal);
			
		}
		
				
		
		}
	
				
		return obrazovnaUstanova;
		
	}
	
	
	public void checkerOcjenaStudenta(Ispit[] ispitStudent) {
		
		String ocjenaIspitString;
						
		for (Ispit ispiti : ispitStudent) {
			if (ispiti.getOcjena() == 5) {
				switch (ispiti.getOcjena()) {
				case 1:
					ocjenaIspitString = "nedovoljan";
					break;
				case 2:
					ocjenaIspitString = "dovoljan";
					break;
				case 3:
					ocjenaIspitString = "dobar";
					break;
				case 4:
					ocjenaIspitString = "vrlo dobar";
					break;
				case 5:
					ocjenaIspitString = "odlièan";
					break;
				default:
					ocjenaIspitString = "nedovoljan";
					break;
					}
					System.out.println("Student " + ispiti.getStudent().getIme() + " " + ispiti.getStudent().getPrezime() + " je ostvario ocjenu " + ocjenaIspitString
	                   + " na predmetu " + ispiti.getPredmet().getNaziv());
				}		
		}		
	}
	
	
	public String emptyCheckerString(Scanner scanner, String message) {
		
		String scanString;
		System.out.println(message);
		scanString = scanner.nextLine();
			
		while (scanString.length() == 0) {
				
			System.out.println("Prazno polje!");
			System.out.println(message);
			scanString = scanner.nextLine();
		}			
		return scanString;
	}
	
	
	public Integer emptyCheckerInteger(Scanner scanner, String message) {

		String scanString;
		Integer scanInteger;
		System.out.println(message);		
		scanString = scanner.nextLine();
					
		while (scanString.length() == 0) {
				
			System.out.println("Prazno polje!");
			System.out.println(message);
			scanInteger = scanner.nextInt();
			scanner.next();
		}		
		scanInteger = Integer.valueOf(scanString);
		return scanInteger;
		
	}
	
	public LocalDate dateChecker(Scanner scanner, String msg) {
		
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
		
		String date = "01.01.1925.";
		LocalDate todayParsed = LocalDate.parse(date, formatter);  
		
		System.out.println(msg);			
		String datumRodenjaStudentaString = scanner.nextLine();
		LocalDate datumRodenjaStudenta = LocalDate.parse(datumRodenjaStudentaString, formatter);
				
		while (datumRodenjaStudenta.isBefore(todayParsed)) {
			System.out.println("Prestar si ti za studiranje! Pokušaj opet.");
			System.out.println(msg);		
			datumRodenjaStudentaString = scanner.nextLine();
			datumRodenjaStudenta = LocalDate.parse(datumRodenjaStudentaString, formatter);
		}
		
		return datumRodenjaStudenta;
	}
	
	public LocalDateTime dateTimeChecker(Scanner scanner, String msg) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME);		
		LocalDateTime today = LocalDateTime.now(ZoneId.systemDefault());
		
		String todayformated = today.format(DateTimeFormatter.ofPattern(FORMAT_DATE_TIME));		
		LocalDateTime todayParsed = LocalDateTime.parse(todayformated, formatter);
		
		System.out.println(msg);
		String datumIVrijemeIspitaString = scanner.nextLine();
		LocalDateTime datumIVrijemeIspita = LocalDateTime.parse(datumIVrijemeIspitaString, formatter);
		
		while (datumIVrijemeIspita.isAfter(todayParsed)) {
			System.out.println("Pa kak' možeš unijet datum poslije današnjeg za polaganje ispita? Daj se skoncentriraj.");
			System.out.println(msg);		
			datumIVrijemeIspitaString = scanner.nextLine();			 
			datumIVrijemeIspita = LocalDateTime.parse(datumIVrijemeIspitaString, formatter);
			
		}
		return datumIVrijemeIspita;
	}
	
	
	
	
	
	public Student[] addStudent(Student student, Student[] studentArray) {
		
		
	//	ArrayUtils.add(array, element)
		
		for (int i = 0; i < studentArray.length; i++) {
			studentArray[i] = student; 
			
		}
		return studentArray;
	}
	
	public Student[] resetStudentArray(Student[] student) {
		
		 student = ArrayUtils.removeElement(student, 0);
		 
		 return student;
		
	}
	
	public  Ispit[] filtrirajIspitePoStudentu(Ispit[] ispit, Student student) {


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
	

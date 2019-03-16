package hr.java.vjezbe.entitet;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;


public class Metode {
	
	public static final int BROJ_PROFESORA = 2;
	public static final int BROJ_PREDMETA = 3;
	public static final int BROJ_ISPITA = 1;
	public static final String FORMAT_DATE_TIME = "dd.MM.yyyy.'T'HH:mm";
	public static final String FORMAT_DATE = "dd.MM.yyyy.";
	
	public Profesor[] fillProfesor(Scanner scanner) {
		
		Profesor[] profesor = new Profesor[BROJ_PROFESORA];
		String sifraProfesor = "";	
		String imeProfesor = "";
		String prezimeProfesor = "";
		String titulaProfesora = "";
		int j = 1;
		
		for(int i = 0; i < profesor.length; i++) {
		System.out.println("Unesite " + j + "." + " profesora: ");
        
		String msgProfesorSifra = "Unesite šifru profesora:  ";
    	sifraProfesor = emptyCheckerString(scanner, msgProfesorSifra);
		

    	
//    	while (Arrays.asList(profesor).contains(sifraProfesor)) {
//    		msgProfesorSifra = "Unesite šifru profesora:  ";
//        	sifraProfesor = emptyCheckerString(scanner, msgProfesorSifra);
//		}
    	if (i != 0) {
    		while (profesor[i - 1].getSifra().equals(sifraProfesor)) {
				System.out.println("Promijenite šifru profesora.");
				msgProfesorSifra = "Unesite šifru predmeta: ";
				sifraProfesor = emptyCheckerString(scanner, msgProfesorSifra);
			}
    	}

		String msgProfesorName = "Unesite ime profesora: ";
		imeProfesor = emptyCheckerString(scanner, msgProfesorName);
				
		String msgProfesorSurname = "Unesite prezime profesora: ";
		prezimeProfesor = emptyCheckerString(scanner, msgProfesorSurname);
		
		String msgProfesorTitula = "Unesite titulu profesora: ";
		titulaProfesora = emptyCheckerString(scanner, msgProfesorTitula);
		
		j++; 
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
		int j = 1;
		
		
		for(int i = 0; i < predmet.length; i++) {
			    
			    int h = 1;
			    System.out.println("Unesite " + j++ + "." + " Predmet: ");
				
			    
			    String msgPredmetSifra = "Unesite šifru predmeta: ";
				sifraPredmet = emptyCheckerString(scanner, msgPredmetSifra);
				
				String msgPredmetName = "Unesite naziv predmeta: ";
				nazivPredmet = emptyCheckerString(scanner, msgPredmetName);
				
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
		int j = 1;
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
			System.out.println("Unesite " + j + "." + " studenta:");
			
			String msgStudentName = "Unesite ime studenta: ";
			imeStudent = emptyCheckerString(scanner, msgStudentName);
			
			String msgStudentSurname = "Unesite prezime studenta: ";
			prezimeStudent = emptyCheckerString(scanner, msgStudentSurname);
			
			String msgDateStudent = "Unesite datum roðenja za studenta " + prezimeStudent + " " + imeStudent + " u formatu (dd.MM.yyyy.)";
			datumRodenjaStudenta = dateChecker(scanner, msgDateStudent);
												
			String msgStudentJMBAG = "Unesite JMBAG studenta: ";
			jmbagStudent = emptyCheckerString(scanner, msgStudentJMBAG);
						
			j++;
		    student[i] = new Student(StringUtils.capitalize(imeStudent), StringUtils.capitalize(prezimeStudent), jmbagStudent, datumRodenjaStudenta);
		    
		    predmet[i].setStudent(student);
			}
		
		return student;
	}

	
	public Ispit[] fillIspit(Scanner scanner, Predmet[] predmet, Student[] student) {
		
		Predmet predmetIspita;
		Student studentIspita;
		Ispit[] ispit = new Ispit[BROJ_ISPITA];
		Integer ocjenaIspita = 0;
		int s = 1;
		int p = 1;
				
		for (int i = 0; i < ispit.length; i++) {
					
		System.out.println("Unesite ispitni rok: ");
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
		System.out.println("Vaš odabir predmeta je " + odabirPredmeta + "." + predmet[odabirPredmeta - 1].getNaziv());
				
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
		System.out.println("Vaš odabir studenta je " + odabirStudenta + "." + student[odabirStudenta - 1].getIme() + " " + student[odabirStudenta - 1].getPrezime());
		
								
		String msgIspitOcj = "Unesite ocjenu na ispitu (1-5): ";
		ocjenaIspita = emptyCheckerInteger(scanner, msgIspitOcj);
		
		while (ocjenaIspita > 5 || ocjenaIspita == 0) {
			System.out.println("Krivo unešena ocjena!");
			ocjenaIspita = emptyCheckerInteger(scanner, msgIspitOcj);
		}
		
		
		String msgDatumIVrijemeIspit = "Unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.THH:mm):";
		LocalDateTime datumIVrijemeIspita = dateTimeChecker(scanner, msgDatumIVrijemeIspit);
		
//		System.out.println("Unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.THH:mm):");		
//		String datumIVrijemeIspitString = scanner.nextLine();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME); 
//		LocalDateTime datumIVrijemeIspita = LocalDateTime.parse(datumIVrijemeIspitString, formatter);
			
		
		ispit[i] = new Ispit(predmetIspita, studentIspita, ocjenaIspita, datumIVrijemeIspita);
		
		}
		return ispit;		
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
		
		String date = "01.01.1930.";
		LocalDate todayParsed = LocalDate.parse(date, formatter);  
		
		System.out.println(msg);			
		String datumRodenjaStudentaString = scanner.nextLine();
		LocalDate datumRodenjaStudenta = LocalDate.parse(datumRodenjaStudentaString, formatter);
				
		while (datumRodenjaStudenta.isBefore(todayParsed)) {
			System.out.println("Krivo unesen datum");
			System.out.println(msg);		
			datumRodenjaStudentaString = scanner.nextLine();
			datumRodenjaStudenta = LocalDate.parse(datumRodenjaStudentaString, formatter);
		}
		
		return datumRodenjaStudenta;
	}
	
	public LocalDateTime dateTimeChecker(Scanner scanner, String msg) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME);		
		LocalDateTime today = LocalDateTime.now(ZoneId.systemDefault());
		String formatedToday = today.format(formatter);
		LocalDateTime todayParsed = LocalDateTime.parse(formatedToday, formatter);
		
		System.out.println(msg);
		String datumIVrijemeIspitaString = scanner.nextLine();
		LocalDateTime datumIVrijemeIspita = LocalDateTime.parse(datumIVrijemeIspitaString, formatter);
		
		while (datumIVrijemeIspita.isBefore(todayParsed)) {
			System.out.println("Netocno unesen datum.");
			System.out.println("Unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.THH:mm):");		
			datumIVrijemeIspitaString = scanner.nextLine();
			formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME); 
			datumIVrijemeIspita = LocalDateTime.parse(datumIVrijemeIspitaString, formatter);
			
		}
		return datumIVrijemeIspita;
	}
	
}
	

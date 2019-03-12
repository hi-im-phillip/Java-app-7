package hr.java.vjezbe.entitet;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Metode {
	
	public static final int BROJ_PROFESORA = 2;
	public static final int BROJ_PREDMETA = 3;
	public static final int BROJ_ISPITA = 1;
	
	public Profesor[] profesor(Scanner scanner) {
		
		Profesor[] profesor = new Profesor[BROJ_PROFESORA];
		int j = 1;
		
		for(int i = 0; i < profesor.length; i++) {
		
		System.out.println("Unesite " + j + "." + " profesora: ");
		System.out.println("Unesite šifru profesora: ");
		String sifraProfesor = scanner.nextLine();
		System.out.println("Unesite ime profesora: ");
		String imeProfesor = scanner.nextLine();
		System.out.println("Unesite prezime profesora: ");
		String prezimeProfesor = scanner.nextLine();
		System.out.println("Unesite titulu profesora: ");
		String titulaProfesora = scanner.nextLine();
		
		j++; 
		profesor[i] = new Profesor(sifraProfesor, imeProfesor, prezimeProfesor, titulaProfesora);		
		
		
		}
		
		return profesor;
		
	}
		
	public Predmet[] predmet(Scanner scanner, Profesor[] profesorObjekt) {
			
		Predmet[] predmet = new Predmet[BROJ_PREDMETA];	
		Profesor profesorOdabir;
		int j = 1;
		
		for(int i = 0; i < predmet.length; i++) {
		
				System.out.println("Unesite " + j + "." + " Predmet: ");
				System.out.println("Unesite šifru predmeta: ");
				String sifraPredmet = scanner.nextLine();
				System.out.println("Unesite naziv predmeta: ");
				String nazivPredmet = scanner.nextLine();
				System.out.println("Unesite broj ECTS bodova za predmet " + nazivPredmet + ":");
				Integer brojEctsBodovaPredmet = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Odaberite profesora: ");
				System.out.println("1. " + profesorObjekt[0].getIme() + " " + profesorObjekt[0].getPrezime() + "\n" + 
				"2. " + profesorObjekt[1].getIme() + " " + profesorObjekt[1].getPrezime());
				Integer odabirProfesor = scanner.nextInt();
				scanner.nextLine();
				if(odabirProfesor > 0 && odabirProfesor <= 2) {
					profesorOdabir = profesorObjekt[odabirProfesor - 1];
					System.out.println("Vaš odabir profesora je " + odabirProfesor + "." + profesorObjekt[odabirProfesor - 1].getIme() 
							             + " " + profesorObjekt[odabirProfesor - 1].getPrezime());
				} else {
					profesorOdabir = profesorObjekt[0];
					System.out.println("Krivo unešen odabir, mora biti jedan od ponuðenih profesora. \n Postavljena je standardna vrijednost.");
				}
				System.out.println("Unesite broj studenta za predmet " + nazivPredmet + ":");
				Integer studentPredmetInt = scanner.nextInt();
				scanner.nextLine();
				Student[] studentPredmet = new Student[studentPredmetInt];
				
				predmet[i] = new Predmet(sifraPredmet, nazivPredmet, brojEctsBodovaPredmet, profesorOdabir, studentPredmet);
				j++;			
				  
			}			
	
		return predmet;
	}
		
	public Student[] student(Scanner scanner, Predmet[] predmet) {
		
		int sum = 0;
		int u = 0;
		int j = 1;
		
		for (Predmet predmetObjekt : predmet) {
			int lengthStudentObjArray = predmet[u].getStudent().length;
			  sum = lengthStudentObjArray + sum;
			  u++;
		}
				
		Student[] student = new Student[sum];
				
		for(int i = 0; i < student.length; i++) {
			System.out.println("Unesite " + j + "." + " studenta:");
			System.out.println("Unesite ime studenta: ");
			String imeStudent = scanner.nextLine();
			System.out.println("Unesite prezime studenta: ");
			String prezimeStudent = scanner.nextLine();
			System.out.println("Unesite datum roðenja za studenta " + prezimeStudent + " " + imeStudent + " u formatu (dd.MM.yyyy.)");
			String datumRodenjaStudentaString = scanner.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			LocalDate datumRodenjaStudenta = LocalDate.parse(datumRodenjaStudentaString, formatter);
			System.out.println("Unesite JMBAG studenta: ");
			String jmbagStudent = scanner.nextLine();
			
			j++;
		    student[i] = new Student(imeStudent, prezimeStudent, jmbagStudent, datumRodenjaStudenta);
			}
		
		return student;
	}

	public Ispit[] ispit(Scanner scanner, Predmet[] predmet, Student[] student) {
		
		Predmet predmetIspita = null;
		Student studentIspita = null;
		Ispit[] ispit = new Ispit[BROJ_ISPITA];
		
		
		
		for (int i = 0; i < ispit.length; i++) {
					
		System.out.println("Unesite ispitni rok: ");
		System.out.println("Odaberite predmet: ");
		System.out.println(1 + "." + predmet[0].getNaziv() + "\n" + 
				           2 + "." + predmet[1].getNaziv() + "\n" + 
				           3 + "." + predmet[2].getNaziv());
		Integer odabirPredmet = scanner.nextInt();
		scanner.nextLine();
		
		switch (odabirPredmet) {
		case 1:
			predmetIspita = predmet[odabirPredmet - 1];
			System.out.println("Vaš odabir predmeta je " + odabirPredmet + "." + predmet[odabirPredmet - 1].getNaziv());
			break;
		case 2:
			predmetIspita = predmet[odabirPredmet - 1];
			System.out.println("Vaš odabir predmeta je " + odabirPredmet + "." + predmet[odabirPredmet - 1].getNaziv());
           break;
		case 3:
			predmetIspita = predmet[odabirPredmet - 1];
			System.out.println("Vaš odabir predmeta je " + odabirPredmet + "." + predmet[odabirPredmet - 1].getNaziv());
		  break;
		default:
			predmetIspita = predmet[0];
			System.out.println("Morate odabrati jedan od ponuðenih predmeta. Dodijeljena je standardna vrijednost predmeta.");
			break;
		}
		
		System.out.println("Odaberite studenta: ");
		System.out.println("1." + student[0].getIme() + " " + student[0].getPrezime() + "\n" +
				           "2." + student[1].getIme() + " " + student[1].getPrezime());
		Integer odabirStudent = scanner.nextInt();
		scanner.nextLine();
		
		switch (odabirStudent) {
		case 1:
			studentIspita = student[odabirStudent - 1];
			System.out.println("Vaš odabir studenta " + odabirStudent + "." + student[odabirStudent - 1].getIme() + " " + student[odabirStudent - 1].getPrezime());
			break;
		case 2:
			studentIspita = student[odabirStudent - 1];
			System.out.println("Vaš odabir studenta " + odabirStudent + "." + student[odabirStudent - 1].getIme() + " " + student[odabirStudent - 1].getPrezime());
		    break;
		default:
			studentIspita = student[0];
			System.out.println("Morate odabrati nešto od ponuðenog. Dodijeljena je standardna vrijednost.");
			break;
		}
		
		System.out.println("Unesite ocjenu na ispitu (1-5): ");
		Integer ocjenaIspita = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.THH:mm):");		
		String datumIVrijemeIspitString = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.'T'HH:mm"); 
		LocalDateTime datumIVrijemeIspita = LocalDateTime.parse(datumIVrijemeIspitString, formatter);
				
		ispit[i] = new Ispit(predmetIspita, studentIspita, ocjenaIspita, datumIVrijemeIspita);
		
		ocjenaStudenta(ocjenaIspita, studentIspita, predmetIspita);
		
		}
		
		
		return ispit;		
		
	}
	
	public void ocjenaStudenta(Integer ocijena, Student studentIspit, Predmet predmetIspit) {
		
		String ocjenaIspitString;
		
		switch (ocijena) {
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
		
		if (ocijena == 5) {
			System.out.println("Student " + studentIspit.getIme() + " " + studentIspit.getPrezime() + 
	                " je ostvario ocjenu " + ocjenaIspitString + " na predmetu " + predmetIspit.getNaziv());
		}else {
			System.out.println("Nemaš pojma.");
		}
		
	}
}

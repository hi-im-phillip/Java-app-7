package hr.java.vjezbe.glavna;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import hr.java.vjezbe.entitet.Ispit;
import hr.java.vjezbe.entitet.Predmet;
import hr.java.vjezbe.entitet.Profesor;
import hr.java.vjezbe.entitet.Student;



public class Glavna {

	public static final Integer BROJ_PROFESORA = 3;
	
	public static void main(String[] args) {
		
		Profesor[] profesor1 = new Profesor[1];
		
		Predmet[] predmet = new Predmet[1];
		
		Student[] student = new Student[1];
		
		Ispit[] ispit = new Ispit[1];
		
		
		Scanner skener = new Scanner(System.in);
		
		for(int i = 0; i < profesor1.length; i++) {
			
			System.out.println("Unesite " + i + "." + " profesora ");
			System.out.println("Unesite sifru profesora:");
			String sifraProfesor = skener.nextLine();
			System.out.println("Unesite ime profesora:");
			String imeProfesor = skener.nextLine();
			System.out.println("Unesite prezime profesora");
			String prezimeProfesor = skener.nextLine();
			System.out.println("Unesite titulu profesora");
			String titulaProfesora = skener.nextLine();
		
			
			profesor1[i] = new Profesor(sifraProfesor, imeProfesor, prezimeProfesor, titulaProfesora);
			
						
		}
		

		for(int i = 0; i < predmet.length; i++) {
			for(int j = 0; j < profesor1.length; j++) {
		System.out.println("Unesite Predmet");
		System.out.println("Unesite sifru predmeta \n");
		String sifraPredmet = skener.nextLine();
		System.out.println("Unesite Naziv predmeta");
		String nazivPredmet = skener.nextLine();
		System.out.println("Unesite broj ECTS za predmet " + nazivPredmet);
		Integer brojEctsBodovaPredmet = skener.nextInt();
		skener.nextLine();
		System.out.println("Odaberite profesora:");
		System.out.println(profesor1[0].getIme() + profesor1[0].getPrezime() + 
				"\n" + profesor1[1].getIme() + profesor1[1].getPrezime());
		Integer odabir = skener.nextInt();
		skener.nextLine();
		if(odabir == 1) {
			System.out.println();
		}else if (odabir == 2) {
			System.out.println();
		} else {
			System.out.println("Krivo unesen");
		}
		
		
//		  predmet[i] = new Predmet(sifraPredmet, nazivPredmet, brojEctsBodovaPredmet, profesor1[j]);
		
		} 
			
			
	}
		for(int i = 1; i < student.length; i++) {
		System.out.println("Unesite ime studenta ");
		String imeStudent = skener.nextLine();
		System.out.println("Unesite prezime studenta");
		String prezimeStudent = skener.nextLine();
		System.out.println("Unesite datum rodenja za" + imeStudent);
		String datumRodenjaStudentaString = skener.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate datumRodenjaStudenta = LocalDate.parse(datumRodenjaStudentaString, formatter);
		System.out.println("Unesite JMBAG ");
		String jmbagStudent = skener.nextLine();
		
	
		 student[i] = new Student(imeStudent, prezimeStudent, jmbagStudent, datumRodenjaStudenta);
		}
		for(int i = 1; i < ispit.length; i++) {
		System.out.println("Unesite ispitni rok");
		System.out.println("Odaberite predmet: ");
		System.out.println(predmet[0].getNaziv() + "\n" + predmet[1].getNaziv());
		Integer odabir = skener.nextInt();
		skener.nextLine();
		String predmetIspit;
		if (odabir == 1) {
			predmetIspit = predmet[0].getNaziv();
		} else if (odabir == 2) {
			predmetIspit = predmet[1].getNaziv();
		} else if (odabir == 3){
			predmetIspit = predmet[2].getNaziv();
		}
		System.out.println(">> Odabir" + odabir);
		
		System.out.println("Odaberite studenta: ");
		System.out.println(student[0].getIme() + student[0].getPrezime() + "\n" +
		                   student[1].getIme() + student[1].getPrezime() + "\n" +
				           student[2].getIme() + student[2].getPrezime());
		Integer odabir1 = skener.nextInt();
		skener.nextLine();
		Student studentIspit;
//		if(odabir1 == 1) {
//			studentIspit = student[0].getIme() + student[0].getPrezime();
//		} else if (odabir1 == 2) {
//			studentIspit = student[1].getIme() + student[1].getPrezime();
//		} else if (odabir1 == 3) {
//			studentIspit = student[2].getIme() + student[2].getPrezime();
//		}
		
//		System.out.println("odabir >> " + odabir1);
		
		System.out.println("Unesite ocjenu na ispitu");
		Integer ocjenaIspit = skener.nextInt();
		skener.nextLine();
		System.out.println("unesite datum i vrijeme ispita u formatu (dd.MM.yyyy.THH:mm):");
		String datumIVrijemeIspitString = skener.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDateTime datumIVrijemeIspit = LocalDateTime.parse(datumIVrijemeIspitString, formatter);
		
		
		ispit[i] = new Ispit(predmet[i], student[i], ocjenaIspit, datumIVrijemeIspit);
		}
		
		skener.close();
	}

}

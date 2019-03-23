package hr.java.vjezbe.glavna;

import java.util.Scanner;

import hr.java.vjezbe.entitet.Ispit;
import hr.java.vjezbe.entitet.Metode;
import hr.java.vjezbe.entitet.ObrazovnaUstanova;
import hr.java.vjezbe.entitet.Predmet;
import hr.java.vjezbe.entitet.Profesor;
import hr.java.vjezbe.entitet.Student;
import hr.java.vjezbe.entitet.VeleucilisteJave;

public class Glavna2 {
	
	public static int BROJ_USTANOVA = 0;
	
	
	public static void main(String[] args) {
				
		Scanner scanner = new Scanner(System.in);
		
		Metode metode = new Metode();
		
		
		System.out.println("Unesite broj obrazovnih ustanova");
		BROJ_USTANOVA = scanner.nextInt();
		scanner.nextLine();
				
		Profesor[] profesor = metode.fillProfesor(scanner);
		
		Predmet[] predmet = metode.fillPredmet(scanner, profesor);
		
		Student[] student = metode.fillStudent(scanner, predmet);
		
		Ispit[] ispit = metode.fillIspit(scanner, predmet, student);
		
		metode.checkerOcjenaStudenta(ispit);
		
		ObrazovnaUstanova[] obrazovnaUstanovas = metode.fillObrazovnaUstanova(scanner, predmet, profesor, student, ispit);	
		
		
	
		scanner.close();
		
		
	   
				
				
	}

}

package hr.java.vjezbe.glavna;

import java.util.Scanner;

import hr.java.vjezbe.entitet.Ispit;
import hr.java.vjezbe.entitet.Metode;
import hr.java.vjezbe.entitet.Predmet;
import hr.java.vjezbe.entitet.Profesor;
import hr.java.vjezbe.entitet.Student;

public class Glavna2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Metode metode = new Metode();
				
		Profesor[] profesor = metode.profesor(scanner);
		
		Predmet[] predmet = metode.predmet(scanner, profesor);
		
		Student[] student = metode.student(scanner);
		
		Ispit ispit = metode.ispit(scanner, predmet, student);
		
		
				
				
	}

}

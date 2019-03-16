package hr.java.vjezbe.entitet;

import java.util.Scanner;

public class Profesor {
	
	private String sifra;
	private String ime;
	private String prezime;
	private String titula;
	
	public Profesor(String sifraProfesor, String imeProfesor, String prezimeProfesor, String titulaProfesora) {
		this.sifra = sifraProfesor;
		this.ime = imeProfesor;
		this.prezime = prezimeProfesor;
		this.titula = titulaProfesora;
		
	}
	
	Scanner skener = new Scanner(System.in);
	
	

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String toString() {
		return String.format("Sifra je %s, ime profesora je %s, prezime profesora je %s, titula je %s ", getSifra(), getIme(), getPrezime(), getTitula());
	}
	
	
		
	
	
}

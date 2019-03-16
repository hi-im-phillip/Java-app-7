package hr.java.vjezbe.entitet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
	
	private String ime;
	private String prezime;
	private String jmbag;
    private LocalDate datumRodenja;
    
    public Student(String imeStudent, String prezimeStudent, String jmbagStudent, LocalDate datumRodenjaStudenta) {
    	this.ime = imeStudent;
    	this.prezime = prezimeStudent;
    	this.jmbag = jmbagStudent;
    	this.datumRodenja = datumRodenjaStudenta;
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

	public String getJmbag() {
		return jmbag;
	}

	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}

	public LocalDate getDatumRodenja() {
		return datumRodenja;
	}

	public void setDatumRodenja(LocalDate datumRodenja) {
		this.datumRodenja = datumRodenja;
	}
    
    public String toString() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy."); 
		String datumRodenjaString = getDatumRodenja().format(formatter);
    	
    	return String.format("JMBAG studenta je %s, ime i prezime studenta je %s %s, i datum rodenja je %s%n", getJmbag(), getIme(), getPrezime(), datumRodenjaString);
    }
    
    
}

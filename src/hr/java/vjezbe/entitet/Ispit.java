package hr.java.vjezbe.entitet;

import java.time.LocalDateTime;

public class Ispit {
	
	private Predmet predmet;
	private Student student;
	private Integer ocjena;
	private LocalDateTime datumIVrijeme;
	
	public Ispit(Predmet predmetIspit, Student studentIspit, Integer ocjenaIspit, LocalDateTime datumIVrijemeIspit) {
		
		this.predmet = predmetIspit;
		this.student = studentIspit;
		this.ocjena = ocjenaIspit;
		this.datumIVrijeme = datumIVrijemeIspit;
		
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getOcjena() {
		return ocjena;
	}

	public void setOcjena(Integer ocjena) {
		this.ocjena = ocjena;
	}

	public LocalDateTime getDatumIVrijeme() {
		return datumIVrijeme;
	}

	public void setDatumIVrijeme(LocalDateTime datumIVrijeme) {
		this.datumIVrijeme = datumIVrijeme;
	}
	
	public String toString() {
		return String.format("Predmet je %s, ocjena je %i, datum i vrijeme ispita su %s", getPredmet(), getOcjena(), getDatumIVrijeme());
	}

}

package hr.java.vjezbe.entitet;

public class Predmet {
	
	private String sifra;
	private String naziv;
	private Integer brojEctsBodova;
	private Profesor nositelj;
	private Student[] student;
	
	public Predmet(String sifraPredmet, String nazivPredmet, Integer brojEctsBodovaPredmet, Profesor nositeljPredmet, Student[] studentPredmet) {
		this.sifra = sifraPredmet;
		this.naziv = nazivPredmet;
		this.brojEctsBodova = brojEctsBodovaPredmet;
		this.nositelj = nositeljPredmet;
		this.student = studentPredmet;
		
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getBrojEctsBodova() {
		return brojEctsBodova;
	}

	public void setBrojEctsBodova(Integer brojEctsBodova) {
		this.brojEctsBodova = brojEctsBodova;
	}

	public Profesor getNositelj() {
		return nositelj;
	}

	public void setNositelj(Profesor nositelj) {
		this.nositelj = nositelj;
	}

	public String toString() {
		return String.format("Sifra predmeta je %, naziv predmeta je %, broj ECTS bodova su %, profesor je %s", getSifra(), getNaziv(), getBrojEctsBodova(), getNositelj());
	}
	
}

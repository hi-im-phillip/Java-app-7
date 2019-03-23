package hr.java.vjezbe.entitet;

public abstract class ObrazovnaUstanova {
	
	private String naziv;
	private Predmet[] predmet;
	private Profesor[] profesor;
	private Student[] student;
	private Ispit[] ispit;
	
	public ObrazovnaUstanova(String nazivUstanove, Predmet[] predmetObrazovneUstanove, Profesor[] profesorObrazovneUstanove, 
			                 Student[] studentObrazovneUstanove, Ispit[] ispitObrazovneUstanove) {
		this.naziv = nazivUstanove;
		this.predmet = predmetObrazovneUstanove;
		this.profesor = profesorObrazovneUstanove;
		this.student = studentObrazovneUstanove;
		this.ispit = ispitObrazovneUstanove;
		
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Predmet[] getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet[] predmet) {
		this.predmet = predmet;
	}

	public Profesor[] getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor[] profesor) {
		this.profesor = profesor;
	}

	public Student[] getStudent() {
		return student;
	}

	public void setStudent(Student[] student) {
		this.student = student;
	}

	public Ispit[] getIspit() {
		return ispit;
	}

	public void setIspit(Ispit[] ispit) {
		this.ispit = ispit;
	}

	public abstract Student odrediNajuspjesnijegStudentaNaGodini(Integer godina);
	
}

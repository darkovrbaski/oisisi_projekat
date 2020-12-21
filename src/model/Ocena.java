package model;

public class Ocena {
	
	
	private Student trenutniStudent;
	private Predmet trenutniPredmet;
	private int ocena;
	private String datumPolaganjaIspita;
	
	
	public Ocena(Student trenutniStudent, Predmet trenutniPredmet, int ocena, String datumPolaganjaIspita) {
		super();
		this.trenutniStudent = trenutniStudent;
		this.trenutniPredmet = trenutniPredmet;
		this.ocena = ocena;
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}


	public Student getTrenutniStudent() {
		return trenutniStudent;
	}


	public void setTrenutniStudent(Student trenutniStudent) {
		this.trenutniStudent = trenutniStudent;
	}


	public Predmet getTrenutniPredmet() {
		return trenutniPredmet;
	}


	public void setTrenutniPredmet(Predmet trenutniPredmet) {
		this.trenutniPredmet = trenutniPredmet;
	}


	public int getOcena() {
		return ocena;
	}


	public void setOcena(int ocena) {
		
		if ( ocena < 5 && ocena > 10) {
			
			System.out.println("Unesite vrijednosti od 5 - 10 !!!");
				
		}else {
		
		this.ocena = ocena;
		
		}
		
	}


	public String getDatumPolaganjaIspita() {
		return datumPolaganjaIspita;
	}


	public void setDatumPolaganjaIspita(String datumPolaganjaIspita) {
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}
	 
	
	
	
	
	

}

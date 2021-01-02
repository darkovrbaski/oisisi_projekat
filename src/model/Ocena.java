package model;

import java.util.Date;

public class Ocena {
	
	
	private Student trenutniStudent;
	private Predmet trenutniPredmet;
	private int ocena;
	private Date datumPolaganjaIspita;
	
	
	public Ocena(Student trenutniStudent, Predmet trenutniPredmet, int ocena, Date datumPolaganjaIspita) {
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


	public Date getDatumPolaganjaIspita() {
		return datumPolaganjaIspita;
	}


	public void setDatumPolaganjaIspita(Date datumPolaganjaIspita) {
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}
	 
	
	
	
	
	

}

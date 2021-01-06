package model;

import java.util.ArrayList;

import model.Predmet.Semestar;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private ArrayList<Predmet> predmeti;
	private ArrayList<String> kolone;

	private BazaPredmeta() {
		initPredmete();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
	}

	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("123", "Aa", Semestar.Letnji, 1, null, 6, null, null));
		predmeti.add(new Predmet("124", "Ab", Semestar.Zimski, 2, null, 9, null, null));
		predmeti.add(new Predmet("125", "Aca", Semestar.Letnji, 3, null, 9, null, null));
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNaziv();
		case 2:
			return "" + predmet.getBrojESPB();
		case 3:
			return "" + predmet.getGodina();
		case 4:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}
	
	public void izbrisiPredmet(Predmet predmet) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				predmeti.remove(p);
				break;
			}
		}
	}

}

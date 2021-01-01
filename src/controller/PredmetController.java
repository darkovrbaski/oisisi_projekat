package controller;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudent;
import model.Predmet;
import view.TabbedPanel;
import view.dialogs.UpitPotvrdeDialog;

public class PredmetController {

	private static PredmetController instance;

	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}

	private PredmetController() {
	}

	public void izbrisiPredmet() {
		UpitPotvrdeDialog dialog = new UpitPotvrdeDialog("Brisanje predmeta",
				"Da li ste sigurni da želite da obrišete predmet?");
		if (dialog.isYes() == true) {
			Predmet predmet = BazaPredmeta.getInstance().getRow(TabbedPanel.tabelaPredmeta.getCurrentSelectedRow());
			BazaPredmeta.getInstance().izbrisiPredmet(predmet);
			TabbedPanel.tabelaPredmeta.azurirajPrikazPredmeta();
			BazaProfesora.getInstance().izbrisiPredmet(predmet);
			// TODO: azuriraj predmete u profesoru
			BazaStudent.getInstance().izbrisiPredmet(predmet);
			// TODO: azuriraj predmete u studentu
		}
	}
}

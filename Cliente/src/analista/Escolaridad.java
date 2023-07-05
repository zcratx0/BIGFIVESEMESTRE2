package analista;

import utils.GUIEscolaridad;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Escolaridad extends GUIEscolaridad {

	public Escolaridad() {
		super();
		getBtnAtras().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cerrando");
				ListaEscolaridad.main(null);				
				getFrame().dispose();
			}
		});
	}
}

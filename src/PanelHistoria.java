import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelHistoria extends JPanel {

	JTextArea txtHistoria;
	String reglas = "    El hnefatalf es un juego de mesa que pertenece a la familia de los juegos tafl, antiguos juegos\n"
			+ " de mesa germánicos que se practicaban sobre una tabla cuadriculada. La palabra tafl\n"
			+ "(pronunciada tapl) significa mesa o tablero en nórdico antiguo, pero actualmente es la palabra\n"
			+ "para ajedrez en islandés moderno.\n"
			+ "    Algunas versiones de este juego fueron populares en Europa del Norte por lo menos desde el\n"
			+ "400 d.C. hasta que fueron reemplazados por el ajedrez durante el Renacimiento. A diferencia del\n"
			+ "ajedrez donde la disposición de las piezas se emplazan inicialmente de forma lineal en flancos\n"
			+ "opuestos, las figuras del tafl parten del centro del tablero.\n"
			+"\nVersiones:\n"
			+ "El Hnefatalf. Es la más conocida de todas las versiones,Los vikingos consideraban que saber\n"
			+ "jugar bien al Hnefatafl o Tablero del Rey era signo de nobleza.\n"
			+ "El Alea evangelii. Es una versión que se jugó en la Inglaterra sajona.\n"
			+ "El Tablut, la variante finlandesa.\n"
			+ "El Tawlbyund (o Tawl Bwrdd, Tablero de tiro), la variante galesa, pertenece al menos al siglo X.";

	public PanelHistoria() {
		this.setLayout(new BorderLayout());
		this.setSize(600,300);
		txtHistoria = new JTextArea();
		txtHistoria.setEditable(false);
		txtHistoria.setFont(new java.awt.Font("Tahoma", 0, 14)); 
		txtHistoria.setEnabled(true);
		txtHistoria.setText(reglas);	
		this.add(txtHistoria,BorderLayout.CENTER);
	}


}

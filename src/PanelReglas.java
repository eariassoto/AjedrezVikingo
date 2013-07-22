import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelReglas extends JPanel {

	JTextArea txtReglas;
	String reglas = "           Fichas blancas: suecos.          Fichas negras: moscovitas\n\n"
			+ "El Rey va en el cuadro central (el Trono), rodeado por sus hombres\n"
			+ "(otras fichas blancas). Las fichas enemigas (negras) se disponen en\n"
			+ "torno de los bordes del tablero. Las oscuras mueven primero.\n"
			+ "1. Todas las fichas se mueven ortogonalmente cualquier cantidad de\n"
			+ "cuadros libres (el movimiento de la torre en el ajedrez).\n"
			+ "2. Una ficha es capturada y sacada del tablero cuando el oponente\n"
			+ "ocupa ambos cuadros adyacentes en una fila o columna. Sin embargo\n"
			+ "una ficha puede moverse de forma segura sobre un cuadro vacío entre\n"
			+ "dos fichas enemigas.\n"
			+ "3. El rey es capturado si todos los cuatro cuadros alrededor de él son\n"
			+ "ocupados por fichas enemigas. Cuando el rey es capturado, se termina\n"
			+ "el juego y los moscovitas ganan.\n"
			+ "4. Los suecos ganan si el rey llega a cualquier cuadro en los bordes\n"
			+ "externos del tablero.";

	public PanelReglas() {
		this.setLayout(new BorderLayout());
		this.setSize(450,300);
		txtReglas = new JTextArea();
		txtReglas.setEditable(false);
		txtReglas.setFont(new java.awt.Font("Tahoma", 0, 14)); 
		txtReglas.setEnabled(true);
		txtReglas.setText(reglas);	
		this.add(txtReglas,BorderLayout.CENTER);
	}


}

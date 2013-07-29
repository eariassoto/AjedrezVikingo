import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;


@SuppressWarnings("serial")
public class VentanaReglas extends JFrame {

	private JPanel contentPane;

	public VentanaReglas() {
		setTitle("Reglas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 795, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Página 1", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reglas del Juego");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 191, 25);
		panel.add(lblNewLabel);
		
		JTextArea txtrlosJugadoresSe = new JTextArea();
		txtrlosJugadoresSe.setEditable(false);
		txtrlosJugadoresSe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrlosJugadoresSe.setText("Los jugadores se mueven por turnos. Todas las piezas se mueven de la misma manera, como torres de ajedrez. \r\nEs decir, en su turno, un jugador puede deslizar una sola pieza de su color de cualquier n\u00FAmero de casillas en cualquier \r\ndirecci\u00F3n ortogonal (arriba-abajo o izquierda-derecha, no se mueve en diagonal), siempre y cuando no salte por encima\r\nde otra pieza de cualquier color. El trono y de los cuatro cuadrados de las esquinas est\u00E1n fuera del alcance de todas las\r\npiezas, excepto el Rey. Con las variantes de mesa m\u00E1s peque\u00F1as, piezas de cualquier color pueden pasar sobre el Trono.\r\nEl jugador blanco estar\u00E1 tratando de que su rey escape llegando a una de las esquinas. Si el jugador blanco se mueve \r\npara que su rey tenga un camino claro a cualquiera de las cuatro esquinas, debe anunciar que tiene una v\u00EDa de escape\r\nabierta. Los lapones utilizan la palabra Raichi (\"Jaque\") para anunciar una sola ruta y Tuichi (\"Jaque Mate\") para anunciar\r\nuna ruta doble. En su siguiente turno, si es que a\u00FAn puede hacerlo, el rey se puede mover a una casilla de la esquina y\r\nescapar. El jugador blanco gana entonces. Si el jugador Negro abre accidentalmente una v\u00EDa de escape para el rey, el\r\njugador blanco debe aprovecharla de inmediato. Si la pieza movida termina intercalando una pieza opuesta entre s\u00ED mismo\r\ny otra pieza del color en movimiento o una casilla de la esquina, la pieza intercalada se retira del tablero. Esto se conoce\r\ncomo captura de custodia. Es posible capturar varias piezas en un solo movimiento.\r\n\r\nEn este caso, la ficha blanca come a las dos negras:");
		txtrlosJugadoresSe.setBounds(10, 47, 744, 267);
		panel.add(txtrlosJugadoresSe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaReglas.class.getResource("/imagenes/imgReglas1.gif")));
		lblNewLabel_1.setBounds(337, 325, 97, 67);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Página 2", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextArea txtrElReyDebe = new JTextArea();
		txtrElReyDebe.setEditable(false);
		txtrElReyDebe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrElReyDebe.setText("El rey debe ser encasillado en ambos ejes. El trono, esquinas y bordes cuentan como piezas negras con fines de encasillar \r\nal rey, por lo que el jugador Negro necesita solo tres piezas para capturar al rey en el borde de la mesa o si el Rey est\u00E1 a \r\nun lado de su trono, dos si el Rey est\u00E1 justo al lado de una esquina. Cuando el rey est\u00E1 en peligro de ser capturado en el\r\nsiguiente movimiento del jugador Negro, se debe anunciar \"Mira a tu rey\" para el jugador blanco. El jugador Negro gana \r\nal capturar al Rey. El Rey tambi\u00E9n se puede capturar si \u00E9l y no m\u00E1s de un defensor est\u00E1n rodeado por todos lados e\r\nincapaces de moverse.\r\n\r\nEn todos los casos el jugador negro captura al Rey y gana: ");
		txtrElReyDebe.setBounds(10, 11, 744, 152);
		panel_1.add(txtrElReyDebe);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaReglas.class.getResource("/imagenes/imgReglas2.PNG")));
		label.setBounds(206, 174, 361, 71);
		panel_1.add(label);
		
		JTextArea txtrUnaPiezaPuede = new JTextArea();
		txtrUnaPiezaPuede.setEditable(false);
		txtrUnaPiezaPuede.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrUnaPiezaPuede.setText("Una pieza puede moverse con seguridad entre dos piezas del otro color que est\u00E1n opuestas (o una casilla de la esquina):");
		txtrUnaPiezaPuede.setBounds(10, 252, 744, 22);
		panel_1.add(txtrUnaPiezaPuede);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaReglas.class.getResource("/imagenes/imgReglas3.gif")));
		lblNewLabel_2.setBounds(353, 285, 97, 65);
		panel_1.add(lblNewLabel_2);
		
		JTextArea txtrElGanadorEs = new JTextArea();
		txtrElGanadorEs.setEditable(false);
		txtrElGanadorEs.setText("El ganador es el jugador blanco si llega una casilla de la esquina con su rey, el jugador negro si logra capturar el rey. ");
		txtrElGanadorEs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrElGanadorEs.setBounds(10, 370, 744, 22);
		panel_1.add(txtrElGanadorEs);
		
		
	}
	 static {
	      try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        UIManager.put("AuditoryCues.playList",UIManager.get("AuditoryCues.allAuditoryCues"));
	      }
	      catch (Exception e) {}
	    }
}

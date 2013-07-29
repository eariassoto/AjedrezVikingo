import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class VentanaHistoria extends JFrame {

	private JPanel contentPane;

	
	public VentanaHistoria() {
		setTitle("Historia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 795, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrElHnefatalfEs = new JTextArea();
		txtrElHnefatalfEs.setEditable(false);
		txtrElHnefatalfEs.setBounds(10, 47, 764, 358);
		txtrElHnefatalfEs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrElHnefatalfEs.setText("Antes de la introducci\u00F3n del ajedrez en los siglos XI y XII, los escandinavos agudizaban su ingenio jugando un juego conocido\r\ncomo Tafl. Tafl en n\u00F3rdico antiguo significa \"mesa\" y al final del per\u00EDodo de referencia a una variedad de juegos de mesa,\r\ncomo el ajedrez (Skak-Tafl o \"check-table\"), Tabula (el ancestro medieval de Backgammon, presentado por los franceses\r\ncomo Quatre y as\u00ED Kvatru-Tafl), Fox and Geese (Ref-Skak, \"zorro de ajedrez\", Hala-Tafl o Frey-Tafl), Morris Tres Hombres \r\n(Hr\u00E6_-Tafl \"Quick-Tafl\") y Nueve hombres de Morris. Sin embargo, el t\u00E9rmino Tafl fue m\u00E1s com\u00FAnmente usado para \r\nreferirse a un juego conocido como Hnefa-Tafl o \"Mesa del Rey\". Hnefatafl era conocido en Escandinavia antes del a\u00F1o \r\n400 dC y fue llevado por los vikingos a Groenlandia, Islandia, Irlanda, Gran Breta\u00F1a, Pa\u00EDs de Gales y al este hasta Ucrania. Los\r\nsajones ten\u00EDan su propia variante, derivado de un juego Tafl germ\u00E1nica com\u00FAn, que aparentemente era el \u00FAnico juego de \r\nmesa conocido a ellos antes de la introducci\u00F3n de Ajedrez. \r\nA diferencia del ajedrez donde la disposici\u00F3n de las piezas se emplazan inicialmente de forma lineal en flancos opuestos, las\r\nfiguras del tafl parten del centro del tablero.\r\n\r\nVersiones:\r\nEl Hnefatalf. Es la m\u00E1s conocida de todas las versiones,Los vikingos consideraban que saber\r\njugar bien al Hnefatafl o Tablero del Rey era signo de nobleza.\r\nEl Tawlbyund (o Tawl Bwrdd, Tablero de tiro), la variante galesa, pertenece al menos al siglo X.\r\nEl Alea evangelii. Es una versi\u00F3n que se jug\u00F3 en la Inglaterra sajona.\r\nEl Tablut, la variante finlandesa.\r\nEl Ard-Ri, la variante escocesa.");
		contentPane.add(txtrElHnefatalfEs);
		
		JLabel lblHistoriaDelJuego = new JLabel("Historia del Juego");
		lblHistoriaDelJuego.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHistoriaDelJuego.setBounds(10, 11, 191, 25);
		contentPane.add(lblHistoriaDelJuego);
	}
}

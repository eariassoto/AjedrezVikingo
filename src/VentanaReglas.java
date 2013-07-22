import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaReglas extends JFrame {

	PanelReglas panel;
   
    public VentanaReglas(PanelReglas panelReglas) {
    	super("Reglas del Juego");
        this.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        this.setSize(450,300);
        this.setResizable(false);
        this.panel = panelReglas;
        this.add(panelReglas, BorderLayout.CENTER);
     
    }
}

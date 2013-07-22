import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class VentanaHistoria extends JFrame {

	PanelHistoria panelHistoria;
   
    public VentanaHistoria(PanelHistoria panelHistoria) {
    	super("Historia del Juego");
        this.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        this.setSize(600,300);
        this.setResizable(false);
        this.panelHistoria = panelHistoria;
        this.add(panelHistoria, BorderLayout.CENTER);

    }
}

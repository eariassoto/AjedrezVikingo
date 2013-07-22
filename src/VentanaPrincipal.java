
import javax.swing.JFrame;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	
    public VentanaPrincipal(PanelPrincipal panelPrincipal) {
    	super("Ajedrez");
        this.setSize(795,480);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelPrincipal);
    }

    static {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        UIManager.put("AuditoryCues.playList",UIManager.get("AuditoryCues.allAuditoryCues"));
      }
      catch (Exception e) {}
    }
}

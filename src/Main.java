public class Main {

	public static void main(String[] args) {
		Manejador manejador = new Manejador();
		PanelReglas panelReglas = new PanelReglas();
		VentanaReglas ventanaReglas = new VentanaReglas(panelReglas);
		PanelHistoria panelHistoria = new PanelHistoria();
		VentanaHistoria ventanaHistoria = new VentanaHistoria(panelHistoria);
		PanelPrincipal panelPrincipal = new PanelPrincipal(ventanaReglas,ventanaHistoria,manejador);
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(panelPrincipal);
		ventanaPrincipal.setVisible(true);
	}
}

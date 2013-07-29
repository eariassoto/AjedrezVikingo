public class Main {

	public static void main(String[] args) {
		ManejadorTablero manejadorTablero = new ManejadorTablero();
		ManejadorRey manejadorRey = new ManejadorRey(manejadorTablero);
		ManejadorFichas manejadorFichas = new ManejadorFichas(manejadorTablero);
		VentanaReglas ventanaReglas = new VentanaReglas();
		VentanaHistoria ventanaHistoria = new VentanaHistoria();
		PanelPrincipal panelPrincipal = new PanelPrincipal(ventanaReglas,ventanaHistoria,manejadorTablero,manejadorRey,manejadorFichas);
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(panelPrincipal);
		ventanaPrincipal.setVisible(true);
	}
}

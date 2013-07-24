public class Main {

	public static void main(String[] args) {
		int limX=11,limY=11;
		ManejadorTablero manejadorTablero = new ManejadorTablero(limX,limY);
		ManejadorRey manejadorRey = new ManejadorRey(limX,limY,manejadorTablero);
		ManejadorFichas manejadorFichas = new ManejadorFichas(limX,limY,manejadorTablero);
		PanelReglas panelReglas = new PanelReglas();
		VentanaReglas ventanaReglas = new VentanaReglas(panelReglas);
		PanelHistoria panelHistoria = new PanelHistoria();
		VentanaHistoria ventanaHistoria = new VentanaHistoria(panelHistoria);
		PanelPrincipal panelPrincipal = new PanelPrincipal(ventanaReglas,ventanaHistoria,limX,limY,manejadorTablero,manejadorRey,manejadorFichas);
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(panelPrincipal);
		ventanaPrincipal.setVisible(true);
	}
}

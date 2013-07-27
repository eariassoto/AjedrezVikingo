
import java.awt.event.*;
import java.awt.*;
import java.util.Iterator;

import javax.swing.*;


@SuppressWarnings("serial")
public class TableroHnefatafl extends JFrame{
	ManejadorTablero manejadorTablero;
	ManejadorRey manejadorRey;
	ManejadorFichas manejadorFichas;
	JPanel panelTablero, panelLateral, panelConsola;
	JLabel lblMensajes, lblAdvertenciaJU, lblAdvertenciaJD;
	String men = "";
	JButton btnNuevoJuego,btnCambiarFicha;
	JButton[][] tableroBtn; 
	int y, x;
	boolean esperandoMov = false, fin = false;
	final int LIMITE,CENTRO;
	final int[] posBlancasX = {3,4,4,4,5,5,5,5,6,6,6,7}, 
			posBlancasY = {5,4,5,6,3,4,6,7,4,5,6,5},
			posNegrasX = {0,0,0,0,0,1,10,10,10,10,10,9,3,4,5,6,7,5,3,4,5,6,7,5},
			posNegrasY = {3,4,5,6,7,5,3,4,5,6,7,5,0,0,0,0,0,1,10,10,10,10,10,9};
	final String SUECO = "sueco", MOSCOVITA = "moscovita", REY = "rey", ADJ = "Jugador 1: Jaque", ADJM = "Jugador 1: Jaque Mate",ADCR = "Jugador 2: cuida tu Rey";
	enum jugador{JUGADOR1, JUGADOR2};
	jugador actual;


	public TableroHnefatafl(int LIMITE,ManejadorTablero mT, ManejadorRey mR,ManejadorFichas mF){
		super("Hnefatafl");
		setLayout(null);
		setSize(800,560);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		this.LIMITE = LIMITE;
		this.CENTRO = (LIMITE-1)/2;
		this.manejadorTablero = mT;
		this.manejadorRey = mR;
		this.manejadorFichas = mF;
		tableroBtn = new JButton[LIMITE][LIMITE];

		actual = jugador.JUGADOR1;

		panelTablero = new JPanel();
		panelTablero.setLayout(new GridLayout(LIMITE, LIMITE, 3, 3));
		panelTablero.setBounds(1, 1, 625, 500);
		panelTablero.setVisible(true);

		panelLateral = new JPanel();
		panelLateral.setLayout(new GridLayout(15,1,3,3));
		panelLateral.setBounds(630, 0, 160, 500);
		panelLateral.setVisible(true);

		panelConsola = new JPanel();
		panelConsola.setBounds(0, 500, 200, 300);
		panelConsola.setVisible(true);

		btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.setVisible(true);
		
		btnCambiarFicha = new JButton("Cambiar de ficha");
		btnCambiarFicha.setVisible(false);

		lblMensajes = new JLabel();
		lblMensajes.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblMensajes.setText(getMensaje());
		lblMensajes.setVisible(true);

		lblAdvertenciaJU = new JLabel();
		lblAdvertenciaJU.setForeground(Color.RED);
		lblAdvertenciaJU.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblAdvertenciaJU.setVisible(false);
		
		lblAdvertenciaJD = new JLabel();
		lblAdvertenciaJD.setForeground(Color.RED);
		lblAdvertenciaJD.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblAdvertenciaJD.setVisible(false);
		
		panelLateral.add(btnNuevoJuego);
		panelLateral.add(btnCambiarFicha);
		panelLateral.add(lblAdvertenciaJU);
		panelLateral.add(lblAdvertenciaJD);
		panelConsola.add(lblMensajes);
		

		
		add(panelTablero);
		add(panelLateral);
		add(panelConsola);

		
		agregarBtn();
		iniciar();
		listeners();
	} 
	
	void iniciar(){
		fin = false;
		manejadorTablero.setTablero(posBlancasX, posBlancasY, posNegrasX, posNegrasY);
		limpiarFichas();
		agregarFichas();
		actual = actual.JUGADOR1;
		lblMensajes.setText(getMensaje());
	}

	void agregarBtn(){
		for(int i =0; i<LIMITE; i++){
			for(int j =0; j<LIMITE; j++) {
				tableroBtn[i][j] = new JButton( "" );
				panelTablero.add(tableroBtn[i][j]);
			}
		}
	}

	void listeners(){
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"¿Deseas iniciar un nuevo juego?, la partida actual se perderá.", "Nuevo Juego", JOptionPane.YES_NO_OPTION) == 0){
					iniciar();
				}
				
			}});
		
		btnCambiarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esperandoMov = false;
			}});

		ButtonHandler handler = new ButtonHandler();
		for(int i=0;i<LIMITE;i++){
			for(int j=0;j<LIMITE;j++) {
				tableroBtn[i][j].addActionListener(handler);  
			}
		}
	}

	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			for(int i=0;i<LIMITE;i++){
				for(int j=0;j<LIMITE;j++){
					if(evento.getSource() == tableroBtn[i][j]) {
						principal(i,j);
					}
				}
			}
		} 
	}  
	void principal(int x_act, int y_act) {
		switch (actual){
		case JUGADOR1:
			if(puedeSeleccionar(x_act,y_act)){
				seleccionarFicha(x_act, y_act);
			}
			else if(podriaMover(x_act,y_act)){
				if(puedeMover(x,y,x_act,y_act)){
					mover(x,y,x_act,y_act);
					if(comerFicha(x_act,y_act,SUECO,MOSCOVITA)){
						comerFichas(manejadorFichas.getCoordX(),manejadorFichas.getCoordY());
					}if(fichaComida(x_act, y_act, SUECO)){
						comerFicha(x_act, y_act);
					}
					verificarEstado();
					liberarFicha();

				}else{
					liberarFicha(true);
				}
			}
			break;

		case JUGADOR2:
			if(puedeSeleccionar(x_act,y_act)){
				seleccionarFicha(x_act, y_act);
			}
			else if(podriaMover(x_act,y_act)){
				if(puedeMover(x,y,x_act,y_act)){
					mover(x,y,x_act,y_act);
					switch(manejadorTablero.getPos(x_act, y_act)){
					case SUECO:
						if(comerFicha(x_act,y_act,MOSCOVITA,SUECO)){
							comerFichas(manejadorFichas.getCoordX(),manejadorFichas.getCoordY());
						} if(fichaComida(x_act, y_act, MOSCOVITA)){
							comerFicha(x_act, y_act);
						} 
						verificarEstado();
						break;
					case REY:
						if(comerFicha(x_act,y_act,MOSCOVITA,SUECO)){
							comerFichas(manejadorFichas.getCoordX(),manejadorFichas.getCoordY());
						} 
						verificarEstado();
						break;
					}
					liberarFicha();
				}else{
					liberarFicha(true);
				}
			}
			break;
		}
	}

	boolean puedeSeleccionar(int x_act, int y_act){
		if(actual == jugador.JUGADOR1){
			return !esperandoMov && manejadorFichas.btnEsNegro(x_act, y_act) && manejadorFichas.btnConIcono(tableroBtn[x_act][y_act]);
		}else{
			return !esperandoMov && manejadorFichas.btnEsBlanco(x_act, y_act) && manejadorFichas.btnConIcono(tableroBtn[x_act][y_act]);
		}
	}
	
	void seleccionarFicha(int x_act, int y_act){
		esperandoMov = true;
		x = x_act;
		y = y_act;
		btnCambiarFicha.setVisible(true);
	}
	
	boolean podriaMover(int x_act, int y_act){
		return esperandoMov && !manejadorFichas.btnConIcono(tableroBtn[x_act][y_act]);
	}
	boolean puedeMover(int x, int y, int x_act, int y_act){
		return manejadorFichas.recorridoLimpio(x,y,x_act,y_act);
	}
	boolean comerFicha(int x_act, int y_act, String s, String p){
		return manejadorFichas.comerFicha(x_act,y_act,s,p);
	}
	boolean fichaComida(int x_act, int y_act, String s) {
		return manejadorFichas.fichaComida(x_act, y_act, s);
	}
	
	void verificarEstado(){
		switch(manejadorRey.verificarEstado()){
		case 0:
			lblAdvertenciaJU.setVisible(false);
			lblAdvertenciaJD.setVisible(false);
			break;
		case 1:
			lblAdvertenciaJU.setVisible(false);
			lblAdvertenciaJD.setVisible(false);
			terminarJuego(SUECO);
			break;
		case 2:
			lblAdvertenciaJU.setVisible(false);
			lblAdvertenciaJD.setVisible(false);
			terminarJuego(MOSCOVITA);
			break;
		case 3:
			lblAdvertenciaJU.setText(ADJ);
			lblAdvertenciaJU.setVisible(true);
			lblAdvertenciaJD.setText(ADCR);
			lblAdvertenciaJD.setVisible(true);
			break;
		case 4:
			lblAdvertenciaJD.setText(ADCR);
			lblAdvertenciaJD.setVisible(true);
			break;
		case 5:
			lblAdvertenciaJU.setText(ADJ);
			lblAdvertenciaJU.setVisible(true);
			break;
		case 6:
			lblAdvertenciaJU.setText(ADJM);
			lblAdvertenciaJU.setVisible(true);
			break;
		}
	}
	
	void liberarFicha(){
		esperandoMov = false;
		btnCambiarFicha.setVisible(false);
		if(actual == jugador.JUGADOR1){
			actual = jugador.JUGADOR2;
		}else{
			actual = jugador.JUGADOR1;
		}
		if(!fin){
			lblMensajes.setText(getMensaje());
		}
	}
	void liberarFicha(boolean b){
		esperandoMov = b;
		if(actual == jugador.JUGADOR1){
			actual = jugador.JUGADOR2;
		}else{
			actual = jugador.JUGADOR1;
		}
	}

	void comerFichas(Iterator<Integer> coordX, Iterator<Integer> coordY){
		while(coordX.hasNext()){
			int x = coordX.next();
			int y = coordY.next();
			tableroBtn[x][y].setIcon(null);
			manejadorTablero.setPos(x, y, "");
		}
	}

	void comerFicha(int x, int y){
		tableroBtn[x][y].setIcon(null);
		manejadorTablero.setPos(x, y, "");
	}
	
	void terminarJuego(String ganador){
		for(int i =0; i<LIMITE; i++){
			for(int j =0; j<LIMITE; j++){
				tableroBtn[i][j].setEnabled(false); 
			}
		}
		lblMensajes.setText("Han ganado los "+(ganador)+"s.");
		fin = true;
	}

	String getMensaje(){
		switch(actual){
		case JUGADOR1:
			men = "Turno del Jugador #1 (negras)";
			break;
		case JUGADOR2:
			men = "Turno del Jugador #2 (blancas)";
			break;
		}
		return men;
	}
	
	void mover(int x, int y, int a, int b)
	{
		switch(manejadorTablero.getPos(x, y)){
		case REY:
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/rey_peq.png")));
			manejadorTablero.setPos(a, b, REY);
			break;
		case SUECO:
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/sueco_peq.png")));
			manejadorTablero.setPos(a, b, SUECO);
			break;
		case MOSCOVITA:
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/moscovita_peq.png")));
			manejadorTablero.setPos(a, b, MOSCOVITA);
			break;
		}
		tableroBtn[x][y].setIcon(null);
		manejadorTablero.setPos(x, y, "");

	}

	void agregarFichas(){
		tableroBtn[CENTRO][CENTRO].setIcon(new ImageIcon(getClass().getResource("/imagenes/rey_peq.png")));
		tableroBtn[CENTRO][CENTRO].setBackground(Color.GREEN);
		tableroBtn[0][0].setBackground(Color.RED);
		tableroBtn[0][LIMITE-1].setBackground(Color.RED);
		tableroBtn[LIMITE-1][0].setBackground(Color.RED);
		tableroBtn[LIMITE-1][LIMITE-1].setBackground(Color.RED);
		for(int i=0;i<posBlancasX.length;i++){
			tableroBtn[posBlancasX[i]][posBlancasY[i]].setIcon(new ImageIcon(getClass().getResource("/imagenes/sueco_peq.png")));
		}
		for(int i=0;i<posNegrasX.length;i++){
			tableroBtn[posNegrasX[i]][posNegrasY[i]].setIcon(new ImageIcon(getClass().getResource("/imagenes/moscovita_peq.png")));
		}
	}
	void limpiarFichas(){
		for(int i=0;i<LIMITE;i++){
			for(int j=0; j<LIMITE; j++){
				tableroBtn[i][j].setEnabled(true); 
				tableroBtn[i][j].setIcon(null);
			}
		}

	}
}
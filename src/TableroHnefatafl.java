
import java.awt.event.*;
import java.awt.*;
import java.util.Iterator;

import javax.swing.*;


@SuppressWarnings("serial")
public class TableroHnefatafl extends JFrame{
	ManejadorTablero manejadorTablero;
	ManejadorRey manejadorRey;
	ManejadorFichas manejadorFichas;
	JPanel panelTablero, panelBtn, panelConsola;
	JLabel lblMensajes;
	String men = "";
	JButton btnNuevoJuego;
	JButton[][] tableroBtn; 
	final int LIMITE,CENTRO;
	int y, x;
	boolean esperandoMov = false;
	final int[] posBlancasX = {3,4,4,4,5,5,5,5,6,6,6,7}, 
			posBlancasY = {5,4,5,6,3,4,6,7,4,5,6,5},
			posNegrasX = {0,0,0,0,0,1,10,10,10,10,10,9,3,4,5,6,7,5,3,4,5,6,7,5},
			posNegrasY = {3,4,5,6,7,5,3,4,5,6,7,5,0,0,0,0,0,1,10,10,10,10,10,9};
	 
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

		panelBtn = new JPanel();
		panelBtn.setLayout(new GridLayout(15,1,3,3));
		panelBtn.setBounds(660, 0, 130, 500);
		panelBtn.setVisible(true);

		panelConsola = new JPanel();
		panelConsola.setLayout(new FlowLayout());
		panelConsola.setBounds(0, 500, 200, 300);
		panelConsola.setVisible(true);

		btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.setVisible(true);

		lblMensajes = new JLabel(men);
		lblMensajes.setFont(new java.awt.Font("Tahoma", 0, 14));
		lblMensajes.setText(getMensaje());
		lblMensajes.setVisible(true);

		add(panelTablero);
		add(panelBtn);
		add(panelConsola);

		panelBtn.add(btnNuevoJuego);
		panelConsola.add(lblMensajes);
		agregarBtn();
		mT.setTablero(posBlancasX, posBlancasY, posNegrasX, posNegrasY);
		agregarFichas(); 
		listeners();
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
				manejadorTablero.setTablero(posBlancasX, posBlancasY, posNegrasX, posNegrasY);
				agregarFichas();
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
			if(!esperandoMov && manejadorFichas.btnEsNegro(x_act, y_act) && manejadorFichas.btnConIcono(tableroBtn[x_act][y_act])){
				esperandoMov = true;
				x = x_act;
				y = y_act;
			}
			else if(esperandoMov && !manejadorFichas.btnConIcono(tableroBtn[x_act][y_act])){
				//esto en otro metodo
				if(manejadorFichas.recorridoLimpio(x,y,x_act,y_act)){
					mover(x,y,x_act,y_act);
					if(manejadorFichas.comerFicha(x_act,y_act,"sueco","moscovita")){
						comerFichas(manejadorFichas.getCoordX(),manejadorFichas.getCoordY());
					}if(manejadorFichas.fichaComida(x_act, y_act, "sueco")){
						comerFicha(x_act, y_act);
					}
					//meter el switch en otro metodo
					switch(manejadorRey.verificarEstado()){
					case 1:
						System.out.println("gano");
						break;
					case 2:
						System.out.println("perdio");
						break;
					case 3:
						System.out.println("jaque y cuidado");
						break;
					case 4:
						System.out.println("cuidado");
						break;
					case 5:
						System.out.println("jaque");
						break;
					case 6:
						System.out.println("mate");
						break;
					}
					//esto igual en otro
					manejadorRey.verificarEstado();
					esperandoMov = false;
					actual = jugador.JUGADOR2;
					lblMensajes.setText(getMensaje());

				}else{
					esperandoMov = true;
					actual = jugador.JUGADOR1;
				}
			}
			break;

		case JUGADOR2:
			if(!esperandoMov && manejadorFichas.btnEsBlanco(x_act, y_act) && manejadorFichas.btnConIcono(tableroBtn[x_act][y_act])){
				esperandoMov = true;
				x = x_act;
				y = y_act;
			}
			else if(esperandoMov&& !manejadorFichas.btnConIcono(tableroBtn[x_act][y_act])){
				if(manejadorFichas.recorridoLimpio(x,y,x_act,y_act)){
					mover(x,y,x_act,y_act);
					switch(manejadorTablero.getPos(x_act, y_act)){
					case "sueco":
						if(manejadorFichas.comerFicha(x_act,y_act,"moscovita","sueco")){
							comerFichas(manejadorFichas.getCoordX(),manejadorFichas.getCoordY());
						} if(manejadorFichas.fichaComida(x_act, y_act, "moscovita")){
							comerFicha(x_act, y_act);
						} 
						manejadorRey.verificarEstado();
						break;
					case "rey":
						if(manejadorFichas.comerFicha(x_act,y_act,"moscovita","sueco")){
							comerFichas(manejadorFichas.getCoordX(),manejadorFichas.getCoordY());
						} 
						manejadorRey.verificarEstado();
						break;
					}
					esperandoMov = false;
					actual = jugador.JUGADOR1;
					lblMensajes.setText(getMensaje());
				}else{
					esperandoMov = true;
					actual = jugador.JUGADOR2;
				}
			}
			break;
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
	
	void terminarJuego(String ganador ){
		for(int i =0; i<LIMITE; i++){
			for(int j =0; j<LIMITE; j++){
				tableroBtn[i][j].setEnabled(false); 
			}
		}
		lblMensajes.setText("Han ganado los "+(ganador));
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
		case "rey":
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/rey_peq.png")));
			manejadorTablero.setPos(a, b, "rey");
			break;
		case "sueco":
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/sueco_peq.png")));
			manejadorTablero.setPos(a, b, "sueco");
			break;
		case "moscovita":
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/moscovita_peq.png")));
			manejadorTablero.setPos(a, b, "moscovita");
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
}
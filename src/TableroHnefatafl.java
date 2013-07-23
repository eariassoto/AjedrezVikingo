
import java.awt.event.*;
import java.awt.*;
import java.util.Iterator;

import javax.swing.*;


@SuppressWarnings("serial")
public class TableroHnefatafl extends JFrame{
	Manejador manejador;
	JPanel panelTablero, panelBtn, panelConsola;
	JLabel lblMensajes;
	String men = "";
	JButton btnNuevoJuego;
	JButton[][] tableroBtn; 

	private boolean esperandoMov = false;
	final int[] posBlancasX = {3,4,4,4,5,5,5,5,6,6,6,7}, 
			posBlancasY = {5,4,5,6,3,4,6,7,4,5,6,5},
			posNegrasX = {0,0,0,0,0,1,10,10,10,10,10,9,3,4,5,6,7,5,3,4,5,6,7,5},
			posNegrasY = {3,4,5,6,7,5,3,4,5,6,7,5,0,0,0,0,0,1,10,10,10,10,10,9};
	private int y, x; 
	private enum jugador{JUGADOR1, JUGADOR2};
	jugador actual;


	public TableroHnefatafl(Manejador manejador){
		super("Hnefatafl");
		setLayout(null);
		setSize(800,560);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		this.manejador = manejador;

		tableroBtn = new JButton[11][11];

		actual = jugador.JUGADOR1;

		panelTablero = new JPanel();
		panelTablero.setLayout(new GridLayout(11, 11, 3, 3));
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
		manejador.setTablero(11, 11, 5, 5, posBlancasX, posBlancasY, posNegrasX, posNegrasY);
		agregarFichas(); 
		listeners();
	} 

	void agregarBtn(){
		for(int i =0; i<11; i++){
			for(int j =0; j<11; j++) {
				tableroBtn[i][j] = new JButton( "" );
				panelTablero.add(tableroBtn[i][j]);
			}
		}
	}

	void listeners(){
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manejador.setTablero(11, 11, 5, 5, posBlancasX, posBlancasY, posNegrasX, posNegrasY);
				agregarFichas();
			}});

		ButtonHandler handler = new ButtonHandler();
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++) {
				tableroBtn[i][j].addActionListener(handler);  
			}
		}
	}

	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			for(int i=0;i<11;i++){
				for(int j=0;j<11;j++){
					if(evento.getSource() == tableroBtn[i][j]) {
						principal(i,j);
					}
				}
			}
		} 
	}  
	public void principal(int x_act, int y_act) {
		switch (actual){
		case JUGADOR1:
			if(!esperandoMov && manejador.btnEsNegro(x_act, y_act) && manejador.btnConIcono(tableroBtn[x_act][y_act])){
				esperandoMov = true;
				x = x_act;
				y = y_act;
			}
			else if(esperandoMov && !manejador.btnConIcono(tableroBtn[x_act][y_act])){
				if(manejador.recorridoLimpio(x,y,x_act,y_act)){
					mover(x,y,x_act,y_act);
					if(manejador.comerFicha(x_act,y_act,"sueco","moscovita")){
						comerFichas(manejador.getCoordX(),manejador.getCoordY());
					}
					if(manejador.fichaComida(x_act, y_act, "sueco")){
						comerFicha(x_act, y_act);
					}

					//comprobarFichaComida(x_act,y_act,"sueco");
					//comprobarComerRey(x_act,y_act);
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
			if(!esperandoMov && manejador.btnEsBlanco(x_act, y_act) && manejador.btnConIcono(tableroBtn[x_act][y_act])){
				esperandoMov = true;
				x = x_act;
				y = y_act;
			}
			else if(esperandoMov&& !manejador.btnConIcono(tableroBtn[x_act][y_act])){
				if(manejador.recorridoLimpio(x,y,x_act,y_act)){
					mover(x,y,x_act,y_act);
					if(manejador.comerFicha(x_act,y_act,"moscovita","sueco")){
						comerFichas(manejador.getCoordX(),manejador.getCoordY());
					}
					if(manejador.fichaComida(x_act, y_act, "moscovita")){
						comerFicha(x_act, y_act);
					}
					
					
					/*switch(manejador.getPos(x_act, y_act)){
					case "rey":
						comprobarReyComido(x_act,y_act);
						comprobarReySalio();
						break;
					case "sueco":
						comprobarFichaComida(x_act,y_act,"moscovita");
						comprobarComerFicha(x_act,y_act,"moscovita");
						break;
					}*/

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
			manejador.setPos(x, y, "");
		}
	}

	void comerFicha(int x, int y){
		tableroBtn[x][y].setIcon(null);
		manejador.setPos(x, y, "");
	}

	/*public void comprobarFichaComida(int x, int y,String s)
	{
		if(manejador.comerFicha(x, y,s)){
			tableroBtn[x][y].setIcon(null);
			manejador.setPos(x, y, "");
		}
	}*/

	public void comprobarComerRey(int x, int y){
		if(manejador.reyComido(x, y)){
			System.out.println("LOL game over, king is dead");
			//TO-DO GAMEOVER
		}
	}

	public void comprobarComerFicha(int x, int y, String s){
		//TODO
	}

	public void comprobarNoNegras(){
		if(manejador.noNegras()){
			System.out.println("LOL no more moscovitas");
			actual = jugador.JUGADOR2;
		}
	}

	public void comprobarReyComido(int x, int y){
		if(manejador.reyComido(x, y)){
			System.out.println("LOL game over, king is dead");
			//TO-DO game over
		}
	}

	public void comprobarReySalio(){
		if(manejador.reySalio()){
			System.out.println("LOL game over, king is out");
			//TO-DO game over
		}
	}

	public String getMensaje(){
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

	/*public void limpiar(){
		for(int i =0; i<11; i++)
		{
			for(int j =0; j<11; j++)
			{
				manejador.limpiar();
				tableroBtn[i][j].setIcon(null);
				tableroBtn[i][j].setEnabled(true);
				actual = jugador.JUGADOR1;
				esperandoMov = false;
				lblMensajes.setText(getMensaje());
			}
		}
	}*/





	/*public void buscar_blanca()
	{
		for(int i =0; i<11; i++)
		{
			for(int j =0; j<11; j++)
			{
				if(tablero[i][j] == "sueco")
				{
					comer_blanca(i,j);
				} 
			}
		}
	}

	public void comer_blanca(int x, int y)
	{
		try
		{
			if(tablero[x-1][y] == "moscovita" && tablero[x+1][y] == "moscovita")
			{
				tableroBtn[x][y].setIcon(null);
				tablero[x][y] = "";
			}
			if(tablero[x][y-1] == "moscovita" && tablero[x][y+1] == "moscovita")
			{
				tableroBtn[x][y].setIcon(null);
				tablero[x][y] = "";
			}
		}
		catch(Exception e)
		{
		}
	}

	public void gane_negras(int x, int y) 
	{
		if(tablero[x-1][y] == "moscovita" && tablero[x+1][y] == "moscovita" && tablero[x][y-1] == "moscovita" && tablero[x][y+1] == "moscovita")
		{
			terminar_juego("Moscovitas");
		}
	}

	public void buscar_rey()
	{
		for(int i =0; i<11; i++)
		{
			for(int j =0; j<11; j++)
			{
				if(tablero[i][j] == "rey")
				{
					gane_negras(i,j);
				} 
			}
		}
	}


	public void terminar_juego(String ganador )
	{
		for(int i =0; i<11; i++)
		{
			for(int j =0; j<11; j++)
			{
				tableroBtn[i][j].setEnabled(false); 

			}

		}
		lblMensajes.setText(crear_mensajes(ganador));
		System.out.println("Ganaron los " + ganador);
	}

	public String crear_mensajes(String ganador)
	{
		men = "Han ganado los " + ganador;

		return men;
	}

	public void gane_rey()
	{
		for(int i=0; i<11; i++)
		{
			if(tablero[i][0] == "rey" || tablero[i][10] == "rey" || tablero[0][i] == "rey" || tablero[10][i] == "rey")
			{
				terminar_juego("Suecos");

			}

		}
	}
	 */
	public void mover(int x, int y, int a, int b)
	{
		switch(manejador.getPos(x, y)){
		case "rey":
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/rey_peq.png")));
			manejador.setPos(a, b, "rey");
			break;
		case "sueco":
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/sueco_peq.png")));
			manejador.setPos(a, b, "sueco");
			break;
		case "moscovita":
			tableroBtn[a][b].setIcon(new ImageIcon(getClass().getResource("/imagenes/moscovita_peq.png")));
			manejador.setPos(a, b, "moscovita");
			break;
		}
		tableroBtn[x][y].setIcon(null);
		manejador.setPos(x, y, "");

	}

	public void agregarFichas(){
		tableroBtn[5][5].setIcon(new ImageIcon(getClass().getResource("/imagenes/rey_peq.png")));
		for(int i=0;i<posBlancasX.length;i++){
			tableroBtn[posBlancasX[i]][posBlancasY[i]].setIcon(new ImageIcon(getClass().getResource("/imagenes/sueco_peq.png")));
		}
		for(int i=0;i<posNegrasX.length;i++){
			tableroBtn[posNegrasX[i]][posNegrasY[i]].setIcon(new ImageIcon(getClass().getResource("/imagenes/moscovita_peq.png")));
		}
	}



}
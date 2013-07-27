import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;


@SuppressWarnings("all")
public class ManejadorTablero {

	String[][] tablero; 
	final int LIMITE, CENTRO;
	
	public ManejadorTablero(int LIMITE){
		this.LIMITE = LIMITE;
		this.CENTRO = (LIMITE-1)/2;
	}

	public void setTablero(int[] posBX, int[] posBY, int[] posNX, int[] posNY){
		tablero = new String[LIMITE][LIMITE];
		tablero[CENTRO][CENTRO] = "rey";
		for(int i=0;i<posBX.length;i++){
			tablero[posBX[i]][posBY[i]] = "sueco";
		}
		for(int i=0;i<posNX.length;i++){
			tablero[posNX[i]][posNY[i]] = "moscovita";
		}
	}
	
	public void setPos(int x, int y,String s){
		tablero[x][y] = s;
	}
	
	public String getPos(int x, int y){
		return tablero[x][y];
	}



	


	

}

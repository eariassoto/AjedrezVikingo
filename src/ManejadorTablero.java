import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;


@SuppressWarnings("all")
public class ManejadorTablero {

	String[][] tablero; 
	int limite, centro;
	
	public ManejadorTablero(){
	}

	public void setTablero(int limite, int[] posBX, int[] posBY, int[] posNX, int[] posNY){
		this.limite = limite;
		this.centro = (limite-1)/2;
		tablero = new String[limite][limite];
		tablero[centro][centro] = "rey";
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

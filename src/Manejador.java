import javax.swing.JButton;

public class Manejador {

	String[][] tablero; 
	int limX, limY;
	public Manejador(){

	}

	public void setTablero(int x, int y,int reyX, int reyY, int[] posBX, int[] posBY, int[] posNX, int[] posNY){
		this.limX = x;
		this.limY = y;
		tablero = new String[x][y];
		tablero[reyX][reyY] = "rey";
		for(int i=0;i<posBX.length;i++){
			tablero[posBX[i]][posBY[i]] = "sueco";
		}
		for(int i=0;i<posNX.length;i++){
			tablero[posNX[i]][posNY[i]] = "moscovita";
		}
	}

	public boolean btnConIcono(JButton boton){
		if(boton.getIcon() != null){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean comprobarPosicion(int x, int y, int a, int b){
		if(x!=a && y==b){
			return true;
		}
		if(x==a && y!=b){
			return true;
		}
		else{
			return false;
		}
	}


	public boolean btnEsBlanco(int x, int y){
		if(tablero[x][y] == "sueco"){
			return true;
		}
		if(tablero[x][y] == "rey"){
			return true;
		}
		else{
			return false;
		}
	}


	public boolean btnEsNegro(int x, int y){
		if(tablero[x][y] == "moscovita"){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean recorridoLimpio(int x, int y, int a, int b){
		try{
			if(x!=a && x>a) {
				for(int i = x-1; i>a; i--){
					if(tablero[i][b] == "moscovita" || tablero[i][b] == "sueco" || tablero[i][b] == "rey"){
						return false;
					}
				}
			}
			if(x!=a && x<a) {
				for(int i = x+1; i<a; i++){
					if(tablero[i][b] == "moscovita" || tablero[i][b] == "sueco" || tablero[i][b] == "rey"){
						return false;
					}
				}
			}

			if(y!=b && y>b)	{
				for(int i = y-1; i>b; i--){
					if(tablero[a][i] == "moscovita" || tablero[a][i] == "sueco" || tablero[a][i] == "rey"){
						return false;
					}
				}
			}
			if(y!=b && y<b) {
				for(int i = y+1; i<b; i++){
					if(tablero[a][i] == "tablero" || tablero[a][i] == "sueco" || tablero[a][i] == "rey")
					{
						return false;
					}
				}
			}
		}
		catch(Exception e){}
		return true;
	}

	public boolean fichaComida(int x, int y,String s){
		if(tablero[x-1][y] == s && tablero[x+1][y] == s){
			return true;
		}
		else if(tablero[x][y-1] == s && tablero[x][y+1] == s){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean comprobarComerRey(int x, int y){
		if(tablero[x+1][y] == "rey"){
			if(reyComido(x+1,y)){
				return true;
			}
			else{
				return false;
			}
		}
		else if(tablero[x-1][y] == "rey"){
			if(reyComido(x-1,y)){
				return true;
			}
			else{
				return false;
			}
		}
		else if(tablero[x][y-1] == "rey"){
			if(reyComido(x,y-1)){
				return true;
			}
			else{
				return false;
			}
		}
		else if(tablero[x][y+1] == "rey"){
			if(reyComido(x+1,y+1)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	public boolean reyComido(int x, int y){
		if(tablero[x+1][y] == "moscovita" && tablero[x-1][y] == "moscovita" && tablero[x][y+1] == "moscovita" && tablero[x][y-1] == "moscovita"){		
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean reySalio(){
		for(int i=0;i<limX;i++){
			if(tablero[i][0]=="rey"){
				return true;
			}
			else if(tablero[i][limY-1]=="rey"){
				return true;
			}
		}
		for(int i=0;i<limY;i++){
			if(tablero[0][i]=="rey"){
				return true;
			}
			else if(tablero[limX-1][i]=="rey"){
				return true;
			}
		}
		return false;		
	}



	public boolean noNegras(){
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				if(tablero[i][j] == "moscovita"){
					return false;
				}
			}
		}
		return true;
	}
	public void setPos(int x, int y,String s){
		tablero[x][y] = s;
	}
	public String getPos(int x, int y){
		return tablero[x][y];
	}
}

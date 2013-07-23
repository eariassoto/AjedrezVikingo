import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;

public class Manejador {

	String[][] tablero; 
	int limX, limY;
	Fichas fichas;
	public Manejador(){
		fichas = new Fichas();
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
		if(x!=a && y!=b){
			return false;
		}
		if(getPos(x,y)!="rey" && a==0 && b == 0){
			return false;
		}else if(getPos(x,y)!="rey" && a==0 && b == limY-1){
			return false;
		} else if(getPos(x,y)!="rey" && a==limX-1 && b == 0){
			return false;
		} else if(getPos(x,y)!="rey" && a==limX-1 && b == limY-1){
			return false;
		} else{
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
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return true;
	}



	public boolean comerFicha(int x, int y,String s, String p){
		limpiar();
		boolean b = false;
		//esquinas
		if(x==0 && y==2 && getPos(0,1)==s){
			System.out.println("Comer esquina "+0+" "+1);
			fichas.agregar(0, 1);
			b=true;
			if(getPos(0,4)==p && getPos(0,3)==s){
				System.out.println("Comer esquina "+0+" "+3);
				fichas.agregar(0, 3);
				b=true;
			}
		} else if(x==0 && y==limY-3 && getPos(0,limY-2)==s){
			System.out.println("Comer esquina "+0+" "+(limY-2));
			fichas.agregar(0, limY-2);
			b=true;
			if(getPos(0,limY-5)==p && getPos(0,limY-4)==s){
				System.out.println("Comer esquina "+0+" "+(limY-4));
				fichas.agregar(0, limY-4);
				b=true;
			}
		} else if(x==limX-1 && y==2 && getPos(limX-1,1)==s){
			System.out.println("Comer esquina "+(limX-1)+" "+1);
			fichas.agregar(limX-1, 1);
			b=true;
			if(getPos(limX-1,4)==p && getPos(limX-1,3)==s){
				System.out.println("Comer esquina "+(limX-1)+" "+3);
				fichas.agregar(limX-1,3);
				b=true;
			}
		} else if(x==limX-1 && y==limY-3 && getPos(limX-1,limY-2)==s){
			System.out.println("Comer esquina "+(limX-1)+" "+(limY-2));
			fichas.agregar(limX-1, limY-2);
			b=true;
			if(getPos(limX-1,limY-5)==p && getPos(limX-1,limY-4)==s){
				System.out.println("Comer esquina "+(limX-1)+" "+(limY-4));
				fichas.agregar(limX-1, limY-4);
				b=true;
			}
		} else if(x==2 && y==0 && getPos(1,0)==s){
			System.out.println("Comer esquina "+1+" "+0);
			fichas.agregar(1, 0);
			b=true;
			if(getPos(4,0)==p && getPos(3,0)==s){
				System.out.println("Comer esquina "+3+" "+0);
				fichas.agregar(3, 0);
				b=true;
			}
		} else if(x==limX-3 && y==0 && getPos(limX-2,0)==s){
			System.out.println("Comer esquina "+(limX-2)+" "+0);
			fichas.agregar(limX-2, 0);
			b=true;
			if(getPos(limX-5,0)==p && getPos(limX-4,0)==s){
				System.out.println("Comer esquina "+(limX-4)+" "+0);
				fichas.agregar(limX-4, 0);
				b=true;
			}
		} else if(x==2 && y==limY-1 && getPos(1,limY-1)==s){
			System.out.println("Comer esquina "+1+" "+(limY-1));
			fichas.agregar(1, limY-1);
			b=true;
			if(getPos(4,limY-1)==p && getPos(3,limY-1)==s){
				System.out.println("Comer esquina "+3+" "+(limY-1));
				fichas.agregar(3,limY-1);
				b=true;
			}
		} else if(x==limX-3 && y==limY-1 && getPos(limX-2,limY-1)==s){
			System.out.println("Comer esquina "+(limX-2)+" "+(limY-1));
			fichas.agregar(limX-2, limY-1);
			b=true;
			if(getPos(limX-5,limY-1)==p && getPos(limX-4,limY-1)==s){
				System.out.println("Comer esquina "+(limX-4)+" "+(limY-1));
				fichas.agregar(limX-4, limY-1);
				b=true;
			}
		} //fin de las esquinas

		//limites
		if(x>=2){ 
			//puede buscar para arriba
			if(getPos(x-2,y)==p && getPos(x-1,y)==s){
				System.out.println("Comer arriba "+(x-1)+" "+y);
				fichas.agregar(x-1, y);
				b=true;
			}
		} if(x<=limX-3){
			//puede buscar para abajo
			if(getPos(x+2,y)==p && getPos(x+1,y)==s){
				System.out.println("Comer abajo "+(x+1)+" "+y);
				fichas.agregar(x+1, y);
				b=true;
			}
		} if(y>=2){
			//puede buscar a la izq
			if(getPos(x,y-2)==p && getPos(x,y-1)==s){
				System.out.println("Comer izq "+x+" "+(y-1));
				fichas.agregar(x, y-1);
				b=true;
			}
		} if(y<=limY-3){
			//puede buscar a la der
			if(getPos(x,y+2)==p && getPos(x,y+1)==s){
				System.out.println("Comer der "+x+" "+(y+1));
				fichas.agregar(x, y+1);
				b=true;
			}
		}
		return b;
	}

	public boolean fichaComida(int x, int y,String s){
		boolean b = false;
		//esquinas
		if(x==0 && y==1 && getPos(0,2)==s){
			System.out.println("Me comieron");
			b=true;
		} else if(x==0 && y==limY-2 && getPos(0,limY-3)==s){
			System.out.println("Me comieron");
			b=true;
		} else if(x==limX-1 && y==1 && getPos(limX-1,2)==s){
			System.out.println("Me comieron");
			b=true;
		} else if(x==limX-1 && y==limY-2 && getPos(limX-1,limY-3)==s){
			System.out.println("Me comieron");
			b=true;
		} else if(x==1 && y==0 && getPos(2,0)==s){
			System.out.println("Me comieron");
			b=true;
		} else if(x==limX-2 && y==0 && getPos(limX-3,0)==s){
			System.out.println("Me comieron");
			b=true;
		} else if(x==1 && y==limY-1 && getPos(2,limY-1)==s){
			System.out.println("Me comieron");
			b=true;
		} else if(x==limX-2 && y==limY-1 && getPos(limX-3,limY-1)==s){
			System.out.println("Me comieron");
			b=true;
		} //fin de las esquinas

		//limites
		if(x>=1 && x<=limX-2){ 
			if(getPos(x-1,y)==s && getPos(x+1,y)==s){
				System.out.println("Me comieron arriba y abajo");
				b=true;
			}
		} if(y>=2 && y<=limY-2){
			if(getPos(x,y-1)==s && getPos(x,y+1)==s){
				System.out.println("Me comieron der e izq");
				b=true;
			}
		}
		return b;
	}


	void limpiar(){
		fichas.limpiar();
	}

	public Iterator<Integer> getCoordX(){
		return fichas.getCoordX();
	}
	
	public Iterator<Integer> getCoordY(){
		return fichas.getCoordY();
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
	class Fichas{
		List<Integer> pX, pY;
		Fichas(){
			pX = new ArrayList<Integer>();
			pY = new ArrayList<Integer>();
		}
		void agregar(int x, int y){
			pX.add(x);
			pY.add(y);
		}
		Iterator<Integer> getCoordX(){
			return pX.iterator();
		}
		Iterator<Integer> getCoordY(){
			return pY.iterator();
		}
		void limpiar(){
			pX.clear();
			pY.clear();
		}
	}


}

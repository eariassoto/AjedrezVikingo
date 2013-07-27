import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;


public class ManejadorFichas {
	
	Fichas fichas;
	ManejadorTablero manejadorTablero;
	final int LIMITE, CENTRO;
	
	public ManejadorFichas(int LIMITE, ManejadorTablero manejadorTablero){
		this.LIMITE = LIMITE;
		this.CENTRO = (LIMITE-1)/2;
		fichas = new Fichas();
		this.manejadorTablero = manejadorTablero;
	}
	
	public boolean btnConIcono(JButton boton){
		if(boton.getIcon() != null){
			return true;
		}else{
			return false;
		}
	}


	public boolean btnEsBlanco(int x, int y){
		if(manejadorTablero.getPos(x,y) == "sueco"){
			return true;
		}else if(manejadorTablero.getPos(x,y) == "rey"){
			return true;
		}else{
			return false;
		}
	}


	public boolean btnEsNegro(int x, int y){
		if(manejadorTablero.getPos(x,y) == "moscovita"){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean recorridoLimpio(int x, int y, int a, int b){
		if(x!=a && y!=b){
			return false;
		}
		if(manejadorTablero.getPos(x,y)!="rey" && a==0 && b == 0){
			return false;
		}else if(manejadorTablero.getPos(x,y)!="rey" && a==0 && b == LIMITE-1){
			return false;
		} else if(manejadorTablero.getPos(x,y)!="rey" && a==LIMITE-1 && b == 0){
			return false;
		} else if(manejadorTablero.getPos(x,y)!="rey" && a==LIMITE-1 && b == LIMITE-1){
			return false;
		} else if(manejadorTablero.getPos(x,y)!="rey" && a==CENTRO && b == CENTRO){
			return false;
		}else{
			try{
				if(x!=a && x>a) {
					for(int i = x-1; i>a; i--){
						if(manejadorTablero.getPos(i,b) == "moscovita" || manejadorTablero.getPos(i,b) == "sueco" || manejadorTablero.getPos(i,b) == "rey"){
							return false;
						}
					}
				} if(x!=a && x<a) {
					for(int i = x+1; i<a; i++){
						if(manejadorTablero.getPos(i,b) == "moscovita" || manejadorTablero.getPos(i,b) == "sueco" || manejadorTablero.getPos(i,b) == "rey"){
							return false;
						}
					}
				} if(y!=b && y>b)	{
					for(int i = y-1; i>b; i--){
						if(manejadorTablero.getPos(a,i) == "moscovita" || manejadorTablero.getPos(a,i) == "sueco" || manejadorTablero.getPos(a,i) == "rey"){
							return false;
						}
					}
				} if(y!=b && y<b) {
					for(int i = y+1; i<b; i++){
						if(manejadorTablero.getPos(a,i) == "tablero" || manejadorTablero.getPos(a,i) == "sueco" || manejadorTablero.getPos(a,i) == "rey")
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
		if(x==0 && y==2 && manejadorTablero.getPos(0,1)==s){
			fichas.agregar(0, 1);
			b=true;
		} else if(x==0 && y==LIMITE-3 && manejadorTablero.getPos(0,LIMITE-2)==s){
			fichas.agregar(0, LIMITE-2);
			b=true;
		} else if(x==LIMITE-1 && y==2 && manejadorTablero.getPos(LIMITE-1,1)==s){
			fichas.agregar(LIMITE-1, 1);
			b=true;
		} else if(x==LIMITE-1 && y==LIMITE-3 && manejadorTablero.getPos(LIMITE-1,LIMITE-2)==s){
			fichas.agregar(LIMITE-1, LIMITE-2);
			b=true;
		} else if(x==2 && y==0 && manejadorTablero.getPos(1,0)==s){
			fichas.agregar(1, 0);
			b=true;
		} else if(x==LIMITE-3 && y==0 && manejadorTablero.getPos(LIMITE-2,0)==s){
			fichas.agregar(LIMITE-2, 0);
			b=true;
		} else if(x==2 && y==LIMITE-1 && manejadorTablero.getPos(1,LIMITE-1)==s){
			fichas.agregar(1, LIMITE-1);
			b=true;
		} else if(x==LIMITE-3 && y==LIMITE-1 && manejadorTablero.getPos(LIMITE-2,LIMITE-1)==s){
			fichas.agregar(LIMITE-2, LIMITE-1);
			b=true;
		}
		//limites
		if(x>=2){ 
			if(manejadorTablero.getPos(x-2,y)==p && manejadorTablero.getPos(x-1,y)==s){
				fichas.agregar(x-1, y);
				b=true;
			}
		} if(x<=LIMITE-3){
			if(manejadorTablero.getPos(x+2,y)==p && manejadorTablero.getPos(x+1,y)==s){
				fichas.agregar(x+1, y);
				b=true;
			}
		} if(y>=2){
			if(manejadorTablero.getPos(x,y-2)==p && manejadorTablero.getPos(x,y-1)==s){
				fichas.agregar(x, y-1);
				b=true;
			}
		} if(y<=LIMITE-3){
			if(manejadorTablero.getPos(x,y+2)==p && manejadorTablero.getPos(x,y+1)==s){
				fichas.agregar(x, y+1);
				b=true;
			}
		}
		return b;
	}
	
	public Iterator<Integer> getCoordX(){
		return fichas.getCoordX();
	}
	
	public Iterator<Integer> getCoordY(){
		return fichas.getCoordY();
	}
	void limpiar(){
		fichas.limpiar();
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;


public class ManejadorFichas {
	
	Fichas fichas;
	ManejadorTablero manejadorTablero;
	int limite, centro;
	
	public ManejadorFichas(ManejadorTablero manejadorTablero){
		fichas = new Fichas();
		this.manejadorTablero = manejadorTablero;
	}
	
	public void setLimite(int limite){
		this.limite = limite;
		this.centro = (limite-1)/2;
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
	
	public boolean recorridoLimpio(int x, int y, int a, int b, boolean restriccion){
		if(x!=a && y!=b){
			return false;
		}
		if(manejadorTablero.getPos(x,y)!="rey" && a==0 && b == 0){
			return false;
		}else if(manejadorTablero.getPos(x,y)!="rey" && a==0 && b == limite-1){
			return false;
		} else if(manejadorTablero.getPos(x,y)!="rey" && a==limite-1 && b == 0){
			return false;
		} else if(manejadorTablero.getPos(x,y)!="rey" && a==limite-1 && b == limite-1){
			return false;
		} else if(manejadorTablero.getPos(x,y)!="rey" && a==centro && b == centro){
			return false;
		}else{
			try{
				if(x!=a && x>a) {
					for(int i = x-1; i>a; i--){
						if(manejadorTablero.getPos(i,b) == "moscovita" || manejadorTablero.getPos(i,b) == "sueco" || manejadorTablero.getPos(i,b) == "rey" || (restriccion && manejadorTablero.getPos(x, y)!="rey" && i==centro && b==centro)){
							return false;
						}
					}
				} if(x!=a && x<a) {
					for(int i = x+1; i<a; i++){
						if(manejadorTablero.getPos(i,b) == "moscovita" || manejadorTablero.getPos(i,b) == "sueco" || manejadorTablero.getPos(i,b) == "rey" || (restriccion && manejadorTablero.getPos(x, y)!="rey" && i==centro && b==centro)){
							return false;
						}
					}
				} if(y!=b && y>b)	{
					for(int i = y-1; i>b; i--){
						if(manejadorTablero.getPos(a,i) == "moscovita" || manejadorTablero.getPos(a,i) == "sueco" || manejadorTablero.getPos(a,i) == "rey" || (restriccion && manejadorTablero.getPos(x, y)!="rey" && a==centro && i==centro)){
							return false;
						}
					}
				} if(y!=b && y<b) {
					for(int i = y+1; i<b; i++){
						if(manejadorTablero.getPos(a,i) == "tablero" || manejadorTablero.getPos(a,i) == "sueco" || manejadorTablero.getPos(a,i) == "rey" || (restriccion && manejadorTablero.getPos(x, y)!="rey" && a==centro && i==centro))
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
		} else if(x==0 && y==limite-3 && manejadorTablero.getPos(0,limite-2)==s){
			fichas.agregar(0, limite-2);
			b=true;
		} else if(x==limite-1 && y==2 && manejadorTablero.getPos(limite-1,1)==s){
			fichas.agregar(limite-1, 1);
			b=true;
		} else if(x==limite-1 && y==limite-3 && manejadorTablero.getPos(limite-1,limite-2)==s){
			fichas.agregar(limite-1, limite-2);
			b=true;
		} else if(x==2 && y==0 && manejadorTablero.getPos(1,0)==s){
			fichas.agregar(1, 0);
			b=true;
		} else if(x==limite-3 && y==0 && manejadorTablero.getPos(limite-2,0)==s){
			fichas.agregar(limite-2, 0);
			b=true;
		} else if(x==2 && y==limite-1 && manejadorTablero.getPos(1,limite-1)==s){
			fichas.agregar(1, limite-1);
			b=true;
		} else if(x==limite-3 && y==limite-1 && manejadorTablero.getPos(limite-2,limite-1)==s){
			fichas.agregar(limite-2, limite-1);
			b=true;
		}
		//limites
		if(x>=2){ 
			if(manejadorTablero.getPos(x-2,y)==p && manejadorTablero.getPos(x-1,y)==s){
				fichas.agregar(x-1, y);
				b=true;
			}
		} if(x<=limite-3){
			if(manejadorTablero.getPos(x+2,y)==p && manejadorTablero.getPos(x+1,y)==s){
				fichas.agregar(x+1, y);
				b=true;
			}
		} if(y>=2){
			if(manejadorTablero.getPos(x,y-2)==p && manejadorTablero.getPos(x,y-1)==s){
				fichas.agregar(x, y-1);
				b=true;
			}
		} if(y<=limite-3){
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

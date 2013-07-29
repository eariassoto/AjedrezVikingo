
public class ManejadorRey {

	ManejadorTablero manejadorTablero;
	int limite,centro;
	int encasillado;
	int[] limitesRey;

	public ManejadorRey(ManejadorTablero manejadorTablero){
		this.manejadorTablero = manejadorTablero;
		limitesRey = new int[4];
	}
	
	public void setLimite(int limite){
		this.limite = limite;
		this.centro = (limite-1)/2;
	}

	public int verificarEstado(){
		verificarLimites();
		int j = verificarJaques();
		if(verificarEsquinas()){
			return 1;
		} else if(encasillado == 4){
			return 2;
		} else if(encasillado == 3){
			if(verificarPeligro()){
				if(j==1){	
					return 3;
				} else{
					return 4;
				}
			}
		}else{
			if(j==1){
				return 5;
			} else if(j==2){
				return 6;
			}
		} 
		return 0;
	}
	
	boolean verificarEsquinas(){
		if(manejadorTablero.getPos(0, 0)=="rey" || manejadorTablero.getPos(0, limite-1)=="rey"|| manejadorTablero.getPos(limite-1, 0)=="rey"|| manejadorTablero.getPos(limite-1, limite-1)=="rey"){
			return true;
		} else {
			return false;
		}
	}
	
	void verificarLimites(){
		int[] posRey = buscarRey();
		encasillado = 0;
		limitesRey = new int[4];
		//esquinas
		if((posRey[0]==0 && posRey[1]==limite-2) || (posRey[0]==limite-1 && posRey[1]==limite-2)){
			limitesRey[0] = 1;
		} else if((posRey[0]==0 && posRey[1]==1) || (posRey[0]==limite-1 && posRey[1]==1)){ 
			limitesRey[1] = 1;
		} else if((posRey[0]==1 && posRey[1]==0) || (posRey[0]==1 && posRey[1]==limite-1) ){
			limitesRey[2] = 1;
		} else if((posRey[0]==limite-2 && posRey[1]==0) || (posRey[0]==limite-2 && posRey[1]==limite-1)){
			limitesRey[3] = 1;
		}
		//derecha
		if(posRey[1]==limite-1){
			limitesRey[0] = 1;
		} else if(posRey[0] == centro && posRey[1] == centro-1){
			limitesRey[0] = 1;
		} else if(posRey[1]<=limite-3 && manejadorTablero.getPos(posRey[0], posRey[1]+1)=="sueco" && manejadorTablero.getPos(posRey[0], posRey[1]+2)=="moscovita"){
			limitesRey[0] = 1;
		} else if(posRey[1]<=limite-2 && manejadorTablero.getPos(posRey[0], posRey[1]+1)=="moscovita"){
			limitesRey[0] = 1;
		} 
		//izquierda
		if(posRey[1]==0){
			limitesRey[1] = 1;
		} else if(posRey[0] == centro && posRey[1] == centro+1){
			limitesRey[1] = 1;
		} else if(posRey[1]>=2 && manejadorTablero.getPos(posRey[0], posRey[1]-1)=="sueco" && manejadorTablero.getPos(posRey[0], posRey[1]-2)=="moscovita"){
			limitesRey[1] = 1;
		} else if(posRey[1]>=1 && manejadorTablero.getPos(posRey[0], posRey[1]-1)=="moscovita"){
			limitesRey[1] = 1;
		}
		//arriba
		if(posRey[0]==0){
			limitesRey[2] = 1;
		} else if(posRey[0] == centro+1 && posRey[1] == centro){
			limitesRey[2] = 1;
		} else if(posRey[0]>=2 && manejadorTablero.getPos(posRey[0]-1, posRey[1])=="sueco" && manejadorTablero.getPos(posRey[0]-2, posRey[1])=="moscovita"){
			limitesRey[2] = 1;
		} else if(posRey[0]>=1 && manejadorTablero.getPos(posRey[0]-1, posRey[1])=="moscovita"){
			limitesRey[2] = 1;
		}
		//abajo
		if(posRey[0]==limite-1){
			limitesRey[3] = 1;
		} else if(posRey[0] == centro-1 && posRey[1] == centro){
			limitesRey[3] = 1;
		} else if(posRey[0]<=limite-3 && manejadorTablero.getPos(posRey[0]+1, posRey[1])=="sueco" && manejadorTablero.getPos(posRey[0]+2, posRey[1])=="moscovita"){
			limitesRey[3] = 1;
		} else if(posRey[0]<=limite-2 && manejadorTablero.getPos(posRey[0]+1, posRey[1])=="moscovita"){
			limitesRey[3] = 1;
		}
		for(int i=0;i<limitesRey.length;i++){
			encasillado += limitesRey[i];
		}
	}
	
	
	boolean verificarPeligro(){
		int x=0,y=0,w=0,l = 0;
		int[] posRey = buscarRey();
		for(int i=0;i<limitesRey.length;i++){
			if(limitesRey[i]==0){
				l = i;
			}
		}
		switch(l){
		//derecha
		case 0:
			x = posRey[0];
			y = posRey[1]+1;
			
			w=x;
			while(w>=0 && manejadorTablero.getPos(w, y)!="sueco"){
				String s = manejadorTablero.getPos(w, y);
				if(s=="moscovita"){
					return true;
				}
				w--;
			}
			w=x;
			while(w<=limite-1 && manejadorTablero.getPos(w, y)!="sueco"){
				String s = manejadorTablero.getPos(w, y);
				if(s=="moscovita"){
					return true;
				}
				w++;
			}
			w = y; 
			while(w<=limite-1 && manejadorTablero.getPos(x, w)!="sueco"){
				String s = manejadorTablero.getPos(x, w);
				if(s=="moscovita"){
					return true;
				}
				w++;
			}
			break;
		//izquierda
		case 1:
			x = posRey[0];
			y = posRey[1]-1;
			
			w = y; 
			while(w>=0 && manejadorTablero.getPos(x, w)!="sueco"){
				String s = manejadorTablero.getPos(x, w);
				if(s=="moscovita"){
					return true;
				}
				w--;
			}
			w=x;
			while(w>=0 && manejadorTablero.getPos(w, y)!="sueco"){
				String s = manejadorTablero.getPos(w, y);
				if(s=="moscovita"){
					return true;
				}
				w--;
			}
			w=x;
			while(w<=limite-1 && manejadorTablero.getPos(w, y)!="sueco"){
				String s = manejadorTablero.getPos(w, y);
				if(s=="moscovita"){
					return true;
				}
				w++;
			}
			break;
		//arriba
		case 2:
			x = posRey[0]-1;
			y = posRey[1];
			
			w = y; 
			while(w>=0 && manejadorTablero.getPos(x, w)!="sueco"){
				String s = manejadorTablero.getPos(x, w);
				if(s=="moscovita"){
					return true;
				}
				w--;
			}
			w=x;
			while(w>=0 && manejadorTablero.getPos(w, y)!="sueco"){
				String s = manejadorTablero.getPos(w, y);
				if(s=="moscovita"){
					return true;
				}
				w--;
			}
			w = y; 
			while(w<=limite-1 && manejadorTablero.getPos(x, w)!="sueco"){
				String s = manejadorTablero.getPos(x, w);
				if(s=="moscovita"){
					return true;
				}
				w++;
			}
			break;
		//abajo
		case 3:
			x = posRey[0]+1;
			y = posRey[1];
			
			w = y; 
			while(w>=0 && manejadorTablero.getPos(x, w)!="sueco"){
				String s = manejadorTablero.getPos(x, w);
				if(s=="moscovita"){
					System.out.println(x+" "+w);
					return true;
				}
				w--;
			}
			w=x;
			while(w<=limite-1 && manejadorTablero.getPos(w, y)!="sueco"){
				String s = manejadorTablero.getPos(w, y);
				if(s=="moscovita"){
					System.out.println(x+" "+w);
					return true;
				}
				w++;
			}
			w = y; 
			while(w<=limite-1 && manejadorTablero.getPos(x, w)!="sueco"){
				String s = manejadorTablero.getPos(x, w);
				if(s=="moscovita"){
					System.out.println(x+" "+w);
					return true;
				}
				w++;
			}
			break;
		}
		return false;
	}
	
	int verificarJaques(){
		int[] posRey = buscarRey();
		int j = 0;
		if(posRey[0]==0 || posRey[0]==limite-1){
			j = buscarJaque(posRey[0], posRey[1],0); 
		} else if(posRey[1]==0 || posRey[1]==limite-1){
			j = buscarJaque(posRey[0], posRey[1],1); 
		}
		return j;
	}

	int buscarJaque(int x, int y,int a){
		int i=0,c=0,j=0;
		switch(a){
		case 0:
			i=y+1;
			c = 0;
			while(i<=limite-2){
				String s = manejadorTablero.getPos(x, i);
				if(s=="" || s==null){
					c++;
				}
				i++;
			}if(c==(limite-2)-y){
				j++;
			}
			i = y-1;
			c=0;
			while(i>=1){
				String s = manejadorTablero.getPos(x, i);
				if(s=="" || s==null){
					c++;
				}
				i--;
			} if(c==y-1){
				j++;
			}
			break;
		case 1:
			i=x+1;
			c = 0;
			while(i<=limite-2){
				String s = manejadorTablero.getPos(i, y);
				if(s=="" || s==null){
					c++;
				}
				i++;
			}if(c==(limite-2)-x){
				j++;
			}
			i = x-1;
			c=0;
			while(i>=1){
				String s = manejadorTablero.getPos(i, y);
				if(s=="" || s==null){
					c++;
				}
				i--;
			} if(c==x-1){
				j++;
			}
			break;
		}
		return j;
	}

	public int[] buscarRey(){
		int x=-1, y=-1;
		for(int i = 0; i<=limite-1;i++){
			for(int j=0; j<=limite-1;j++){
				if(manejadorTablero.getPos(i,j)=="rey"){
					x=i;
					y=j;
				}
			}
		}
		return new int[]{x,y};
	}
}


public class ManejadorRey {

	ManejadorTablero manejadorTablero;
	int limX, limY,centro;

	public ManejadorRey(int limX, int limY, ManejadorTablero manejadorTablero){
		this.limX = limX;
		this.limY = limY;
		this.centro = (limX-1)/2;
		this.manejadorTablero = manejadorTablero;
	}
	public boolean verificarRey(){
		int[] posRey = buscarRey();
		int encasillado = 0;
		//esquinas
		if( (posRey[0]==0 && posRey[1]==1)
				|| (posRey[0]==0 && posRey[1]==limY-2) 
				|| (posRey[0]==limX-1 && posRey[1]==1) 
				|| (posRey[0]==limX-1 && posRey[1]==limY-2) 
				|| (posRey[0]==1 && posRey[1]==0) 
				|| (posRey[0]==1 && posRey[1]==limY-1) 
				|| (posRey[0]==limX-2 && posRey[1]==0) 
				|| (posRey[0]==limX-2 && posRey[1]==limY-1)){
			encasillado++;
		}
		//derecha
		if(posRey[1]==limY-1){
			encasillado++;
		} else if(posRey[0] == centro && posRey[1] == centro-1){
			encasillado++;
		} else if(posRey[1]<=limY-3 && manejadorTablero.getPos(posRey[0], posRey[1]+1)=="sueco" && manejadorTablero.getPos(posRey[0], posRey[1]+2)=="moscovita"){
			encasillado++;
		} else if(posRey[1]<=limY-2 && manejadorTablero.getPos(posRey[0], posRey[1]+1)=="moscovita"){
			encasillado++;
		} 
		//izquierda
		if(posRey[1]==0){
			encasillado++;
		} else if(posRey[0] == centro && posRey[1] == centro+1){
			encasillado++;
		} else if(posRey[1]>=2 && manejadorTablero.getPos(posRey[0], posRey[1]-1)=="sueco" && manejadorTablero.getPos(posRey[0], posRey[1]-2)=="moscovita"){
			encasillado++;
		} else if(posRey[1]>=1 && manejadorTablero.getPos(posRey[0], posRey[1]-1)=="moscovita"){
			encasillado++;
		}
		//arriba
		if(posRey[0]==0){
			encasillado++;
		} else if(posRey[0] == centro+1 && posRey[1] == centro){
			encasillado++;
		} else if(posRey[0]>=2 && manejadorTablero.getPos(posRey[0]-1, posRey[1])=="sueco" && manejadorTablero.getPos(posRey[0]-2, posRey[1])=="moscovita"){
			encasillado++;
		} else if(posRey[0]>=1 && manejadorTablero.getPos(posRey[0]-1, posRey[1])=="moscovita"){
			encasillado++;
		}
		//abajo
		if(posRey[0]==limX-1){
			encasillado++;
		} else if(posRey[0] == centro-1 && posRey[1] == centro){
			encasillado++;
		} else if(posRey[0]<=limX-3 && manejadorTablero.getPos(posRey[0]+1, posRey[1])=="sueco" && manejadorTablero.getPos(posRey[0]+2, posRey[1])=="moscovita"){
			encasillado++;
		} else if(posRey[0]<=limX-2 && manejadorTablero.getPos(posRey[0]+1, posRey[1])=="moscovita"){
			encasillado++;
		}

		if(encasillado == 4){
			return true;
		}
		else{
			return false;
		}
	}

	public int[] buscarRey(){
		int x=-1, y=-1;
		for(int i = 0; i<=limX-1;i++){
			for(int j=0; j<=limY-1;j++){
				if(manejadorTablero.getPos(i,j)=="rey"){
					x=i;
					y=j;
				}
			}
		}
		return new int[]{x,y};
	}
}

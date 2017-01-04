public class Peak {
	
	public Peak(){
	}
	
	public int OneDRecursive(int[] d1){
		return OneDRecursive(d1, d1.length, 0, d1.length-1);
	}
	public int OneDRecursive(int[] d1, int dlen, int low, int up){
		int i = ((up+low)%2==0)?(up+low)/2:(up+low)/2+1;
		
		if(dlen == 0){
			return 0;
		}
		else if(i == dlen-1){
			return OneDRecursive(d1, dlen, 0, d1.length/2);
		}
		else if(d1[i] > d1[i-1] && d1[i] > d1[i+1]){
			return d1[i];
		}
		//Move right
		else if(d1[i] >= d1[i-1] && d1[i] <= d1[i+1]){
			return OneDRecursive(d1, dlen, i+1, up);
		}
		//Move left
		else if(d1[i] <= d1[i-1] && d1[i] >= d1[i+1]){
			return OneDRecursive(d1, dlen, low, i-1);
		}
		return d1[i];
	}
	
	public int TwoDRecursive(int[][] dd){
		int col = dd.length;
		int max = 0;
		int column = 0;
		return TwoDRecursive(dd,col,max,column);
	}
	
	public int TwoDRecursive(int[][] dd, int col, int max, int j){
		int ODPeak = TwoDRecursive(dd,j,0,col-1,col);
		
		if(ODPeak > max){
			max = ODPeak;
		}
		
		if(j < (col-1)){
			return TwoDRecursive(dd,col,max,j+1);
		}
		
		return max;
	}
	
	public int TwoDRecursive(int[][] dd, int j, int low, int up,int ddlen){
		int i = ((up+low)%2==0)?(up+low)/2:(up+low)/2+1;
		if(ddlen == 0){
			return 0;
		}
		else if(i == ddlen-1){
			return TwoDRecursive(dd, j, 0, ddlen/2, ddlen);
		}
		else if(dd[i][j] > dd[i-1][j] && dd[i][j] > dd[i+1][j]){
			return dd[i][j];
		}
		else if(dd[i][j] >= dd[i-1][j] && dd[i][j] <= dd[i+1][j]){
			//move down
			return TwoDRecursive(dd, j, i+1, up, ddlen);
		}
		else if(dd[i][j] <= dd[i-1][j] && dd[i][j] >= dd[i+1][j]){
			//move up
			return TwoDRecursive(dd, j, low, i-1, ddlen);
		}
		return dd[i][j];
	}
}
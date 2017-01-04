
public class LaboratorioUno {
	public LaboratorioUno(){
		
	}
	//enAscendente
	public void enAscendente(int n){
		if(n>=0){
			enAscendente(n-1);
			System.out.println(n);
		}
	}
	//enDescendente
	public void enDescendente(int n){
		if(n>=0){
			System.out.println(n);
			enDescendente(n-1);
		}
	}
	//divisionporRestas
	public int divisionporRestas(int divisor, int dividendo){
		int suma = 0;
		return divisionporRestas(divisor,dividendo,suma);
	}
	public int divisionporRestas(int divisor, int dividendo, int suma){
		if(dividendo-divisor >= 0){
			suma++;
			return divisionporRestas(divisor, dividendo-divisor,suma);
		}
		return suma;
	}
	//sumaHarmonica
	public double sumaHarmonica(int n){
		if(n == 1){
			return 1;
		}
		else{
			return 1.0/n + sumaHarmonica(n-1);
		}
	}
	
	//cuentaCuantas
	public int cuentaCuantas(String string, char c){
		int sumar = 0;
		if(string.charAt(0) == c){
			sumar = 1;
		}
		
		if(string.length() == 1){
			return sumar;
		}
		else{
			return sumar + cuentaCuantas(string.substring(1),c);
		}
	}
	
	
}

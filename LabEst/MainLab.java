
public class MainLab {
	public static void main(String[] args){
		LaboratorioUno m = new LaboratorioUno();
		
		m.enDescendente(3);
		m.enAscendente(4);
		
		System.out.println(m.divisionporRestas(2, 4));
		
		System.out.println(m.sumaHarmonica(2));
		System.out.println(m.cuentaCuantas("holah", 'h'));
	}
}

import javax.swing.JOptionPane;

public class Picerija {

	public static void main(String[] args) {
		
		String[] opcijas = {"Ievad�t kontaktdatus","Uztais�t picu","Apskat�t akt�vos pas�t�jumus","Iziet no programmas"};
		String izvele;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Picas pas�t��anas sist�ma", "Pic�rija", JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			switch(izvele){
				
			case "Ievad�t kontaktdatus":
				
				break;
				
			case "Uztais�t picu":
				
				break;
				
			case "Apskat�t akt�vos pas�t�jumus":
				
				break;
				
			case "Iziet no programmas":
				
				break;
			
			}
			
		}while(!izvele.equalsIgnoreCase("Iziet no programmas"));
	}

}

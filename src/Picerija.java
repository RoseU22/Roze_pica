import javax.swing.JOptionPane;

public class Picerija {

	static String fNosaukums;
	
	static void IevaditKontaktDatus(){
		String adrese, vards, uzvards;
		int talrunis;
		
		adrese = JOptionPane.showInputDialog("Ievadi personas adresi:");
		vards = JOptionPane.showInputDialog("Ievadi personas v�rdu:");
		uzvards = JOptionPane.showInputDialog("Ievadi personas uzv�rdu:");
		talrunis = Integer.parseInt(JOptionPane.showInputDialog("Ievadi personas t�lruni:"));
		
	}
	
	public static void main(String[] args) {
		
		String[] opcijas = {"Ievad�t kontaktdatus","Uztais�t picu","Apskat�t akt�vos pas�t�jumus","Iziet no programmas"};
		String izvele;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Picas pas�t��anas sist�ma", "Pic�rija", JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			switch(izvele){
				
			case "Ievad�t kontaktdatus":
				IevaditKontaktDatus();
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

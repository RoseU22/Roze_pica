import javax.swing.JOptionPane;

public class Picerija {

	static String fNosaukums;
	
	static void IevaditKontaktDatus(){
		String adrese, vards, uzvards;
		int talrunis;
		
		adrese = JOptionPane.showInputDialog("Ievadi personas adresi:");
		vards = JOptionPane.showInputDialog("Ievadi personas vârdu:");
		uzvards = JOptionPane.showInputDialog("Ievadi personas uzvârdu:");
		talrunis = Integer.parseInt(JOptionPane.showInputDialog("Ievadi personas tâlruni:"));
		
	}
	
	public static void main(String[] args) {
		
		String[] opcijas = {"Ievadît kontaktdatus","Uztaisît picu","Apskatît aktîvos pasûtîjumus","Iziet no programmas"};
		String izvele;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Picas pasûtîðanas sistçma", "Picçrija", JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			switch(izvele){
				
			case "Ievadît kontaktdatus":
				IevaditKontaktDatus();
				break;
				
			case "Uztaisît picu":
				
				break;
				
			case "Apskatît aktîvos pasûtîjumus":
				
				break;
				
			case "Iziet no programmas":
				
				break;
			
			}
			
		}while(!izvele.equalsIgnoreCase("Iziet no programmas"));
	}

}

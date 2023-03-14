import javax.swing.JOptionPane;

public class Picerija {

	public static void main(String[] args) {
		
		String[] opcijas = {"Ievadît kontaktdatus","Uztaisît picu","Apskatît aktîvos pasûtîjumus","Iziet no programmas"};
		String izvele;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Picas pasûtîðanas sistçma", "Picçrija", JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			switch(izvele){
				
			case "Ievadît kontaktdatus":
				
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

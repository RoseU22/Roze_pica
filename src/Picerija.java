import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Picerija {

	static String fNosaukums;
	
	
	static void saglabat(String adrese, String vards, String uzvards, int talrunis){
		fNosaukums = JOptionPane.showInputDialog("Kur glabâsiet kontaktdatus?");
		
		try{
			FileWriter fw = new FileWriter(fNosaukums+".txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(vards+" "+uzvards+": "+adrese+", "+talrunis);
			pw.close();
			JOptionPane.showMessageDialog(null, "Veiksmîgi tika ierakstîti kontaktdati!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Râdâs kïûda saglabâjot kontaktdatus!");
		}
	}
	
	static void apskatitPasutijumus(){
		String teksts, str="";
		
		try{
			FileReader fr = new FileReader(fNosaukums+".txt");
			BufferedReader br = new BufferedReader(fr);
			while((teksts=br.readLine()) != null){
				str += teksts+"\n";
			}
			br.close();
			JOptionPane.showMessageDialog(null, str, "Saturs", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Râdâs kïûda nolasot kontaktdatus");
		}
	}
	
	static void IevaditKontaktDatus(){
		String adrese, vards, uzvards;
		int talrunis;
		
		adrese = JOptionPane.showInputDialog("Ievadi personas adresi:");
		vards = JOptionPane.showInputDialog("Ievadi personas vârdu:");
		uzvards = JOptionPane.showInputDialog("Ievadi personas uzvârdu:");
		talrunis = Integer.parseInt(JOptionPane.showInputDialog("Ievadi personas tâlruni:"));
		
		saglabat(adrese, vards, uzvards, talrunis);
		
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
				apskatitPasutijumus();
				break;
				
			case "Iziet no programmas":
				JOptionPane.showMessageDialog(null, "Programma tika apturçta!");
				break;
			
			}
			
		}while(!izvele.equalsIgnoreCase("Iziet no programmas"));
	}

}

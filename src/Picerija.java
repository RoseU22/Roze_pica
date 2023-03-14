import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Picerija {

	static String fNosaukums;
	
	
	static void saglabat(String adrese, String vards, String uzvards, int talrunis){
		fNosaukums = JOptionPane.showInputDialog("Kur glab�siet kontaktdatus?");
		
		try{
			FileWriter fw = new FileWriter(fNosaukums+".txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(vards+" "+uzvards+": "+adrese+", "+talrunis);
			pw.close();
			JOptionPane.showMessageDialog(null, "Veiksm�gi tika ierakst�ti kontaktdati!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "R�d�s k��da saglab�jot kontaktdatus!");
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
			JOptionPane.showMessageDialog(null, "R�d�s k��da nolasot kontaktdatus");
		}
	}
	
	static void IevaditKontaktDatus(){
		String adrese, vards, uzvards;
		int talrunis;
		
		adrese = JOptionPane.showInputDialog("Ievadi personas adresi:");
		vards = JOptionPane.showInputDialog("Ievadi personas v�rdu:");
		uzvards = JOptionPane.showInputDialog("Ievadi personas uzv�rdu:");
		talrunis = Integer.parseInt(JOptionPane.showInputDialog("Ievadi personas t�lruni:"));
		
		saglabat(adrese, vards, uzvards, talrunis);
		
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
				apskatitPasutijumus();
				break;
				
			case "Iziet no programmas":
				JOptionPane.showMessageDialog(null, "Programma tika aptur�ta!");
				break;
			
			}
			
		}while(!izvele.equalsIgnoreCase("Iziet no programmas"));
	}

}

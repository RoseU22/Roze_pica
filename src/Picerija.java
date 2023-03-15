import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Picerija {

	static String fNosaukums;
	
	
	static void saglabat(JTextField Adrese, JTextField Vards, JTextField Uzvards, JTextField Talrunis, JTextField PicasLielums, JTextField Merce, int[] IzveletasOpcijas){
		fNosaukums = JOptionPane.showInputDialog("Kur glab�siet kontaktdatus?");
		
		try{
			FileWriter fw = new FileWriter(fNosaukums+".txt", true);
			PrintWriter pw = new PrintWriter(fw);
			//pw.println(vards+" "+uzvards+": "+adrese+", "+talrunis);
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
	
	static void UztaisitPicu(){
		JTextField Adrese = new JTextField();
		JTextField Vards = new JTextField();
		JTextField Uzvards = new JTextField();
		JTextField Talrunis = new JTextField();
		JTextField PicasLielums = new JTextField();
		JTextField Merce = new JTextField();
		
		Object[] Kontaktdati = {
				"Adrese: ", Adrese,
				"V�rds: ", Vards,
				"Uzvards: ", Uzvards,
				"Talrunis: ", Talrunis
		};
		
		Object[] Pica = {
				"Izv�lies picas lielumu (1cm = 0.35�): ", PicasLielums,
				"Izv�lies picas m�rci:\nAs� m�rce - 1�\nGur�u m�rce - 1.25�\n�iploku m�rce - 1.15�\nTom�tu-kr�juma m�rce - 1.50�\nKarija m�rce - 1.30�", Merce
		};
		
		JOptionPane.showConfirmDialog(null, Kontaktdati, "Kontaktdati", JOptionPane.OK_CANCEL_OPTION);
		JOptionPane.showConfirmDialog(null, Pica, "Picas tais��ana", JOptionPane.OK_CANCEL_OPTION);
		
		Object[] piedevas = {"Siers",
							 "Bekons",
							 "��i��is",
							 "Vistas fileja",
							 "Malt� ga�a",
							 "Sarkanie s�poli",
							 "�ampinjoni",
							 "Tom�ti",
							 "Paprika"};
		
		double[] Cenas = {2.00,1.50,1.50,1.50,1.30,0.70,0.70,0.70,0.50};
		double summa=0;
		int[] IzveletasOpcijas = new int[piedevas.length];
		
		JPanel panel = new JPanel();
		for(int i=0; i<piedevas.length; i++){
			JCheckBox CBox = new JCheckBox(piedevas[i].toString());
			panel.add(CBox);
		}
		
		int rezultats = JOptionPane.showConfirmDialog(null, panel, "Izv�lies piedevas picai!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(rezultats==JOptionPane.OK_OPTION){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<panel.getComponentCount(); i++){
				if(panel.getComponent(i) instanceof JCheckBox){
					JCheckBox CBox = (JCheckBox) panel.getComponent(i);
					if(CBox.isSelected()){
						sb.append(CBox.getText()).append("\n");
						IzveletasOpcijas[i] = 1;
						summa += Cenas[i];
					}
				}
			}
			
			String teksts = PicasLielums.getText();
			double prece = Double.parseDouble(teksts);
			double cena = ((prece*0.35)+summa*1);
			
			JOptionPane.showMessageDialog(null, "Paldies par pirkumu! J�su maksa par picu: "+cena+"�");
			
			saglabat(Adrese, Vards, Uzvards, Talrunis, PicasLielums, Merce, IzveletasOpcijas);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		String[] opcijas = {"Uztais�t picu","Apskat�t akt�vos pas�t�jumus","Iziet no programmas"};
		String izvele;
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null, "Picas pas�t��anas sist�ma", "Pic�rija", JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			switch(izvele){
				
			case "Uztais�t picu":
				UztaisitPicu();
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

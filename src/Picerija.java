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
	
	
	static void saglabat(JTextField Adrese, JTextField Vards, JTextField Uzvards, JTextField Talrunis, JTextField PicasLielums, int[] IzveletasOpcijas, int[] IzvOpcijas, int OpcijasIzvele){
		fNosaukums = JOptionPane.showInputDialog("Kur glab�siet kontaktdatus?");
		int[] ir = new int[IzveletasOpcijas.length];
		int[] ir2 = new int[IzvOpcijas.length];
		int summa = 0, summa2 = 0;
		
		try{
			FileWriter fw = new FileWriter(fNosaukums+".txt", true);
			PrintWriter pw = new PrintWriter(fw);
			if(OpcijasIzvele == 0){
				
			pw.println(" - "+Vards.getText()+" "+Uzvards.getText()+" (+371 "+Talrunis.getText()+"):  "+Adrese.getText());
			pw.print("Pas�t�jums (Pieg�de): "+PicasLielums.getText()+"cm pica ar ");
			
			}else if(OpcijasIzvele == 1){
				pw.println(" - "+Vards.getText()+" "+Uzvards.getText()+":");
				pw.print("Pas�t�jums (Uz vietas): "+PicasLielums.getText()+"cm pica ar ");
			}
			for(int i=0; i<IzvOpcijas.length; i++){
				ir2[i] = IzvOpcijas[i];
				summa2 += ir2[i];
			}
			if(summa2>=1)
				pw.println(" izv�l�t�m m�rc�m, ");
			
			for(int i=0; i<IzveletasOpcijas.length; i++){
				ir[i] = IzveletasOpcijas[i];
				summa += ir[i];
			}
			if(summa>=1)
				pw.println(" izv�l�t�m piedev�m");
			pw.println();
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
			JOptionPane.showMessageDialog(null, str, "Kontaktdati", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "R�d�s k��da nolasot kontaktdatus");
		}
	}
	
	static void UztaisitPicu(){
		
		double cena = 0;
		double piegade = 0;
		
		JTextField Adrese = new JTextField();
		JTextField Vards = new JTextField();
		JTextField Uzvards = new JTextField();
		JTextField Talrunis = new JTextField();
		JTextField PicasLielums = new JTextField();
		
		String[] opcijas = {"Pieg�de - 1.25�","Sa�emt uz vietas"};
		
		int OpcijasIzvele = JOptionPane.showOptionDialog(null, "K�du veidu picas sa�em�anai gribi?", "Izv�le", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
		
		if(OpcijasIzvele == 0){
			
		
		
		Object[] Kontaktdati = {
				"Adrese: ", Adrese,
				"V�rds: ", Vards,
				"Uzvards: ", Uzvards,
				"Talrunis: ", Talrunis
		};
		
		JOptionPane.showConfirmDialog(null, Kontaktdati, "Kontaktdati", JOptionPane.OK_CANCEL_OPTION);
		piegade += 1.25;
		
		}else if(OpcijasIzvele==1){
			
		Object[] KontaktdatiUzVietas = {"V�rds: ",Vards,
										"Uzv�rds: ", Uzvards};
		
		JOptionPane.showConfirmDialog(null, KontaktdatiUzVietas, "Kontaktdati", JOptionPane.OK_CANCEL_OPTION);
		}
		Object[] Pica = {
				"Izv�lies picas lielumu (1cm = 0.30�): ", PicasLielums,
		};
		
		JOptionPane.showConfirmDialog(null, Pica, "Picas tais��ana", JOptionPane.OK_CANCEL_OPTION);
		
		Object[] piedevas = {"Siers - 2.00�",
							 "Bekons - 1.50�",
							 "��i��is - 1.50�",
							 "Vistas fileja - 1.50�",
							 "Malt� ga�a - 1.30�",
							 "Sarkanie s�poli - 0.70�",
							 "�ampinjoni - 0.70�",
							 "Tom�ti - 0.70�",
							 "Paprika - 0.50�"};
		
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
		    cena = ((prece*0.30)+summa*1);
			
			
		}
		
		Object[] Merces = {"As� m�rce - 1�",
				   "Gur�u m�rce - 1.25�",
			       "�iploku m�rce - 1.15�",
			       "Tom�tu-kr�juma m�rce - 1.50�",
			       "Karija m�rce - 1.30�"};
		double[] Preces = {1.00, 1.25, 1.15, 1.50, 1.30};
		double sum = 0;
		int[] IzvOpcijas = new int[Merces.length];

		JPanel Mercespanel = new JPanel();
		for(int i=0; i<Merces.length; i++){
			JCheckBox CBox1 = new JCheckBox(Merces[i].toString());
			Mercespanel.add(CBox1);
		}
	
		int rezult = JOptionPane.showConfirmDialog(null, Mercespanel, "Izv�lies m�rces!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(rezult==JOptionPane.OK_OPTION){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<Mercespanel.getComponentCount(); i++){
				if(Mercespanel.getComponent(i) instanceof JCheckBox){
					JCheckBox CBox1 = (JCheckBox) Mercespanel.getComponent(i);
					if(CBox1.isSelected()){
						sb.append(CBox1.getText()).append("\n");
						IzvOpcijas[i] = 1;
						sum += Preces[i];
						}
					}
				}
			
			JOptionPane.showMessageDialog(null, "Paldies par pirkumu! J�su maksa par picu: "+(cena+sum+piegade)+"�");
			}
		
			saglabat(Adrese, Vards, Uzvards, Talrunis, PicasLielums, IzveletasOpcijas, IzvOpcijas, OpcijasIzvele);
			
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

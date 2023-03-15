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
		fNosaukums = JOptionPane.showInputDialog("Kur glabâsiet kontaktdatus?");
		int[] ir = new int[IzveletasOpcijas.length];
		int[] ir2 = new int[IzvOpcijas.length];
		int summa = 0, summa2 = 0;
		
		try{
			FileWriter fw = new FileWriter(fNosaukums+".txt", true);
			PrintWriter pw = new PrintWriter(fw);
			if(OpcijasIzvele == 0){
				
			pw.println(" - "+Vards.getText()+" "+Uzvards.getText()+" (+371 "+Talrunis.getText()+"):  "+Adrese.getText());
			pw.print("Pasûtîjums (Piegâde): "+PicasLielums.getText()+"cm pica ar ");
			
			}else if(OpcijasIzvele == 1){
				pw.println(" - "+Vards.getText()+" "+Uzvards.getText()+":");
				pw.print("Pasûtîjums (Uz vietas): "+PicasLielums.getText()+"cm pica ar ");
			}
			for(int i=0; i<IzvOpcijas.length; i++){
				ir2[i] = IzvOpcijas[i];
				summa2 += ir2[i];
			}
			if(summa2>=1)
				pw.println(" izvçlçtâm mçrcçm, ");
			
			for(int i=0; i<IzveletasOpcijas.length; i++){
				ir[i] = IzveletasOpcijas[i];
				summa += ir[i];
			}
			if(summa>=1)
				pw.println(" izvçlçtâm piedevâm");
			pw.println();
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
			JOptionPane.showMessageDialog(null, str, "Kontaktdati", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Râdâs kïûda nolasot kontaktdatus");
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
		
		String[] opcijas = {"Piegâde - 1.25€","Saòemt uz vietas"};
		
		int OpcijasIzvele = JOptionPane.showOptionDialog(null, "Kâdu veidu picas saòemðanai gribi?", "Izvçle", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
		
		if(OpcijasIzvele == 0){
			
		
		
		Object[] Kontaktdati = {
				"Adrese: ", Adrese,
				"Vârds: ", Vards,
				"Uzvards: ", Uzvards,
				"Talrunis: ", Talrunis
		};
		
		JOptionPane.showConfirmDialog(null, Kontaktdati, "Kontaktdati", JOptionPane.OK_CANCEL_OPTION);
		piegade += 1.25;
		
		}else if(OpcijasIzvele==1){
			
		Object[] KontaktdatiUzVietas = {"Vârds: ",Vards,
										"Uzvârds: ", Uzvards};
		
		JOptionPane.showConfirmDialog(null, KontaktdatiUzVietas, "Kontaktdati", JOptionPane.OK_CANCEL_OPTION);
		}
		Object[] Pica = {
				"Izvçlies picas lielumu (1cm = 0.30€): ", PicasLielums,
		};
		
		JOptionPane.showConfirmDialog(null, Pica, "Picas taisîðana", JOptionPane.OK_CANCEL_OPTION);
		
		Object[] piedevas = {"Siers - 2.00€",
							 "Bekons - 1.50€",
							 "Ðíiòíis - 1.50€",
							 "Vistas fileja - 1.50€",
							 "Maltâ gaïa - 1.30€",
							 "Sarkanie sîpoli - 0.70€",
							 "Ðampinjoni - 0.70€",
							 "Tomâti - 0.70€",
							 "Paprika - 0.50€"};
		
		double[] Cenas = {2.00,1.50,1.50,1.50,1.30,0.70,0.70,0.70,0.50};
		double summa=0;
		int[] IzveletasOpcijas = new int[piedevas.length];
		
		JPanel panel = new JPanel();
		for(int i=0; i<piedevas.length; i++){
			JCheckBox CBox = new JCheckBox(piedevas[i].toString());
			panel.add(CBox);
		}
		
		int rezultats = JOptionPane.showConfirmDialog(null, panel, "Izvçlies piedevas picai!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
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
		
		Object[] Merces = {"Asâ mçrce - 1€",
				   "Guríu mçrce - 1.25€",
			       "Íiploku mçrce - 1.15€",
			       "Tomâtu-krçjuma mçrce - 1.50€",
			       "Karija mçrce - 1.30€"};
		double[] Preces = {1.00, 1.25, 1.15, 1.50, 1.30};
		double sum = 0;
		int[] IzvOpcijas = new int[Merces.length];

		JPanel Mercespanel = new JPanel();
		for(int i=0; i<Merces.length; i++){
			JCheckBox CBox1 = new JCheckBox(Merces[i].toString());
			Mercespanel.add(CBox1);
		}
	
		int rezult = JOptionPane.showConfirmDialog(null, Mercespanel, "Izvçlies mçrces!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
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
			
			JOptionPane.showMessageDialog(null, "Paldies par pirkumu! Jûsu maksa par picu: "+(cena+sum+piegade)+"€");
			}
		
			saglabat(Adrese, Vards, Uzvards, Talrunis, PicasLielums, IzveletasOpcijas, IzvOpcijas, OpcijasIzvele);
			
		}
	
	public static void main(String[] args) {
		
		String[] opcijas = {"Uztaisît picu","Apskatît aktîvos pasûtîjumus","Iziet no programmas"};
		String izvele;
		
		do{
			
			izvele = (String)JOptionPane.showInputDialog(null, "Picas pasûtîðanas sistçma", "Picçrija", JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
			
			switch(izvele){
				
			case "Uztaisît picu":
				UztaisitPicu();
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

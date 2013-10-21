package get_kabuka;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Random;

import javax.swing.JTextArea;

public class main_system_conversion extends main_system_input{

	String[][][] p_stockString_set = new String [50][7][60];//p_stockStringの配列
	private int i = 0;
	private String charset = "UTF-8";
	private JTextArea htmlArea;
	private String p_stockString;
	public String getP_stockString(){return p_stockString;}
	public String[][][] getP_stockString_set(){return p_stockString_set;}

	@Override
	public String[][][] set_p_stockString(int p) throws IOException{
		String line;
		htmlArea = new JTextArea();
		URLConnection uc = getUrl().openConnection();
		BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(bis, charset));
		htmlArea.setText("");
		while ((line = br.readLine()) != null) {
				htmlArea.append(line + "\n");
		}
		String text = htmlArea.getText();
//System.out.println(getCode()+"\n\n\n\n");
		int start = text.indexOf("</tr><tr><td>");
		int end = text.lastIndexOf("</td></tr></table>");
	//System.out.println(start +"         " +end);
		p_stockString = text.substring(start , end + 18);
		p_stockString = p_stockString.replace("年", "");
		p_stockString = p_stockString.replace("月", "");
		p_stockString = p_stockString.replace("日", "");
		p_stockString = p_stockString.replace(",", "");


		String gc = getCode();
		if(gc.equals( "998405.T") || gc.equals( "998407.O") || gc.equals("USDJPY%3DX")){
//System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
			i = 5;
		}else{
//System.out.println("bbbbbbbbbbbbbbbbbbbbbbb");
			i = 7;
		}
			for(int x = 0; x < 50; x++){
				for(int y = 0; y < i; y++){
					int a = p_stockString.indexOf("<td>");
					int b = p_stockString.indexOf("</td>");
					p_stockString_set[x][y][p] = p_stockString.substring(a+4, b);
					p_stockString = p_stockString.replaceFirst("<td>"+ p_stockString.substring(a+4, b) +"</td>", "");
//System.out.print(p_stockString_set[x][y] + "\t|");//文字列型の株価表示
//System.out.println(p_stockString);//HTML表示
				}
//System.out.print("\n");//文字列型の株価表示の補助改行
			}
			return p_stockString_set;
	}



	private double[][][] p_stock = new double[50][7][60];
	public double[][][] getP_stock(){return p_stock;}

	@Override
	public double[][][] convert_p_stockString(int p){
System.out.println("\t日付\t||\t始値\t||\t高値\t||\t安値\t||\t終値\t||\t出来高\t||\t調整後終値\tpage:" + p);

		String gc = getCode();
		if(gc.equals( "998405.T") || gc.equals( "998407.O") || gc.equals("USDJPY%3DX")){
//System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
			i = 5;
		}else{
//System.out.println("bbbbbbbbbbbbbbbbbbbbbbb");
			i = 7;
		}
		for(int s = 0 ; s < 50 ; s++){
			for (int t = 0; t < i; t++){
				p_stock[s][t][p] = Double.parseDouble(getP_stockString_set()[s][t][p]);
System.out.print(p_stock[s][t][p]+"  \t||");
			}
System.out.print("\n");
		}
		return p_stock;

	}



	private int number;
	public int getNumber(){return number;}

	public int unit_number(){

		Random ran = new Random();
		int a = ran.nextInt(50);
		int b = ran.nextInt(50);
		int c = ran.nextInt(50);

		for (int  i = 1000 ; i >=1 ; i= i/10){
			double ai = getP_stock()[a][5][1];
			double bi = getP_stock()[b][5][1];
			double ci = getP_stock()[c][5][1];
			double x = ai / i;
			double y = bi / i;
			double z = ci / i;

			if(x*i == ai && y*i == bi && z*i == ci){
				number = i;
				break;
			}
		}
		System.out.println("\n" + number + "株単位");
		return number;
}


}

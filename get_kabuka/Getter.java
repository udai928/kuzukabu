//package get_kabuka;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//import java.util.Scanner;
//
//import javax.swing.JTextArea;
//
//public class Getter extends cal_system{
//
//	private int year;//年
//	private int month;//月
//	private int day;//日
//
//	private String kabuka;//株価
//
//	private int code;
//	private int money;
//	private int input_code;
//	private int input_money;
//
//	public int getCode(){return code;}
//	public int getInput_code(){return input_code;}
//	public int getMoney(){return money;}
//	public int getInput_money(){return input_money;}
//
//
//
//	private URL url;
//	private String charset = "UTF-8";
//	private JTextArea htmlArea;
//
//	String[][] kabuka_set;
//	int[][] kabuka_int = new int[50][7];
//
//
//
//	public Getter(){
//	}
//
//	public int getYear(){return year;}
//	public int getMonth(){return month;}
//	public int getDay(){return day;}
//
//	public URL getUrl(){return url;}
//	public String getKabuka(){return kabuka;}
//	public String[][] getKabuka_set(){return kabuka_set;}
//	public int[][] getKabuka_int(){return kabuka_int();}
//
//
//	public int code_input(){
//		Scanner input = new Scanner(System.in);
//		System.out.print("Input CODE(4): ");
//		input_code = input.nextInt();
//		return input_code;
//	}
//
//	public URL url_input(int c) throws IOException{
//		Date date1 = new Date();
//		SimpleDateFormat url_year = new SimpleDateFormat("yyyy");
//		SimpleDateFormat url_month = new SimpleDateFormat("MM");
//		SimpleDateFormat url_day = new SimpleDateFormat("dd");
//		String url_input = "http://info.finance.yahoo.co.jp/history/?code=" + c + ".T&sy=2010&sm=1&sd=1&ey=" + url_year.format(date1) + "&em=" + url_month.format(date1) + "&ed=" + url_day.format(date1) + "&tm=d&p=" + getPage();
//		url = new URL(url_input);
////		System.out.println(url);
//		return url;
//	}
//
//		//日付、始値、高値、安値、終値、出来高、調整後終値の表示
//	public String[][] set_kabuka(URL u) throws IOException{
//
//		String line;
//		htmlArea = new JTextArea();
//		URLConnection uc = u.openConnection();
//		BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
//		BufferedReader br = new BufferedReader(new InputStreamReader(bis, charset));
//		htmlArea.setText("");
//		while ((line = br.readLine()) != null) {
//				htmlArea.append(line + "\n");
//		}
//		String text = htmlArea.getText();
//
//		int start = text.indexOf("</tr><tr><td>");
//		int end = text.lastIndexOf("</td></tr></table>");
//	//	System.out.println(start +"         " +end);
//		kabuka = text.substring(start , end + 18);
//		kabuka = kabuka.replace("年", "");
//		kabuka = kabuka.replace("月", "");
//		kabuka = kabuka.replace("日", "");
//		kabuka = kabuka.replace(",", "");
//		String[][] kabuka_set = new String[50][7];
//		for(int x = 0; x < 50; x++){
//			for(int y = 0; y < 7; y++){
//				int a = kabuka.indexOf("<td>");
//				int b = kabuka.indexOf("</td>");
//				kabuka_set[x][y] = kabuka.substring(a+4, b);
//				kabuka = kabuka.replaceFirst("<td>"+ kabuka.substring(a+4, b) +"</td>", "");
//				//System.out.print(kabuka_set[x][y] + "\t|");文字列型の株価表示
//				//System.out.println(kabuka);//HTML表示
//			}
//			//System.out.print("\n");//文字列型の株価表示の補助改行
//		}
//	return kabuka_set;
//	}
//
//	public int[][] henkan_kabuka(String[][] k){
//		for(int s = 0; s < 50; s++){
//			for (int t = 0; t < 7; t++){
//					kabuka_int[s][t] = Integer.parseInt(k[s][t]);
//					System.out.print(kabuka_int[s][t]+"  \t||");
//			}
//			System.out.print("\n");
//		}
//		return kabuka_int;
//	}
//
//
//	private int kabu_number;
//	public int getKabu_number(){return kabu_number;}
//
//	public int unit_number(){
//		int number_tangenkabu = 0;
//		Random ran = new Random();
//		int a = ran.nextInt(50);
//		int b = ran.nextInt(50);
//		int c = ran.nextInt(50);
//		System.out.println("\n\n\n\n\n\n"+ getHenakan_kabu[a][5]);
////		for (int  i = 1000 ; i >=1 ; i= i/10){
////			int ai = getKabuka_int()[a][5];
////			int bi = getKabuka_int()[b][5];
////			int ci = getKabuka_int()[c][5];
////			int x = ai / i;
////			int y = bi / i;
////			int z = ci / i;
////
////			System.out.println(ai + "\n\n\n\n" +x);
////
////			if(x == ai && y == bi && z == ci){
////				number_tangenkabu = i;
////				break;
////			}
////		}
////		System.out.println("\n\n\n" + number_tangenkabu + "株単位");
//		return number_tangenkabu;
//	}
//
//
////	public int systemTrade(kabuka[][]){
////	Scanner money = new Scanner(System.in);
////	System.out.print("Input money: ");
////	input_money = money.nextInt();
//
////
////		return ~~~~~;
////	}
//
//
////	public URL changePage(){
////		Scanner stdIn = new Scanner(System.in);
////		System.out.print("Input PAGE : ");
////		int page = stdIn.nextInt();
////
////		return ;
////	}
//
//}

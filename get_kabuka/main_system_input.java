package get_kabuka;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main_system_input extends main_system{

	private String code;
	private int money;
	private int year;
	public String getCode(){return code;}
	public int getMoney(){return money;}
	public int getYear(){return year;}
@Override
	public String code_input(){
		Scanner ci = new Scanner(System.in);
		System.out.print("Input CODE(4).(T,Q,O,N,F,S): ");
		String pre_code = ci.next();
		if( pre_code.equals("\\-$")){
			code = "USDJPY%3DX";
		}else if(pre_code.equals("topix")){
			code = "998405.T";
		}else if(pre_code.equals("nsa")){
			code = "998407.O";
		}else{
			code = pre_code;
		}
		return code;
	}
	public int money_input(){
		Scanner mi = new Scanner(System.in);
		System.out.print("Input MONEY:");
		money = mi.nextInt();
		return money;
	}
	public int year_input(){
		Scanner si = new Scanner(System.in);
		System.out.print("Input year: ");
		year = si.nextInt();
		maxpage = year * 5;
		return year;
	}


	private int page = 0;
	private int maxpage ;
	private String url_input;
	private URL url;
	public int getPage(){return page;}
	public int getMaxpage(){return maxpage;}
	public String getUrl_input(){return url_input;}
	public URL getUrl(){return url;}

	@Override
	public URL url_input(int p){
		Date date1 = new Date();
		SimpleDateFormat url_year = new SimpleDateFormat("yyyy");
		SimpleDateFormat url_month = new SimpleDateFormat("MM");
		SimpleDateFormat url_day = new SimpleDateFormat("dd");
		if(getCode().equals("998405.T") || getCode().equals("998407.O") || getCode().equals("USDJPY%3DX")){
			url_input = "http://info.finance.yahoo.co.jp/history/?code=" + getCode() + "&sy=2000&sm=1&sd=1&ey=" + url_year.format(date1) + "&em=" + url_month.format(date1) + "&ed=" + url_day.format(date1) + "&tm=d&p=" + p;
		}else{
			url_input = "http://info.finance.yahoo.co.jp/history/?code=" + getCode() + "&sy=2000&sm=1&sd=1&ey=" + url_year.format(date1) + "&em=" + url_month.format(date1) + "&ed=" + url_day.format(date1) + "&tm=d&p=" + p;
		}
		try {
//System.out.println(url_input);
			url = new URL(url_input);
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	//	System.out.println(url);
		return url;
	}


}

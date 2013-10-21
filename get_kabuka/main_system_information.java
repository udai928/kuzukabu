package get_kabuka;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JTextArea;

public class main_system_information extends main_system_conversion{


	private String charset = "UTF-8";
	private JTextArea htmlArea;

	private String market_capString;
	private String total_stocksString;

	private int market_cap;
	private int total_stocks;
	public int getMarket_cap(){return market_cap;}
	public int getTotal_stocks(){return total_stocks;}

	@Override
	public int information() throws IOException{

		URL u = new URL( "http://stocks.finance.yahoo.co.jp/stocks/detail/?code=" + getCode());
		String line;
		htmlArea = new JTextArea();
		URLConnection uc = u.openConnection();
		BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(bis, charset));
		htmlArea.setText("");
		while ((line = br.readLine()) != null) {
				htmlArea.append(line + "\n");
		}
		String text = htmlArea.getText();
		text = text.replace(",", "");
		for(int i = 0; i < 14 ; i++){
			text = text.replaceFirst("<strong>", "");
		}
			text = text.replaceFirst("</strong>株", "");

		int a = text.indexOf("<strong>");
		int b = text.indexOf("</strong>百万円");
		market_capString = text.substring(a+8, b);
		market_cap = Integer.parseInt(market_capString);
		text = text.replaceFirst("<strong>", "");

		int c = text.indexOf("<strong>");
		int d = text.indexOf("</strong>株");
		total_stocksString = text.substring(c+8, d);
		total_stocks = Integer.parseInt(total_stocksString);


		System.out.println("時価総額:" + market_cap +"\t|\t発行済み株式数"+ total_stocks );

		return market_cap & total_stocks;
	}

}

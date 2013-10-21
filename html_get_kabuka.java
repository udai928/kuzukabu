
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

public class html_get_kabuka {
    public static void main(String[] args){
    	Object o1 = null;
    	for(int i = 1 ; i <= 10 ; i++ ){
		try {
			if(i==1){
				o1 = new Getter(new URL("http://info.finance.yahoo.co.jp/history/?code=4689.T&sy=2000&sm=12&sd=12&ey=2013&em=1&ed=11&tm=d"));
			}
			else{
				o1 = new Getter(new URL("http://info.finance.yahoo.co.jp/history/?code=4689.T&sy=2000&sm=12&sd=12&ey=2013&em=1&ed=11&tm=d&p=" + i));
			}
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.print("		日付		始値		高値		安値		終値		出来高		調整後終値\n" );
		((Getter)o1).Show();
    	}
    }
//ばっくあっぷ
//    for(int i = 1 ; i >= 10 ; i++ ){
//		try {
//			o1 = new Getter(new URL("http://info.finance.yahoo.co.jp/history/?code=4689.T&sy=1991&sm=12&sd=12&ey=2013&em=1&ed=11&tm=d"));
//		} catch (MalformedURLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		System.out.print("		日付		始値		高値		安値		終値		出来高		調整後終値\n" );
//		((Getter)o1).Show();
//    	}
//    }
}
class Getter{
	private String charset = "UTF-8";
	private JTextArea htmlArea;

	public Getter(URL url){
		htmlArea = new JTextArea();
        // Webページを読み込む
        try {
            // 接続
            URLConnection uc = url.openConnection();
            // HTMLを読み込む
            BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
            //charset(UTF-8)で読み込む
            BufferedReader br = new BufferedReader(new InputStreamReader(bis, charset));
            htmlArea.setText("");//初期化

            String line;
            //lineに一行ずつ読み込む
            while ((line = br.readLine()) != null) {
            	//文字列</table>(6000行くらいある)の検索、位置が１０００以上
            	if (line.indexOf("</table>") > 1000 ){
            		//htmlArea.append(line + "\n");
            		//置き換え
            		String okikae_target1 = "</tr>";
            		Pattern p1 = Pattern.compile(okikae_target1);
            		Matcher m1 = p1.matcher(line);
            		String okikae1 = m1.replaceAll("\n");

            		String okikae_target2 = "<tr>";
            		Pattern p2 = Pattern.compile(okikae_target2);
            		Matcher m2 = p2.matcher(okikae1);
            		String okikae2 = m2.replaceAll("");

            		String okikae_target3 = "</td>";
            		Pattern p3 = Pattern.compile(okikae_target3);
            		Matcher m3 = p3.matcher(okikae2);
            		String okikae3 = m3.replaceAll("\t");

            		String okikae_target4 = "<td>";
            		Pattern p4 = Pattern.compile(okikae_target4);
            		Matcher m4 = p4.matcher(okikae3);
            		String okikae4 = m4.replaceAll("\t");

            		htmlArea.append(okikae4 + "\n" );

            	}
            }
        }
            catch (MalformedURLException ex) {
            htmlArea.setText("URLが不正です。");
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            htmlArea.setText("サイトが見つかりません。");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	public void Show(){
			System.out.print(htmlArea.getText());
	}


	}


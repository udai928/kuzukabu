package get_kabuka;

import java.util.Scanner;

public class system_trade_2 extends main_system_information{

	private double comp_high_last;
	private double comp_last_low;
	private double high;
	private double last;
	private double low;
	private double start;
	private double day;
	protected String result = "";


@Override
	public String up_or_down(){
		Scanner sd = new Scanner(System.in);
		System.out.print("Input day: ");
		day = sd.nextInt();

		for(int n = 0; n<getMaxpage() ; n++){
			for(int m = 0; m<50 ; m++){
				if(m == 49 && n == getMaxpage()-1){

				}else{
					if( getP_stock()[m][0][n] == day){
						if(m == 49){
							high = getP_stock()[1][2][n+1];
							low = getP_stock()[1][3][n+1];
							last = getP_stock()[1][4][n+1];
							start = getP_stock()[1][1][n+1];

						}else{
							high = getP_stock()[m+1][2][n];
							low = getP_stock()[m+1][3][n];
							last = getP_stock()[m+1][4][n];
							start = getP_stock()[m+1][1][n];
						}
				System.out.print(start+"\t|"+ high+"\t|" + low+"\t|" + last  );
						comp_high_last = (high - last)*100 / start;
						comp_last_low = (last - low)*100 / start;
				System.out.print("\t\th-l:"+comp_high_last+"\tl-l:"+comp_last_low);
						if(start >= last){
							if(comp_high_last - comp_last_low < -3.5){
								 result = "up";
							}else if(comp_high_last - comp_last_low > 3.5){
								result = "down";
							}else if(comp_high_last- comp_last_low > -3.5 && comp_high_last- comp_last_low < 0){
								result = "down";
							}else if(comp_high_last - comp_last_low < 3.5 && comp_high_last- comp_last_low >= 0){
								result = "up";
							}
						}else{
							if(comp_high_last - comp_last_low < -3.5){
								 result = "down";
							}else if(comp_high_last - comp_last_low > 3.5){
								result = "up";
							}else if(comp_high_last- comp_last_low > -3.5 && comp_high_last- comp_last_low < 0){
								result = "up";
							}else if(comp_high_last - comp_last_low < 3.5 && comp_high_last- comp_last_low >= 0){
								result = "down";
							}
						}
						break;
					}
				}
			}if(result != ""){break;}
		}
		if(result == ""){result = "nothing!!";}
		System.out.println("今日の株価は" + result + "です。");
		return result;
	}

	protected double check_s;
	protected double check_l;
	protected double num_check = 0;
	protected double win = 0;
	protected double lose = 0;
	protected double accuracy;
	protected String check ="";


	@Override
	public String test_up_or_down(){

	for(int n = getMaxpage()-1; n>=0 ; n--){
		for(int m = 49; m>=0 ; m--){
			if(m == 49 && n == getMaxpage()-1){

			}else{
				if(m == 49){
					high = getP_stock()[1][2][n+1];
					low = getP_stock()[1][3][n+1];
					last = getP_stock()[1][4][n+1];
					start = getP_stock()[1][1][n+1];

				}else{
					high = getP_stock()[m+1][2][n];
					low = getP_stock()[m+1][3][n];
					last = getP_stock()[m+1][4][n];
					start = getP_stock()[m+1][1][n];
				}
		System.out.print(start+"\t|"+ high+"\t|" + low+"\t|" + last  );
				comp_high_last = (high - last)*100 / start;
				comp_last_low = (last - low)*100 / start;
		System.out.print("\t\th-l:"+comp_high_last+"\tl-l:"+comp_last_low);
				if(start >= last){
					if(comp_high_last - comp_last_low < -3.5){
						 result = "up";
					}else if(comp_high_last - comp_last_low > 3.5){
						result = "down";
					}else if(comp_high_last- comp_last_low > -3.5 && comp_high_last- comp_last_low < 0){
						result = "down";
					}else if(comp_high_last - comp_last_low < 3.5 && comp_high_last- comp_last_low >= 0){
						result = "up";
					}
				}else{
					if(comp_high_last - comp_last_low < -3.5){
						 result = "down";
					}else if(comp_high_last - comp_last_low > 3.5){
						result = "up";
					}else if(comp_high_last- comp_last_low > -3.5 && comp_high_last- comp_last_low < 0){
						result = "up";
					}else if(comp_high_last - comp_last_low < 3.5 && comp_high_last- comp_last_low >= 0){
						result = "down";
					}
				}

				check_s = getP_stock()[m][4][n];
				check_l = last;

				if(check_l - check_s > 0){
					check = "down";
				}else{
					check = "up";
				}

		System.out.println("result:"+result+"\t"+"check:"+check);

				num_check = num_check + 1;
				if(check == result){
					win = win + 1;
				}else{
					lose = lose + 1;
					System.out.println("--------------------------");

				}
			}
		}
	}
	accuracy = win*100 / num_check;
	System.out.println("当たり;" + win + " / " + num_check);
	System.out.println("はずれ:" + lose +" / " + num_check);
	System.out.println("精度：" + accuracy + "%");

	return result;
}

	private double a=0;
	private double b=0;
	private double c=0;
	private double d=0;
	private double e=0;
	private double f=0;
	private double g=0;
	private double h=0;
	private double cua=0;
	private double cda=0;
	private double cub=0;
	private double cdb=0;
	private double cuc=0;
	private double cdc=0;
	private double cud=0;
	private double cdd=0;
	private double cue=0;
	private double cde=0;
	private double cuf=0;
	private double cdf=0;
	private double cug=0;
	private double cdg=0;
	private double cuh=0;
	private double cdh=0;

@Override
	public String check_up_or_down(){//価格変動の割合を計算する
		for(int n = getMaxpage()-1; n>=0 ; n--){
			for(int m = 49; m>=0 ; m--){
				if(m == 49 && n == getMaxpage()-1){

				}else{
					if(m == 49){
						high = getP_stock()[1][2][n+1];
						low = getP_stock()[1][3][n+1];
						last = getP_stock()[1][4][n+1];
						start = getP_stock()[1][1][n+1];

					}else{
						high = getP_stock()[m+1][2][n];
						low = getP_stock()[m+1][3][n];
						last = getP_stock()[m+1][4][n];
						start = getP_stock()[m+1][1][n];
					}
			//System.out.print(start+"\t|"+ high+"\t|" + low+"\t|" + last  );
					comp_high_last = (high - last)*100 / start;
					comp_last_low = (last - low)*100 / start;
			//System.out.print("\t\th-l:"+comp_high_last+"\tl-l:"+comp_last_low);

					if(start >= last){
						if(comp_high_last - comp_last_low < -3.5){
							 result = "up";
							 a = a+1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cda=cda+1;
								}else{
									check = "up";
									cua=cua+1;
								}
						}else if(comp_high_last - comp_last_low > 3.5){
							result = "down";
							b = b + 1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cdb=cdb+1;
								}else{
									check = "up";
									cub=cub+1;
								}
						}else if(comp_high_last- comp_last_low > -3.5 && comp_high_last- comp_last_low < 0){
							result = "down";
							c = c + 1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cdc=cdc+1;
								}else{
									check = "up";
									cuc=cuc+1;
								}
						}else if(comp_high_last - comp_last_low < 3.5 && comp_high_last- comp_last_low >= 0){
							result = "up";
							d = d + 1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cdd=cdd+1;
								}else{
									check = "up";
									cud=cud+1;
								}
						}
					}else{

						if(comp_high_last - comp_last_low < -3.5){
							 result = "down";
							 e = e + 1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cde=cde+1;
								}else{
									check = "up";
									cue=cue+1;
								}
						}else if(comp_high_last - comp_last_low > 3.5){
							result = "up";
							f = f + 1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cdf=cdf+1;
								}else{
									check = "up";
									cuf=cuf+1;
								}
						}else if(comp_high_last- comp_last_low > -3.5 && comp_high_last- comp_last_low < 0){
							result = "up";
							g = g + 1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cdg=cdg+1;
								}else{
									check = "up";
									cug=cug+1;
								}
						}else if(comp_high_last - comp_last_low < 3.5 && comp_high_last- comp_last_low >= 0){
							result = "down";
							h = h + 1;
							 check_s = getP_stock()[m][4][n];
								check_l = last;

								if(check_l - check_s > 0){
									check = "down";
									cdh=cdh+1;
								}else{
									check = "up";
									cuh=cuh+1;
								}
						}
					}




			//System.out.println("result:"+result+"\t"+"check:"+check);

					num_check = num_check + 1;
					if(check == result){
						win = win + 1;
					}else{
						lose = lose + 1;
					}
				}
			}
		}
		accuracy = win*100 / num_check;

		System.out.println("a;" + a + " / " + num_check+"\tcua:cda="+cua+":"+cda);
		System.out.println("b;" + b + " / " + num_check+"\tcub:cdb="+cub+":"+cdb);
		System.out.println("c;" + c + " / " + num_check+"\tcuc:cdc="+cuc+":"+cdc);
		System.out.println("d;" + d + " / " + num_check+"\tcud:cdd="+cud+":"+cdd);
		System.out.println("e;" + e + " / " + num_check+"\tcue:cde="+cue+":"+cde);
		System.out.println("f;" + f + " / " + num_check+"\tcuf:cdf="+cuf+":"+cdf);
		System.out.println("g;" + g + " / " + num_check+"\tcug:cdg="+cug+":"+cdg);
		System.out.println("h:" + h + " / " + num_check+"\tcuh:cdh="+cuh+":"+cdh);
		//System.out.println("精度：" + accuracy + "%");

		return result;
	}

}

package get_kabuka;

public class system_trade_1 extends main_system_information{


	void st_1(int i, int h){
		mark_p_buy = getP_stock()[i-1][1][h];
		if(mark_p_buy * getNumber() < getMoney()){
			System.out.println("買値:\t" + mark_p_buy + "\t日付" + getP_stock()[i-1][0][h]);
			for(int n = i-1 ; n >= 0 ; n--){
				mark_p_sell = getP_stock()[n][3][h];
				if(mark_p_sell >= mark_p_buy *1.05){
					System.out.println("売値:\t" + mark_p_sell + "\t日付" + getP_stock()[n][0][h]);
					benefit = mark_p_sell - mark_p_buy;
					break;
				}
			}
			if(benefit == 0){
				for(h = h - 1 ; h >= 0 ; h--){
					for(int n = 49 ; n >= 0 ; n--){
						mark_p_sell = getP_stock()[n][3][h];
						if(mark_p_sell >= mark_p_buy *1.05){
							System.out.println("売値:\t" + mark_p_sell + "\t日付" + getP_stock()[n][0][h]);
							benefit = mark_p_sell - mark_p_buy;
							break;
						}
					}
					if(benefit > 0){
						break;
					}
				}
			}
		}
	}

	private int mark_a;
	private int mark_b;
	private int mark_c;
	private int mark_d;
	private int mark_p_buy;
	private int mark_p_sell;
	private int benefit = 0;
	private int total_benefit = 0;

	public int getMark_p_buy(){return mark_p_buy;}
	public int getMark_p_sell(){return mark_p_sell;}
	public int getBenefit(){return benefit;}
	public int getTotal_benefit(){return total_benefit;}


	@Override
	public int practice(){

		System.out.println("\n\n");
		for(int h = getMaxpage() - 1; h >= 0; h--){
			for(int i = 49 ; i > 0 ; i--){
				if(i <= 46){
					mark_a = getP_stock()[i][4][h];
					mark_b = getP_stock()[i+1][4][h];
					mark_c = getP_stock()[i+2][4][h];
					mark_d = getP_stock()[i+3][4][h];
					if(mark_a - mark_b <= 0 && mark_b - mark_c <= 0 && mark_c - mark_d <= 0){
						st_1(i,h);
					}
					if(benefit > 0){
						break;
					}
				}else if(i == 47 && h != getMaxpage()-1){
					mark_a = getP_stock()[i][4][h];
					mark_b = getP_stock()[i+1][4][h];
					mark_c = getP_stock()[i+2][4][h];
					mark_d = getP_stock()[0][4][h+1];
					if(mark_a - mark_b <= 0 && mark_b - mark_c <= 0 && mark_c - mark_d <= 0){
						st_1(i,h);
					}
					if(benefit > 0){
						break;
					}
				}else if(i == 48 && h != getMaxpage()-1){
					mark_a = getP_stock()[i][4][h];
					mark_b = getP_stock()[i+1][4][h];
					mark_c = getP_stock()[0][4][h+1];
					mark_d = getP_stock()[1][4][h+1];
					if(mark_a - mark_b <= 0 && mark_b - mark_c <= 0 && mark_c - mark_d <= 0){
						st_1(i,h);
					}
					if(benefit > 0){
						break;
					}
				}else if(i == 49 && h != getMaxpage()-1){
					mark_a = getP_stock()[i][4][h];
					mark_b = getP_stock()[0][4][h+1];
					mark_c = getP_stock()[1][4][h+1];
					mark_d = getP_stock()[2][4][h+1];
					if(mark_a - mark_b <= 0 && mark_b - mark_c <= 0 && mark_c - mark_d <= 0){
						st_1(i,h);
					}
					if(benefit > 0){
						break;
					}
				}
			}
			if(benefit > 0){
				break;
			}
		}
		total_benefit =total_benefit + benefit;
		System.out.println(total_benefit);
		return total_benefit;
	}



}

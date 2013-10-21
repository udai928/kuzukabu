package get_kabuka;

import java.io.IOException;

public class cal_system extends calculation{



	@Override//銘柄コード、予算、（期間）の入力
	protected void input() throws IOException{

		main_system_conversion ms1 = new system_trade_3();
		ms1.code_input();
		//ms1.money_input();
		ms1.year_input();
		for(int p = ms1.getPage()  ; p < ms1.getMaxpage() ; p++ ){
			ms1.url_input(p);
			ms1.set_p_stockString(p);
			ms1.convert_p_stockString(p);
		}
		//ms1.unit_number();
		//ms1.information();

		//ms1.practice();
		//ms1.up_or_down();
		//ms1.test_up_or_down();
		//ms1.check_up_or_down();
//		ms1.least_squares_method_1();
//		ms1.least_squares_method_2();
//		ms1.least_squares_method_3();
//		ms1.least_squares_method_4();
		ms1.least_squares_method_check();


		}

	@Override//一日ずつ進める
	protected void go() {
	//	main_system_input ms2 = new system_trade_1();

		//ms2.practice();

	}



}

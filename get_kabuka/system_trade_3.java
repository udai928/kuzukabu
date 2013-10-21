package get_kabuka;

public class system_trade_3 extends system_trade_2 {

//	private double y1;
//	private double y2;
//	private double y3;
//	private double y4;
//	private double y5;
	private double a;
	private double b;
	private double x;
	private double y;
	private int num = 7;
	private int day = -1;
	private int page = 1;

	private double yi;

	private int recur_1;
	public int getRecur_1(){return recur_1;}
	public int least_squares_method_1(){



//		y1 = getP_stock()[day][1][page];
//		y2 = getP_stock()[day+1][1][page];
//		y3 = getP_stock()[day+2][1][page];
//		y4 = getP_stock()[day+3][1][page];
//		y5 = getP_stock()[day+4][1][page];

		x = 0;
		y = 0;
		a = 0;
		b = 0;


		for(double i=1;i<=num;i++){
//System.out.println(x);
			x = x + (i/num);
		}
//System.out.println(x);
		for(int i=1;i<=num;i++){
			yi = getP_stock()[day+i][1][page];
//System.out.println(yi+"\n\n\n");
			y = y + (yi/num);
			a = a + ((i-x)*yi);
			b = b + ((i-x)*(i-x));
		}

//		x = (1+2+3+4+5)/5;
//		y = (y1+y2+y3+y4+y5)/5;
//		a = (1-x)*y1 + (2-x)*y2 + (3-x)*y3 + (4-x)*y4 + (5-x)*y5;
//		b = (1-x)*(1-x) + (2-x)*(2-x) + (3-x)*(3-x) + (4-x)*(4-x) + (5-x)*(5-x);
//System.out.println(x+"\n\n\n");
//System.out.println(y+"\n\n\n");
//System.out.println((a*x)/b+"\n");

//System.out.println("y = "+(a/b)+"x  +"+(y - ((a*x)/b)));

		if(a/b > 0){
			recur_1 = 1;
		}else{
			recur_1 = 0;
		}
		return recur_1;
	}

	private int recur_2;
	public int getRecur_2(){return recur_2;}
	public int least_squares_method_2(){



//		y1 = getP_stock()[day][1][page];
//		y2 = getP_stock()[day+1][1][page];
//		y3 = getP_stock()[day+2][1][page];
//		y4 = getP_stock()[day+3][1][page];
//		y5 = getP_stock()[day+4][1][page];

		x = 0;
		y = 0;
		a = 0;
		b = 0;


		for(double i=1;i<=num;i++){
//System.out.println(x);
			x = x + (i/num);
		}
//System.out.println(x);
		for(int i=1;i<=num;i++){
			yi = getP_stock()[day+i][2][page];
//System.out.println(yi+"\n\n\n");
			y = y + (yi/num);
			a = a + ((i-x)*yi);
			b = b + ((i-x)*(i-x));
		}

//		x = (1+2+3+4+5)/5;
//		y = (y1+y2+y3+y4+y5)/5;
//		a = (1-x)*y1 + (2-x)*y2 + (3-x)*y3 + (4-x)*y4 + (5-x)*y5;
//		b = (1-x)*(1-x) + (2-x)*(2-x) + (3-x)*(3-x) + (4-x)*(4-x) + (5-x)*(5-x);
//System.out.println(x+"\n\n\n");
//System.out.println(y+"\n\n\n");
//System.out.println((a*x)/b+"\n");

//System.out.println("y = "+(a/b)+"x  +"+(y - ((a*x)/b)));

		if(a/b > 0){
			recur_2 = 1;
		}else{
			recur_2 = 0;
		}

		return recur_2;
	}

	private int recur_3;
	public int getRecur_3(){return recur_3;}
	public int least_squares_method_3(){



//		y1 = getP_stock()[day][1][page];
//		y2 = getP_stock()[day+1][1][page];
//		y3 = getP_stock()[day+2][1][page];
//		y4 = getP_stock()[day+3][1][page];
//		y5 = getP_stock()[day+4][1][page];

		x = 0;
		y = 0;
		a = 0;
		b = 0;


		for(double i=1;i<=num;i++){
//System.out.println(x);
			x = x + (i/num);
		}
//System.out.println(x);
		for(int i=1;i<=num;i++){
			yi = getP_stock()[day+i][3][page];
//System.out.println(yi+"\n\n\n");
			y = y + (yi/num);
			a = a + ((i-x)*yi);
			b = b + ((i-x)*(i-x));
		}

//		x = (1+2+3+4+5)/5;
//		y = (y1+y2+y3+y4+y5)/5;
//		a = (1-x)*y1 + (2-x)*y2 + (3-x)*y3 + (4-x)*y4 + (5-x)*y5;
//		b = (1-x)*(1-x) + (2-x)*(2-x) + (3-x)*(3-x) + (4-x)*(4-x) + (5-x)*(5-x);
//System.out.println(x+"\n\n\n");
//System.out.println(y+"\n\n\n");
//System.out.println((a*x)/b+"\n");

//System.out.println("y = "+(a/b)+"x  +"+(y - ((a*x)/b)));

		if(a/b > -0.25 && a/b < 0.25){
			recur_3 = 1;
		}else{
			recur_3 = 0;
		}
		return recur_3;
	}

	private int recur_4;
	public int getRecur_4(){return recur_4;}
	public int least_squares_method_4(){


//		y1 = getP_stock()[day][1][page];
//		y2 = getP_stock()[day+1][1][page];
//		y3 = getP_stock()[day+2][1][page];
//		y4 = getP_stock()[day+3][1][page];
//		y5 = getP_stock()[day+4][1][page];

		x = 0;
		y = 0;
		a = 0;
		b = 0;


		for(double i=1;i<=num;i++){
//System.out.println(x);
			x = x + (i/num);
		}
//System.out.println(x);
		for(int i=1;i<=num;i++){
			yi = getP_stock()[day+i][4][page];
//System.out.println(yi+"\n\n\n");
			y = y + (yi/num);
			a = a + ((i-x)*yi);
			b = b + ((i-x)*(i-x));
		}

//		x = (1+2+3+4+5)/5;
//		y = (y1+y2+y3+y4+y5)/5;
//		a = (1-x)*y1 + (2-x)*y2 + (3-x)*y3 + (4-x)*y4 + (5-x)*y5;
//		b = (1-x)*(1-x) + (2-x)*(2-x) + (3-x)*(3-x) + (4-x)*(4-x) + (5-x)*(5-x);
//System.out.println(x+"\n\n\n");
//System.out.println(y+"\n\n\n");
//System.out.println((a*x)/b+"\n");

//System.out.println("y = "+(a/b)+"x  +"+(y - ((a*x)/b)));

		if(a/b < 0){
			recur_4 = 1;
		}else{
			recur_4 = 0;
		}

		return recur_4;
	}


	private int c1;
	private int c2;
	private int c3;
	private int c4;
	private int unknown = 0;

	@Override
	public String least_squares_method_check(){


		for(int i=0; i< getMaxpage();i++){
			for(int s=0; s<49-num; s++){
				page = i;
				day = s;
				c1 = least_squares_method_1();
				c2 = least_squares_method_2();
				c3 = least_squares_method_3();
				c4 = least_squares_method_4();

				if(c1 == 1 && c4 == 1){
					result ="up";

				}else if(c1 == 0 && c4 == 0){
					result ="down";
				}else{
					unknown += 1;
					result ="unknown";
				}

				check_s = getP_stock()[s][4][i];
				check_l = getP_stock()[s+1][4][i];

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
			accuracy = win*100 / (num_check-unknown);
			System.out.println("当たり;" + win + " / " + (num_check-unknown));
			System.out.println("はずれ:" + lose +" / " + num_check);
			System.out.println("精度：" + accuracy + "%");

		return result;
	}
}

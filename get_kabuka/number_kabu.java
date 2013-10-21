//package get_kabuka;
//
//import java.util.Random;
//
//public class number_kabu extends Getter{
//	private int kabu_number;
//	public int getKabu_number(){return kabu_number;}
//	@Override
//	public int number(){
//		int number_tangenkabu = 0;
//		Random ran = new Random();
//		int a = ran.nextInt(50);
//		int b = ran.nextInt(50);
//		int c = ran.nextInt(50);
//
//		for (int  i = 1000 ; i > 0 ; i= i/10){
//			int ai = getKabuka_int()[a][5];
//			int bi = getKabuka_int()[b][5];
//			int ci = getKabuka_int()[c][5];
//			int x = ai / i;
//			int y = bi / i;
//			int z = ci / i;
//
//			if(x == ai && y == bi && z == ci){
//				number_tangenkabu = i;
//				break;
//			}
//		}
//		System.out.println("\n\n\n" + number_tangenkabu + "株単位");
//		return number_tangenkabu;
//	}
//
//
//}

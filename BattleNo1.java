import java.util.*;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a[] = {0,46,45,66,53,62,61,51,47,57,58,61,49,50};
		int b[] = {0,50,59,74,57,69,73,53,50,62,88,68,59,72};
		int c[] = {0,67,67,81,73,75,80,66,83,75,97,77,64,80};
		int n = sc.nextInt();
		NS dp[][] = new NS[14][n + 1];
		for(int i = 0; i <= 13; i++){
			for(int j = 0; j <= n; j++){
				dp[i][j] = new NS(false,"");
			}
		}
		dp[0][0] = new NS(true,"");
		for(int i = 1; i <= 13; i++){
			for(int j = 0; j <= n; j++){
				if(dp[i - 1][j].getA() && j + a[i] <= n) {
					dp[i][j + a[i]] = new NS(true,dp[i - 1][j].getB() + "1");
				}
				if(dp[i - 1][j].getA() && j + b[i] <= n) {
					dp[i][j + b[i]] = new NS(true,dp[i - 1][j].getB() + "2");
				}
				if(dp[i - 1][j].getA() && j + c[i] <= n) {
					dp[i][j + c[i]] = new NS(true,dp[i - 1][j].getB() + "3");
				}
			}
		}
		if(n < 706 || 986 <= n) System.out.println("-1");
		else {
			String ss = dp[13][n].getB();
			for(int i = 0; i < 13; i++){
				String s = ss.substring(i,i + 1);
				if(i == 12 && s.equals("1")) System.out.println("普通");
				else if(s.equals("1"))System.out.print("普通-");
				if(i == 12 && s.equals("2")) System.out.println("玄人");
				else if(s.equals("2"))System.out.print("玄人-");
				if(i == 12 && s.equals("3")) System.out.println("達人");
				else if(s.equals("3"))System.out.print("達人-");
			}
		}
	}
}
class NS{
	private boolean a;
	private String b;
	public NS(boolean a, String b){
		this.a = a;
		this.b = b;
	}
	public boolean getA(){
		return this.a;
	}
	public String getB(){
		return this.b;
	}
}

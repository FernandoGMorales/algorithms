package common.util.algorithms.numberTheory;

public class PrimalityTest {
	
	public static boolean isPrime(long n) {
		int i=2;
		int sqrt_of_n = (int) Math.sqrt(n);
		while(i<=sqrt_of_n) {
			if(n%i==0) {
				return false;
			}
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {

	}

}

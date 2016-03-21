package common.util.algorithms.numberTheory;

public class SieveOfEratosthenes {	
	
	/**
	 * Find the prime factors up to n (included), 0 if the number is prime.
	 * Marks numbers not prime as true, starting from two (lowest prime number) and then marks all its multiples.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean[] sieve(int n) {
		boolean[] sieve = new boolean[n+1];
		sieve[0] = true;
		sieve[1] = true;
		for(int i=2; i*i<=n; i++) {
			if(sieve[i]==false) {
				int k = i*i;
				while(k<=n) {
					sieve[k]=true;
					k+=i;
				}
			}
		}
		return sieve;		
	}
	
	public static void main(String[] args) {
		boolean[] sieve = sieve(110_000);
		int count = 0;
		for(int i=0; i<sieve.length; i++) {
			if(sieve[i]==false) {
				count++;
				if(count==10_001) {
					System.out.print(i);
					break;
				}
			}
		}
	}

}

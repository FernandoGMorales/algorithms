package common.util.algorithms.numberTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class SieveOfEratosthenes {
	
	/* not finished */
	public static List<Integer> factorize(int x) {
		List<Integer> factors = new ArrayList<>();
		int[] x_factors = sieveFactorization(x);
		while(x_factors[x]>0) {
			factors.add(x_factors[x]);
			x /= x_factors[x];
		}
		factors.add(x_factors[x]);
		return factors;
	}
	
	/**
	 * For each crossed number up to N the array will hold the minimum prime factor that divides the number.
	 * With this approach we can factorize numbers very quickly. If we know that one of the prime
	 * factors of x is p, then all the prime factors of x are p plus the decomposition of x/p . 
	 * 
	 * @param N
	 * @return an array with the numbers up to N with the minimum prime factor for each number
	 */
	public static int[] sieveFactorization(int N) {
		int[] factors = new int[N+1];
		int sqrtOfN = (int) Math.sqrt(N);
		for (int i = 2; i < sqrtOfN; i++) {
			if (factors[i] == 0) {
				int k = i * i;
				while (k <= N) {
					if(factors[k]==0) {
						factors[k] = i;						
					}
					k += i;
				}
			}
		}
		return factors;
	}
	
	/**
	 * Find prime factors up to n and adds to a list
	 * 
	 * @param n
	 * @return a list with the first n prime factors
	 */
	public static List<Integer> sieveAsList(int n) {
		boolean[] sieve = new boolean[n+1];
		Arrays.fill(sieve, 2, n+1, true);
		List<Integer> primes = new ArrayList<>();
		if(n<2) {
			return primes; 
		}		
		int sqrtOfN = (int) Math.sqrt(n);
		for(int i=2; i<=sqrtOfN; i++) {
			if(sieve[i]) {
				int k = i*i;
				while(k <= n) {
					sieve[k] = false;
					k += i;
				}
			}
		}
		primes = IntStream.range(2, sieve.length).filter(x -> sieve[x]==true).boxed().collect(toList());
		return primes;
				
	}
	
	/**
	 * Find the prime factors up to n (included), 0 if the number is prime.
	 * Marks numbers not prime as true, starting from two (lowest prime number) and then marks all its multiples.
	 * 
	 * @param n
	 * @return an array of booleans with prime indices == true.
	 */
	public static boolean[] sieveAsBooleanArray(int n) {
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
		List<Integer> factors = factorize(20);
		factors.stream().forEach(System.out::println);		
	}
	
	private void testCase2() {
		List<Integer> primes = sieveAsList(30);
		assert(primes.size()==10);
		primes.forEach(x -> System.out.print(x + " "));
	}
	
	private void testCase1() {
		boolean[] sieve = sieveAsBooleanArray(110_000);
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

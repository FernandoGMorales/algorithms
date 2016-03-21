package com.project.Euler;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargeSum {
	
	public static void main(String[] args) {
		List<BigInteger> list = new ArrayList<BigInteger>();
		try {
			Scanner sc = new Scanner(new File("/home/fernando/tmp/large_sum.txt"));			
			for(int i=0; sc.hasNextLine(); i++) {
				list.add(new BigInteger(sc.nextLine()));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		BigInteger sum = BigInteger.ZERO;
		for(BigInteger i : list) {
			sum = sum.add(i);
		}
		System.out.print(sum);
	}

}

package com.hackerrank.warmup;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TimeConversion {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        System.out.println(time);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        String formattedTime = sdf.format(time);
        System.out.println(formattedTime);
    }

}

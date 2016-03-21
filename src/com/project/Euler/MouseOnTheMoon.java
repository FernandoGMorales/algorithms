package com.project.Euler;

public class MouseOnTheMoon {
	
	/* REVIEW!!!!!!11
	 * Problem facts:
	 * 1) You have to build a wall around the land that you stake out 
	 * 2) Every country has been allotted a 500 m by 500 m square area
	 * 3) 251001 posts have been placed in a rectangular grid with 1 meter spacing. 
	 * 4) The wall must be a closed series of straight lines, each line running from post to post.	 * 
	 * 5) The bigger countries have built a 2000 m wall enclosing the entire 250 000 m2 area. 
	 * 6) The Duchy of Grand Fenwick, has a tighter budget, and has asked you (their Royal Programmer) 
	 * to compute what shape would get best maximum enclosed-area/wall-length ratio.
	 * 
	 * 7) For a 2000 meter wall enclosing the 250 000 m2 area the enclosed-area/wall-length ratio is 125. 
	 * 8) Although not allowed, but to get an idea if this is anything better: if you place a circle inside the
	 * square area touching the four sides the area will be equal to π*2502 m2 and the perimeter will be π*500 m, 
	 * so the enclosed-area/wall-length ratio will also be 125.
	 * 
	 * 9) However, if you cut off from the square four triangles with sides 75 m, 75 m and 75√2 m the total area 
	 * becomes 238750 m2 and the perimeter becomes 1400+300√2 m. So this gives an enclosed-area/wall-length ratio of
	 * 130.87, which is significantly better.
	 * 
	 * Find the maximum enclosed-area/wall-length ratio. Give your answer
	 * rounded to 8 places behind the decimal point in the form abc.defghijk.
	 * 
	 * Solution:
	 * 
	 */
	
	public static double solution(double area, double wall_lenght) {
		double max_ratio = 125;
		double perfect_area = 0;
		double perfect_wall = 0;
		for(int i=(int)area; i>0; i--) {
			for(int j=(int)wall_lenght; j>0; j--) {
				double current_ratio = (double)i/(double)j;
				if(current_ratio>max_ratio) {
					max_ratio = current_ratio;
					perfect_area = i;
					perfect_wall = j;
				}
			}
		}
		System.out.println("Area: " + perfect_area);
		System.out.println("Wall: " + perfect_wall);
		System.out.println("Ratio: " + max_ratio);
		return max_ratio;		
	}
	
	public static void main(String[] args) {
		double max_ratio = solution(250_000, 2_000);		
	}

}

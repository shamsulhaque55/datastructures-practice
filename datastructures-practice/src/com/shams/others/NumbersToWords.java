package com.shams.others;

public class NumbersToWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(toWords(5000));
		System.out.println(NumberToWords(3000));
	}
	// max : 9999999999
	private static String toWords(long n) {
		String words = "";
		String[] ones = new String[] {"Zero",
				"One", "Tow", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
				"Seventeen", "Eighteen", "Nineteen",
				"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Svenety", "Eighty", "Ninety"
		};
		String[] tens = new String[] {
						"","", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Svenety", "Eighty", "Ninety"
				};
	/*	String[] units = new String[] {
				"Hundred", "Thousand", "Lac", "Crore", "Arab"
		};*/
 		if(n < 0) {
			words = "Minus";
		} else if(n == 0 && words.length() == 0) {
			words = ones[0];
		}else {
			if (n >= 100000000000L) {
				return "Out of range";
			}
			if (n < 100000000000L && n > 1000000000L) {
				//Arab
				words = words +  toWords((int) (n/1000000000L))+ " Arab" +" " + toWords(n % 1000000000L);

			} else if (n < 1000000000L && n > 9999999L) {
				// Crores
				words = words +  toWords((int) (n/10000000L))+ " Crore" +" " + toWords(n % 10000000L);

			}  else if (n < 10000000L && n > 99999L) {
				//Lacs
				words = words + toWords((int) (n/100000L))+ " Lac" +" " + toWords(n % 100000L);
			}  else if (n < 100000L && n > 999L) {
				//thousands
				words = words +  toWords((int) (n/1000L))+ " Thousand" +" " + toWords(n % 1000L);
			}  else if (n < 1000L && n >99L) {
				//hundreds
				words = words +  ones[(int) (n/100L)]+ " Hundred" +" " + toWords(n % 100L);
			} else if (n < 100L && n >19L){
				words = words +  tens[(int) n / 10]+" "+ toWords(n % 10L);
			} else if(n != 0) {
				words = words +  ones[(int)n];
			}
		}
 		return words;
	}
	
	static String unitsMap[] = { "zero", "one", "two", "three", "four", "five","six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	static String tensMap[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	static String NumberToWords(int number)
	 {
	  if (number == 0)
	     return "zero";

	 if (number < 0)
	     return "minus " + NumberToWords((number));

	 String words = "";

	 if ((number / 1000000000) > 0)
	 {
	     words += NumberToWords(number / 1000000000) + " billion ";
	     number %= 1000000000;
	 }

	 if ((number / 1000000) > 0)
	 {
	     words += NumberToWords(number / 1000000) + " million ";
	     number %= 1000000;
	 }

	 if ((number / 1000) > 0)
	 {
	     words += NumberToWords(number / 1000) + " thousand ";
	     number %= 1000;
	 }

	 if ((number / 100) > 0)
	 {
	     words += NumberToWords(number / 100) + " hundred ";
	     number %= 100;
	 }

	 if (number > 0)
	 {
	     if (number < 20)
	         words += unitsMap[number];
	     else
	     {
	         words += tensMap[number / 10];
	         if ((number % 10) > 0)
	             words += "-" + unitsMap[number % 10];
	     }
	 }

	 return words;
	  }

}

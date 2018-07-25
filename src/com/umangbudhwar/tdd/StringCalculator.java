package com.umangbudhwar.tdd;

public class StringCalculator {

	public int add(String str) throws NegativeNumberException {

		if (str.equals("")) {
			return 0;
		}

		if (!str.contains("\n") && (str.lastIndexOf("-") == 0 || Character.isDigit(str.charAt(0)))
				&& !str.contains(",")) {
			int num = Integer.parseInt(str);
			if (num < 0) {
				throw new NegativeNumberException(num);
			}
			return num;
		}
		String delimeter = ",";
		if (!Character.isDigit(str.charAt(0))) {
			delimeter = "" + str.charAt(0);
			str = str.substring(2);
		}
		int sum = 0;
		if (str.contains("\n")) {
			String ar1[] = str.split("\n");
			for (String s : ar1) {
				String ar2[] = s.split(delimeter);
				for (String s2 : ar2) {
					int num = Integer.parseInt(s2);
					if (num < 0) {
						throw new NegativeNumberException(num);
					}
					sum += num;
				}
			}
		} else {
			String ar[] = str.split(delimeter);
			for (String s : ar) {
				int num = Integer.parseInt(s);
				if (num < 0) {
					throw new NegativeNumberException(num);
				}
				sum += num;
			}
		}
		return sum;
	}

}

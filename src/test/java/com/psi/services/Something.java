package com.psi.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Something {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		System.out.println(sdf.format(date));
		
		String abc = "1m2,fdfdf,fdff,";
		System.out.println(abc.substring(0, abc.length() - 1));
		
		String def = "I have <something> in mind";
		System.out.println(def.replaceFirst("<something>", "you"));
	}

}

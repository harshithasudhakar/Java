//Strings

import java.lang.String;

class StringPrac{
	public static void main(String[] args){
		/*
		String s= new String();
		s="Hello World";
		System.out.println(s);
		
		char[] ch_array= {'j','a','v','a'};
		String s = new String(ch_array);
		System.out.println(s);
		*/
		
		char[] ch_array= {'j','a','v','a'};
		String s = new String(ch_array,1,3);
		System.out.println(s);
	}
}

package com.byhealth.tcbjhome.api;

public class QuanHHDa {
	
public static void main(String[] args) {
	int num = 51;
	int total = 51;
	while(num>1){
		total = total + (num/2);
		num=num/2+num%2;
	}
	
	System.out.println("总数是"+total+"空瓶有"+num+"个");
}
}

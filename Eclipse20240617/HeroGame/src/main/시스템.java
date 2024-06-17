package main;

import java.util.Random;
import java.util.Scanner;

public class 시스템 {	
	시스템()
	{
		
	}
	private static Random rand = new Random();
	private static String [] strItemlist = { "고구마", "감자", "힐링포션", "마나포션" };
	private static final int ItemIdx = 4;
	private static Scanner sc = new Scanner(System.in);

	public static String getInputString() {
		return sc.nextLine();
	}
	
	public static int getInputInt() {
		int n = sc.nextInt();
		return n;
	}
	
	public static int getRandInt(int n)
	{
		return rand.nextInt(n);
	}
	
	public static 아이템 랜덤아이템생성() {
		아이템 Item = new 아이템();
		int id = rand.nextInt(ItemIdx);
		int count = rand.nextInt(5) + 1;
		
		Item.setName(strItemlist[id]);
		Item.setCount(count);
		
		return Item;
	}
	
	
	
	
	
	public static String[] getStrItemlist() {
		return strItemlist;
	}

	public static int getItemidx() {
		return ItemIdx;
	}

}

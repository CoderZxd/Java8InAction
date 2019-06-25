package com.zxd.java8.test;

/**
 * @Title: MeaningOfThis
 * @Description: TODO
 * @Author xiaodong.zou
 * @Date 2019/6/25 10:08
 */
public class MeaningOfThis {
	public final int value = 4;
	public void doIt()
	{
		int value = 6;
		Runnable r = new Runnable(){
			public final int value = 5;
			@Override
			public void run(){
				int value = 10;
				System.out.println(this.value);
			}
		};
		r.run();
	}
	public static void main(String...args)
	{
		MeaningOfThis m = new MeaningOfThis();
		m.doIt();//5
	}
}

package Reflect1;

import java.lang.reflect.Field;

import org.junit.Test;

public class Reflect1 {
	
	@Test
	/**
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * 1. 通过一个Car对象生成的Class对象，在通过Class对象调用newInstance方法生成的对象
	 * 和原来的Car对象不是同一个对象
	 */
	public void fun1() throws InstantiationException, IllegalAccessException {
		Car car = new Car();
		Car c2 = car.getClass().newInstance();
		System.out.println(c2 == car); //false
		System.out.println(c2.toString());
		System.out.println(car.toString());
	}
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * 
	 */
	@Test
	public void fun2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c = Class.forName("Reflect1.Car");  // 数组中是共有的域
		Field[] fs = c.getFields();
		Field f = fs[0];
		Field[] fs2 = c.getDeclaredFields();  //数组中全部的field域
		
		Car car = new Car();
		f.setAccessible(true);
		Object o =   f.get(car);
		System.out.println(fs[0]);
	}

}

package utils;

import java.util.Random;

import com.github.javafaker.Faker;

public class DatosFalsos {
	private Faker faker;
	public static DatosFalsos instance = new DatosFalsos();
	public static Faker getInstance = instance.getFaker();
	
	public DatosFalsos() {
		faker = new Faker(new Random(24));
		
	}
	
	public Faker getFaker() {
		return faker;
	}
}

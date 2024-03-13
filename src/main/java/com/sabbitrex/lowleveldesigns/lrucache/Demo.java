package com.sabbitrex.lowleveldesigns.lrucache;

public class Demo {
	
	public static void main(String[] args) {
		
		CacheClient client = new CacheClientImpl(10);
		
		client.showCache();
		System.out.println("-----------------------------");
		
		client.put(1, "Sharad");
		client.put(2, "Astha");
		client.put(3, "Rooney");
		client.put(4, "Messi");
		client.put(5, "Trident");
		client.put(6, "Yamaha");
		client.put(7, "bangkok");
		client.put(8, "Ibiza");
		client.put(9, "Italy");
		client.put(10, "CBR");
		
		
		client.showCache();
		System.out.println("-----------------------------");
		client.put(11, "Germany");
		System.out.println("-----------------------------");
		
		client.showCache();
		
		client.get(2);
		System.out.println("-----------------------------");
		client.showCache();
	}
}

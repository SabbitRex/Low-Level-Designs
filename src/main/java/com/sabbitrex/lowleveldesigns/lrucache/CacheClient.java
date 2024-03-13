package com.sabbitrex.lowleveldesigns.lrucache;

public interface CacheClient {
	
	void get(int key);
	void put(int key, String value);
	void showCache();
}
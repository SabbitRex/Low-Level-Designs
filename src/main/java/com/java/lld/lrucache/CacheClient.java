package com.java.lld.lrucache;

public interface CacheClient {
	
	void get(int key);
	void put(int key, String value);
	void showCache();
}
package com.sabbitrex.lowleveldesigns.lrucache;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class CacheClientImpl implements CacheClient {

	private int capacity;
	private final LinkedHashMap<Integer, String> linkedHashMap;
	private LinkedList<Integer> linkedList;

	public CacheClientImpl(int capacity) {
		this.capacity = capacity;
		this.linkedHashMap = new LinkedHashMap<>(capacity);
		this.linkedList = new LinkedList<>();
	}

	@Override
	public void showCache() {

		if (this.linkedHashMap.size() == 0) {
			System.out.println("Cache is empty!");
		}

		for (int key : this.linkedList) {
			System.out.println("Key: " + key + " | Value: " + this.linkedHashMap.get(key));
		}
	}

	@Override
	public void get(int key) {

		String result = this.linkedHashMap.get(key);

		if (result == null) {
			System.out.println("Key is not present!");
		}

		// Since the key is accessed, now it will be moved to first
		this.linkedList.remove(key);
		this.linkedList.addFirst(key);
		System.out.println("Value: " + result);
	}

	@Override
	public void put(int key, String value) {

		// If cache space is at capacity - else add at back of queue
		if (isCacheFull()) {

			System.out.println("Cache is full!");
			System.out.println("Removing least recently used key!");
			System.out.println("Adding new key!");

			// Remove last element from list and map
			int lruKey = this.linkedList.getLast();
			this.linkedHashMap.remove(lruKey);
			this.linkedList.removeLast();

			// Add new element at end of list and map
			this.linkedList.add(key);
			this.linkedHashMap.put(key, value);

		} else {

			this.linkedList.add(key);
			this.linkedHashMap.put(key, value);
		}
	}

	private boolean isCacheFull() {

		if (this.linkedHashMap.size() == this.capacity) {
			return true;
		}

		return false;
	}
}
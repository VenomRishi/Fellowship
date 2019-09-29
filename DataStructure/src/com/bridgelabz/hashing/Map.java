package com.bridgelabz.hashing;

import java.util.ArrayList;

//hash table class
public class Map<K, V> {
	// it contains the chain
	public ArrayList<HashNode<K, V>> chainArray;
	// capacity of array list
	public int arrCapacity;
	// size of array list
	public int size;

	public Map() {
		chainArray = new ArrayList<>();
		arrCapacity = 11;
		size = 0;

		for (int i = 0; i < arrCapacity; i++) {
			chainArray.add(null);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int hashIndex(K key) {
		int hashCod = (int) key;
		return hashCod % 11;
	}

	// Returns value for a key
	public V get(K key) {
		// Find head of chain for given key
		int hashIndex = hashIndex(key);
		HashNode<K, V> head = chainArray.get(hashIndex);

		// Search key in chain
		while (head != null) {
			if (head.key.equals(key))
				return head.value;
			head = head.next;
		}

		// If key not found
		return null;
	}

	// function for adding key and value
	public void add(K key, V value) {
		int hashIndex = hashIndex(key);
		// Get head of chain
		HashNode<K, V> head = chainArray.get(hashIndex);
		// Check if key is already present
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		// Insert key in chain
		size++;
		head = chainArray.get(hashIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		chainArray.set(hashIndex, newNode);
		// If load factor goes beyond threshold, then
		// double hash table size
		if ((1.0 * size) / arrCapacity >= 0.7) {
			ArrayList<HashNode<K, V>> temp = chainArray;
			chainArray = new ArrayList<>();
			arrCapacity = 2 * arrCapacity;
			size = 0;
			for (int i = 0; i < arrCapacity; i++)
				chainArray.add(null);

			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	// method for removing node from chain
	public V remove(K key) {
		// Apply hash function to find index for given key
		int hashIndex = hashIndex(key);

		// Get head of chain
		HashNode<K, V> head = chainArray.get(hashIndex);

		// Search for key in its chain
		HashNode<K, V> prev = null;
		while (head != null) {
			// If Key found
			if (head.key.equals(key))
				break;

			// Else keep moving in chain
			prev = head;
			head = head.next;
		}

		// If key was not there
		if (head == null)
			return null;

		// Reduce size
		size--;

		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			chainArray.set(hashIndex, head.next);

		return head.value;
	}

	public void show() {
		for (int i = 0; i < chainArray.size(); i++) {

			System.out.println("array index : " + i);
			HashNode<K, V> head = chainArray.get(i);
			while (head != null) {

				System.out.println(head.value);

				head = head.next;

			}

		}

		// Get head of chain

	}

}

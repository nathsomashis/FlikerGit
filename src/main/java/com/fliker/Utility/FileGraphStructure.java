package com.fliker.Utility;

import java.util.NoSuchElementException;

public class FileGraphStructure<Key extends Comparable<Key>, Value> {

	
		private Node folder;
		
		private class Node{
			private Key key;
			private Value value;
			private Node folder;
			private int size;
			
			public Node(Key key, Value value, int size){
				this.key = key;
				this.value = value;
				this.size = size;
			}
		}
		
		
		
		public FileGraphStructure(){
			
		}
		
		public boolean isEmpty() {
	        return size() == 0;
	    }
		
		public int size() {
	        return size(folder);
	    }
		
		private int size(Node x) {
	        if (x == null) return 0;
	        else return x.size;
	    }
		
		public boolean contains(Key key) {
	        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
	        return get(key) != null;
	    }
		
		public Value get(Key key) {
	        return get(folder, key);
	    }
		
		private Value get(Node x, Key key) {
	        if (key == null) throw new IllegalArgumentException("called get() with a null key");
	        if (x == null) return null;
	        int cmp = key.compareTo(x.key);
	        if      (cmp < 0) return get(x.folder, key);
	        else return x.value;
	    }
		

	    private Node put(Node x, Key key, Value value) {
	        if (x == null) return new Node(key, value, 1);
	        int cmp = key.compareTo(x.key);
	        if      (cmp < 0) x.folder  = put(x.folder,  key, value);
	        else              x.value   = value;
	        x.size = 1 + size(x.folder);
	        return x;
	    }
	    
	    /*public void delete(Key key) {
	        if (key == null) throw new IllegalArgumentException("called delete() with a null key");
	        folder = delete(folder, key);
	        assert check();
	    }

	    private Node delete(Node x, Key key) {
	        if (x == null) return null;

	        int cmp = key.compareTo(x.key);
	        if      (cmp < 0) x.folder  = delete(x.folder,  key);
	        else { 
	            
	            Node t = x;
	            x = min(t.folder);
	            
	        } 
	        x.size = size(x.folder) + 1;
	        return x;
	    } 
	    
	    public Key min() {
	        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
	        return min(folder).key;
	    } 

	    private Node min(Node x) { 
	        if (x.folder == null) return x; 
	        else             return min(x.left); 
	    }
	    
	    
	    public Iterable<Key> keys() {
	        return keys(min(), max());
	    }

	    *//**
	     * Returns all keys in the symbol table in the given range,
	     * as an {@code Iterable}.
	     *
	     * @param  lo minimum endpoint
	     * @param  hi maximum endpoint
	     * @return all keys in the symbol table between {@code lo} 
	     *         (inclusive) and {@code hi} (inclusive)
	     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
	     *         is {@code null}
	     *//*
	    public Iterable<Key> keys(Key lo, Key hi) {
	        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
	        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

	        Queue<Key> queue = new Queue<Key>();
	        keys(root, queue, lo, hi);
	        return queue;
	    } 

	    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
	        if (x == null) return; 
	        int cmplo = lo.compareTo(x.key); 
	        int cmphi = hi.compareTo(x.key); 
	        if (cmplo < 0) keys(x.left, queue, lo, hi); 
	        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
	        if (cmphi > 0) keys(x.right, queue, lo, hi); 
	    } */

	    
	
}

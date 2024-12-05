import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


/**
 * A Doom class that is simply a map with Keys K and values V.
 * You MUST implement the methods. A LinkedList is provided for you to use, and should
 * be the only piece of storage you need.
 */
public class Doom<K,V>{

	//You may modify this class if needed
	private class KeyValuePair{
		K key;
		V value;

		public KeyValuePair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {return key;}

		public V getValue() {return value;}
	}

	LinkedList<KeyValuePair> myInfo;

	/**
	 * A constructor for the Doom map.
	 */
	public Doom(){
		myInfo = new LinkedList<>();
	}

	/**
	 * Associates the specified value with the specified key in this map.
	 * If the specified key is already in the map, update the key with a new value.
	 * If it is not in the map, add a new key and associate it to this value.
	 *
	 * @param key is the key
	 * @param value is the value
	 */
	public void put(K key, V value){
		myInfo.add(new KeyValuePair(key, value));
	}

	/**
	 * Remove the key and value from this map if present.
	 * If not, simply return null.
	 */
	public V remove(K key){
		ListIterator<KeyValuePair> lit = myInfo.listIterator();
		while(lit.hasNext()) {
			if(key.equals(lit.next().getKey())) {
				V temp = lit.previous().getValue();
				myInfo.remove(lit.next());
				return temp;
			}
		}
		return null;
	}

	/**
	 * Returns the size of the map.
	 */
	public int size(){
		return myInfo.size();
	}

	/**
	 * Returns the value of the corresponding key
	 */
	public V get(K key){
		ListIterator<KeyValuePair> lit = myInfo.listIterator();
		while(lit.hasNext()) {
			if(key.equals(lit.next().getKey())) {
				return lit.previous().getValue();
			}
		}

		return null;
	}

	/**
	 * Returns a string containing each key and corresponding value.
	 *
	 * @return a string representation of the map
	 */
	public String toString(){
		ListIterator<KeyValuePair> lit = myInfo.listIterator();
		String str = "";

		while(lit.hasNext()) {
			KeyValuePair temp = lit.next();
			str += "Key: " + temp.getKey() + " Value: " + temp.getValue() + "\n";
		}

		return str;
	}

	/**
	 * Resets this map to have no keys or values
	 */
	public void clear(){
		myInfo = new LinkedList<>();
	}

	/**
	 * Checks if a key exists in the map and returns true if there is.
	 *
	 * @param key the Key to check for
	 * @return true if the provided key is in this map
	 */
	public boolean containsKey(K key){
		ListIterator<KeyValuePair> lit = myInfo.listIterator();
		while(lit.hasNext()) {
			if(key.equals(lit.next().getKey())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns true if and only if this map contains no entries
	 * @return true if the map is empty
	 */
	public boolean isEmpty(){
		if(this.size() == 0) {
			return true;
		}

		return false;
	}

//	public static void main(String[] args) {
//		System.out.println("Hello World!");
//		Doom obj0 = new Doom<String, Integer>();
//
//		obj0.put("cat", 0);
//		obj0.put("dog", 1);
//		obj0.put("chicken", 2);
//		obj0.put("snake", 3);
//		obj0.put("rat", 4);
//
//		System.out.println(obj0.toString());
//		System.out.println(obj0.remove("snake"));
//		System.out.println(obj0.toString());
//		System.out.println(obj0.size());
//	}
}

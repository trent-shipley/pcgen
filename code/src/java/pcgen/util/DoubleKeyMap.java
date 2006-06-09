/*
 * Created on Jun 16, 2005
 *
 * Copyright (c) Thomas Parker, 2005.
 */
package pcgen.util;

import java.util.*;

/**
 * A map representation for a dual key entity
 */
public class DoubleKeyMap<K1, K2, V> implements Cloneable
{

	private Map<K1, Map<K2, V>> map = new HashMap<K1, Map<K2, V>>();

	/**
	 * Constructor
	 */
	public DoubleKeyMap()
	{
		super();
	}

	/**
	 * Put an object in a map
	 * @param key1
	 * @param key2
	 * @param value
	 * @return Object
	 */
	public V put(K1 key1, K2 key2, V value)
	{
		Map<K2, V> localMap = map.get(key1);
		if (localMap == null)
		{
			localMap = new HashMap<K2, V>();
			map.put(key1, localMap);
		}
		return localMap.put(key2, value);
	}

	/**
	 * Get an object from the map
	 * @param key1
	 * @param key2
	 * @return Object
	 */
	public V get(K1 key1, K2 key2)
	{
		Map<K2, V> localMap = map.get(key1);
		if (localMap == null)
		{
			return null;
		}
		return localMap.get(key2);
	}

	/**
	 * Returns true if an object is in the map given two keys
	 * @param key1
	 * @param key2
	 * @return true if an object is in the map given two keys
	 */
	public boolean containsKey(K1 key1, K2 key2)
	{
		Map<K2, V> localMap = map.get(key1);
		if (localMap == null)
		{
			return false;
		}
		return localMap.containsKey(key2);
	}

	/**
	 * Remove the object from the map
	 * @param key1
	 * @param key2
	 * @return Object
	 */
	public V remove(K1 key1, K2 key2)
	{
		Map<K2, V> localMap = map.get(key1);
		if (localMap == null)
		{
			return null;
		}
		V o = localMap.remove(key2);
		//cleanup!
		if (localMap.isEmpty())
		{
			map.remove(key1);
		}
		return o;
	}

	/**
	 * Get the Set of keys
	 * @return set of keys
	 */
	public Set<K1> getKeySet()
	{
		return new HashSet<K1>(map.keySet());
	}

	/**
	 * Clear
	 */
	public void clear()
	{
		map.clear();
	}

	/**
	 * Returns true if the map is empty
	 * @return true if the map is empty
	 */
	public boolean isEmpty()
	{
		return map.isEmpty();
	}

	public Object clone() throws CloneNotSupportedException
	{
		DoubleKeyMap<K1, K2, V> dkm = (DoubleKeyMap<K1, K2, V>) super.clone();
		dkm.map = new HashMap<K1, Map<K2, V>>();
		for (Iterator<K1> it = map.keySet().iterator(); it.hasNext();) {
			K1 key = it.next();
			Map<K2, V> m = map.get(key);
			dkm.map.put(key, new HashMap<K2, V>(m));
		}
		return dkm;
	}
}

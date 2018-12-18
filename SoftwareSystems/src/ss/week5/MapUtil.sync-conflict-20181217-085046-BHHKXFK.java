package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {

	/*
	 * @ requires map != null;
	 * 
	 * Am I allowed to do that way of ensuring a boolean result? Or should I have:
	 * (condition ==> \result == true) and (!condition ==> \result == false)?
	 * 
	 * @ ensures \result = (\forall Object k, v, w; ; map.contains(k, v) &&
	 * !k.equals(w) ==> !map.contains(w, v))
	 * 
	 * @ pure
	 */
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
		boolean result = true;
		HashSet<V> values = new HashSet<V>();

		for (Map.Entry<K, V> entry : map.entrySet()) {

			if (values.contains(entry.getValue())) {
				// Not injective!
				result = false;
				break;
			}

			values.add(entry.getValue());

		}
		return result;
	}

	/*
	 * @ requires map != null;
	 * 
	 * @ requires range != null;
	 * 
	 * @ ensures \result = range.containsAll(map.values()) &&
	 * map.values().containsAll(range);
	 * 
	 * @ pure
	 */
	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		return range.containsAll(map.values()) && map.values().containsAll(range);
	}

	/*
	 * @ requires map != null;
	 * 
	 * @ ensures (\forall Object k, v; ; \result.hasKey(v) &&
	 * \result.get(v).contains(k) <==> map.contains(k, v))
	 * 
	 * @ pure
	 */
	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		HashMap<V, Set<K>> result = new HashMap<V, Set<K>>();

		for (Map.Entry<K, V> entry : map.entrySet()) {
			V value = entry.getValue();

			if (result.containsKey(value)) {
				result.get(value).add(entry.getKey());
			} else {
				HashSet<K> set = new HashSet<K>();
				set.add(entry.getKey());
				result.put(value, set);
			}

		}
		return result;
	}

	/*
	 * @ requires map != null;
	 * 
	 * @ ensures !isOneOnOne(map) ==> \result = null;
	 * 
	 * @ ensures isOnOnOne(map) ==> (\forall Object k, v; ; \result.hasKey(v) &&
	 * \result.get(v) == k <==> map.contains(k, v))
	 * 
	 * @ pure
	 */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> result = null;

		// We only need to check for whether the map is injective (one-on-one).
		// As a java Map cannot have a value without key, and is therefore always
		// surjective.
		if (isOneOnOne(map)) {
			result = new HashMap<V, K>();

			for (Map.Entry<K, V> entry : map.entrySet()) {
				result.put(entry.getValue(), entry.getKey());
			}
		}

		return result;
	}

	/*
	 * @ requires f != null;
	 * 
	 * @ requires g != null;
	 * 
	 * @ ensures \result = g.keySet().containsAll(f.values());
	 * 
	 * @ pure
	 */
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		return g.keySet().containsAll(f.values());
	}

	/*
	 * @ requires f != null;
	 * 
	 * @ requires g != null;
	 * 
	 * @ ensures !compatible(f, g) ==> result == null;
	 * 
	 * @ ensures compatible(f, g) ==> (\forall Object k, v, w; ; \result.contains(k,
	 * w) <==> f.contains(k, v) && g.contains(v, w))
	 * 
	 * @ pure
	 */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map<K, W> result = null;

		if (compatible(f, g)) {
			// We can compose the maps.
			result = new HashMap<K, W>();

			for (Map.Entry<K, V> entry : f.entrySet()) {
				result.put(entry.getKey(), g.get(entry.getValue()));
			}
		}

		return result;
	}
}

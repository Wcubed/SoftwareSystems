package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
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

	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		return range.containsAll(map.values()) && map.values().containsAll(range);
	}

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

	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> result = null;
		
		// We only need to check for whether the map is injective (one-on-one).
		// As a java Map cannot have a value without key, and is therefore always surjective.
		if (isOneOnOne(map)) {
			result = new HashMap<V, K>();
			
			for (Map.Entry<K, V> entry : map.entrySet()) {
				result.put(entry.getValue(), entry.getKey());
			}
		}
		
		return result;
	}

	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		// TODO: implement, see exercise P-5.4
		return false;
	}

	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		// TODO: implement, see exercise P-5.5
		return null;
	}
}

package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

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
		// TODO: implement, see exercise P-5.3
		return null;
	}

	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		// TODO: implement, see exercise P-5.3
		return null;
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

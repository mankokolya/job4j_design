package cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.function.Function;

public class SoftReferenceCache<K, V> {
    private final HashMap<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V val) {
        cache.put(key, new SoftReference<>(val));
    }

    public V get(K key, Function<K, V> getValue) {
        boolean containsKey = cache.containsKey(key);
            return containsKey ? getContainsKeyTrue(key, getValue) : getContainsKeyFalse(key, getValue);
    }

    private V getContainsKeyFalse(K key, Function<K, V> getValue) {
        V val = getValue.apply(key);
        this.put(key, val);
        return val;
    }

    private V getContainsKeyTrue(K key, Function<K, V> getValue) {
        V v = cache.get(key).get();
        if (v != null) {
            return v;
        }
        v = getValue.apply(key);
        this.put(key, v);
        return v;
    }
}

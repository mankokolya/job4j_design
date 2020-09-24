package cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class SoftReferenceCache<K, V> {
    private final HashMap<K, SoftReference<V>> cache = new HashMap<>();;

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key, Function<K, V> getValue) {
        SoftReference<V> reference = cache.get(key);
        if (reference != null ) {
            return reference.get();
        }
        V value = getValue.apply(key);
        this.put(key, value);
        return value;
    }
}

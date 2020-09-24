package cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.function.Function;

public class SoftReferenceCache<K, V> {
    private final HashMap<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, Function<K, V> getValue) {
        cache.put(key, new SoftReference<>(getValue.apply(key)));
    }

    public V get(K key, Function<K, V> getValue) {
        SoftReference<V> reference = cache.get(key);
        if (reference != null) {
            return reference.get();
        }
        this.put(key, getValue);
        return this.cache.get(key).get();
    }
}

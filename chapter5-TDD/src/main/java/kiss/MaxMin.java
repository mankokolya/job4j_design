package kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findValue(value, comparator);
    }
    
    private <T> T findValue(List<T> values, Comparator<T> comparator) {
        T  result= values.get(0);
        for (T value : values) {
            result = comparator.compare(result, value) >= 0 ? result : value;
        }
        return result; 
    }
}

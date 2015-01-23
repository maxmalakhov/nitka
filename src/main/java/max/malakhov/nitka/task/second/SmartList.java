package max.malakhov.nitka.task.second;

import java.util.*;

/**
 * Created by max on 1/20/15.
 */
public class SmartList<T> extends ArrayList<T> {

    public static final int LIMIT = 3;

    public void purge() {
        purge(false);
    }

    public void purge(boolean serial) {
        List<List<T>> list = new ArrayList<List<T>>();

        if (serial) {
            list.addAll(analyzeSerial());
        } else {
            list.addAll(analyze());
        }

        cleanup(list);
    }

    private Collection<List<T>> analyzeSerial() {
        List<List<T>> list = new ArrayList<List<T>>();

        T previousValue = null;
        List<T> previousSequence = null;
        for (T value : this) {
            if (!value.equals(previousValue)) {
                // add new sequence
                List<T> sequence = new ArrayList<T>(1);
                list.add(sequence);
                previousSequence = sequence;
            }
            // update sequence
            if(previousSequence != null) {
                previousSequence.add(previousValue);
            }

            previousValue = value;
        }
        return list;
    }

    private Collection<List<T>> analyze() {
        Map<T, List<T>> map = new HashMap<T, List<T>>();

        for (T value : this) {
            if (!map.containsKey(value)) {
                // add new sequence
                map.put(value, new ArrayList<T>());
            }
            // update sequence
            map.get(value).add(value);

        }

        return map.values();
    }

    private void cleanup(Collection<List<T>> sequences) {
        for(List<T> sequence : sequences) {
            if (sequence.size() >= LIMIT) {
                this.removeAll(sequence);
            }
        }
    }
}


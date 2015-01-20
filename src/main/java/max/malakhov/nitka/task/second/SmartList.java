package max.malakhov.nitka.task.second;

import java.util.*;

/**
 * Created by max on 1/20/15.
 */
public class SmartList extends ArrayList<Long> {

    public static final int LIMIT = 3;

    public void removeDubs() {
        removeDubs(false);
    }

    public void removeDubs(boolean serial) {
        Map<Long, ValueInfo> info = new HashMap<Long, ValueInfo>();

        Long previous = Long.MAX_VALUE;
        for (Iterator<Long> iterator = this.iterator(); iterator.hasNext();) {
            Long value = iterator.next();

            updateInfo(info, value, previous);

            if(checkValue(info, value, serial)) {
                iterator.remove();
            }
            previous = value;
        }
    }

    private void updateInfo(Map<Long, ValueInfo> info, Long value, Long previous) {
        if (!info.containsKey(value)) {
            // add new value
            info.put(value, new ValueInfo(value));
        } else {
            // update count and sequence
            info.get(value).increment(previous);
        }
    }

    private boolean checkValue(Map<Long, ValueInfo> info, Long value, boolean serial) {
        if (serial) {
            if (info.containsKey(value) && info.get(value).getSequence() >= LIMIT ) {
                return true;
            }
        } else {
            if (info.containsKey(value) && info.get(value).getCount() >= LIMIT ) {
                return true;
            }
        }
        return false;
    }
}

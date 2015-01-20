package max.malakhov.nitka.task.second;

/**
 * Created by max on 1/20/15.
 */
public class ValueInfo {

    private final long value;
    private int count = 1;
    private int sequence = 1;

    public ValueInfo(Long value) {
        this.value = value;
    }

    public void increment(Long previous) {
        count++;
        if (value == previous) {
            sequence++;
        } else {
            sequence = 1;
        }
    }

    public long getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}

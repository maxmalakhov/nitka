package max.malakhov.nitka.task.second;

import org.testng.annotations.Test;

public class SmartListTest {

    @Test
    public void testPurgeSerial() throws Exception {
        SmartList<Long> list = generateList();

        System.out.println("List content before: ");
        print(list);

        list.purge(true);

        System.out.println("List content after: ");
        print(list);
    }

    @Test
    public void testPurge() throws Exception {
        SmartList<Long> list = generateList();

        System.out.println("List content before: ");
        print(list);

        list.purge();

        System.out.println("List content after: ");
        print(list);
    }

    private SmartList<Long> generateList() {
        SmartList<Long> list = new SmartList<Long>();

        list.add(1L);
        list.add(13L);
        list.add(1L);
        list.add(13L);
        list.add(1L);
        list.add(7L);
        list.add(7L);
        list.add(7L);
        list.add(7L);
        list.add(1L);
        list.add(13L);
        list.add(1L);
        list.add(13L);
        list.add(1L);
        list.add(1L);
        list.add(5L);
        list.add(5L);
        list.add(5L);
        list.add(5L);
        list.add(1L);
        list.add(2L);
        list.add(2L);
        list.add(1L);

        return list;
    }

    private void print(SmartList<Long> list) {
        for(Long value: list) {
            System.out.print(" " + value);
        }
        System.out.println("");
    }
}
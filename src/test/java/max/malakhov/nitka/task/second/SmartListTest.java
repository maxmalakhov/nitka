package max.malakhov.nitka.task.second;

import org.testng.annotations.Test;

public class SmartListTest {

    @Test
    public void testRemoveSerialDubs() throws Exception {
        SmartList list = generateList();
        print(list);
        list.removeDubs(true);
        print(list);
    }

    @Test
    public void testRemoveDubs() throws Exception {
        SmartList list = generateList();
        print(list);
        list.removeDubs();
        print(list);
    }

    private SmartList generateList() {
        SmartList list = new SmartList();

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

    private void print(SmartList list) {
        System.out.println("List content: ");
        for(Long value: list) {
            System.out.print(" " + value);
        }
        System.out.println("");
    }
}
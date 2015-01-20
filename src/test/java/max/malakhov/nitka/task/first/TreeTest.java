package max.malakhov.nitka.task.first;

import org.testng.annotations.Test;

public class TreeTest {

    @Test
    public void testTree() throws Exception {
        Tree tree = new Tree();

        tree.insert(26);
        tree.insert(11);
        tree.insert(31);
        tree.insert(6);
        tree.insert(17);
        tree.insert(44);
        tree.insert(2);
        tree.insert(39);
        tree.insert(20);

        System.out.println("Size of tree: " + tree.size());
        System.out.println("Height of specific node tree: " + tree.height(new Node(17)));
        System.out.println("Height of root tree: " + tree.height());

        tree.print();
    }
}
package max.malakhov.nitka.task.first;

/**
 * Created by max on 1/20/15.
 */
public class Tree {

    private Node root;

    public void insert(int value){

        if (root == null) {
            root = new Node(value);
        } else {

            Node current = root;
            while(current != null){

                if (value < current.getValue()) {

                    if (current.getLeft() == null) {
                        current.setLeft(new Node(value));
                        return;
                    } else {
                        current = current.getLeft();
                    }

                } else {

                    if (current.getRight() == null) {
                        current.setRight(new Node(value));
                        return;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }


    public void print(Node node){

        if (node == null) {
            return;
        } else {
            print(node.getLeft());
            System.out.println(node.getValue());
            print(node.getRight());
        }

    }

    public void print(){
        print(root);
    }

    public int size(Node node){

        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }

    }

    public int size(){
        return size(root);
    }

    public int height(Node node){

        if(node == null){
            return 0;
        } else {
            int leftSideHeight = height(node.getLeft());
            int rightSideHeight = height(node.getRight());

            return 1 + Math.max(leftSideHeight, rightSideHeight);
        }

    }

    public int height(){
        return height(root);
    }
}
package linkedList;

/**
 * Created by cdyujing7 on 2018/8/11.
 */
public class LinkedListAdd {

    public static void main(String[] args) {
        Node one5 = new Node();
        one5.setValue(9);
        Node one4 = new Node();
        one4.setValue(8);
        one4.setNext(one5);
        Node one3 = new Node();
        one3.setValue(7);
        one3.setNext(one4);
        Node one2 = new Node();
        one2.setValue(9);
        one2.setNext(one3);
        Node one1 = new Node();
        one1.setValue(9);
        one1.setNext(one2);

        Node two3 = new Node();
        two3.setValue(9);
        Node two2 = new Node();
        two2.setValue(6);
        two2.setNext(two3);
        Node two1 = new Node();
        two1.setValue(7);
        two1.setNext(two2);


        Node result = add(one1, two1);
        while (result != null) {
            System.out.print(result.getValue());
            System.out.print(" > ");
            result = result.getNext();
        }
    }

    public static Node add(Node one, Node two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        Node resultOne = reverseList(one);
        Node resultTwo = reverseList(two);

        Node resultReturn = new Node();
        Node record = resultReturn;
        Integer carryOut = 0;
        while (resultOne != null && resultTwo != null) {
            record.setValue((resultOne.getValue() + resultTwo.getValue() + carryOut)%10);
            carryOut = resultOne.getValue() + resultTwo.getValue() + carryOut >= 10 ? 1 : 0;
            if (resultOne.getNext() != null && resultTwo.getNext() != null) {
                Node tmp = new Node();
                record.setNext(tmp);
                record = tmp;
            }
            resultOne = resultOne.getNext();
            resultTwo = resultTwo.getNext();
        }

        Node left = resultOne == null ? resultTwo : resultOne;
        while (left != null) {
            Node tmp = new Node();
            tmp.setValue((left.getValue() + carryOut)%10);
            carryOut = left.getValue() + carryOut >= 10 ? 1 : 0;
            record.setNext(tmp);
            record = tmp;
            left = left.getNext();
        }

        if (carryOut == 1) {
            Node tmp = new Node();
            tmp.setValue(1);
            record.setNext(tmp);
        }

        return reverseList(resultReturn);

    }

    public static Node addRemain(Node record, Node node, int carryOut) {
        while (node != null) {
            Node tmp = record;
            record = new Node();
            record.setValue((node.getValue() + carryOut)%10);
            carryOut = node.getValue() + carryOut >= 10 ? 1 : 0;
            tmp.setNext(record);
            node = node.getNext();
        }
        return record;
    }

    public static Node reverseList(Node node) {
        if (node == null) {
            return node;
        }
        Node result = new Node();
        while (node != null) {
            result.setValue(node.getValue());
            Node tmp = result;
            if (node.getNext() != null) {
                result = new Node();
                result.setNext(tmp);
            }
            node = node.getNext();
        }
        return result;
    }
}

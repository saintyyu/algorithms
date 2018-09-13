import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by cdyujing7 on 2018/8/5.
 */
public class localTest {

    static class TestNode {
        int value;
        TestNode next;
    }
    public static void main(String[] args) {

        Long integer = 2147483647L;

        System.out.println(integer*2);
        System.out.println(4294967295L);
        System.out.println(255*Math.pow(256,3) + 255*Math.pow(256,2) + 255*Math.pow(256,1) + 255);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2,32)-1);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        LinkedList linkedList = new LinkedList();
//        stack.peek();

        TestNode testNode = new TestNode();
        testNode.value = 1;
        TestNode testNode1 = new TestNode();
        testNode1.value = 2;
        testNode.next = testNode1;


        Socket socket = new Socket();
        try {
            InputStream inputStream = socket.getInputStream();
            int value = inputStream.read();
            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

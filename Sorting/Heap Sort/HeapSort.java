import java.utils.Scanner;

public class HeapSort {

    void maxHeap(){
        if (length == 0) {
            return;
        }
        root = new Node(array[0]);
        System.out.println("Root is: " + root.value);
        
        Node[] nodes = new Node[length];
        nodes[0] = root;

        for(int i = 0; i<length; i++){
            if (2 * i + 1 < length) {
                nodes[2 * i + 1] = new Node(array[2 * i + 1]);
                if(nodes[2 * i + 1]>nodes[i]){
                    nodes[i-1] = nodes[2 * i + 1];
                    nodes[2 * i + 1].left = nodes[i];
                    System.out.println(nodes[i].left.value + " inserted to the left of " + nodes[i].value);
                }
                nodes[i].left = nodes[2 * i + 1];
                System.out.println(nodes[i].left.value + " inserted to the left of " + nodes[i].value);
            }
            if (2 * i + 2 < length) {
                nodes[2 * i + 2] = new Node(array[2 * i + 2]);
                nodes[i].right = nodes[2 * i + 2];
                System.out.println(nodes[i].right.value + " inserted to the right of " + nodes[i].value);
            }
        }

    }

    void swap(){
        if(current.left < current){
            parent = current.left;
            current.left = current;
        }
        if(current.left < current){
            parent = current.left;
            current.left = current;
        }
    }

    public static void main(String[] args){
        Scanner input = Scanner(System.in);
        HeapSort hs = new HeapSort();
        System.out.println("Enter size of array: ");
        int n = input.nextInt();
        int[] array = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i<n; i++){
            array[i] = input.nextInt();
        }
    }
}

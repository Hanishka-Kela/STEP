class Node2 {
    int data;
    Node2 next;
    Node2(int data) {
        this.data = data;
        this.next = null;
    }
}
class DetectLoop {
    Node2 head;
    void createLoop() {
        head = new Node2(10);
        Node2 n2 = new Node2(20);
        Node2 n3 = new Node2(30);
        Node2 n4 = new Node2(40);
        Node2 n5 = new Node2(50);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
    }
    boolean detectAndRemoveLoop() {
        Node2 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow);
                return true;
            }
        }
        return false;
    }
    void removeLoop(Node2 loopNode) {
        Node2 ptr1 = head;
        while (true) {
            Node2 ptr2 = loopNode;
            while (ptr2.next != loopNode && ptr2.next != ptr1)
                ptr2 = ptr2.next;
            if (ptr2.next == ptr1) {
                ptr2.next = null;
                return;
            }
            ptr1 = ptr1.next;
        }
    }
    void display() {
        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DetectLoop list = new DetectLoop();
        list.createLoop();
        if (list.detectAndRemoveLoop())
            System.out.println("Loop detected and removed");
        else
            System.out.println("No loop found");
        list.display();
    }
}

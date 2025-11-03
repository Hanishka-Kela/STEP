class DNode {
    int data;
    DNode prev, next;
    DNode(int data) {
        this.data = data;
    }
}
class DoublyListDelete {
    DNode head;
    void insert(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }
    void deleteAll(int value) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data == value) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
    }
    void display() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyListDelete list = new DoublyListDelete();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(20);
        list.insert(40);
        System.out.print("Before: ");
        list.display();
        list.deleteAll(20);
        System.out.print("After: ");
        list.display();
    }
}

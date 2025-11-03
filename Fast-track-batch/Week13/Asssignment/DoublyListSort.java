class DNode2 {
    int data;
    DNode2 prev, next;
    DNode2(int data) {
        this.data = data;
    }
}
class DoublyListSort {
    DNode2 head;
    void insert(int data) {
        DNode2 newNode = new DNode2(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode2 temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }
    void bubbleSort() {
        boolean swapped;
        if (head == null) return;
        do {
            swapped = false;
            DNode2 temp = head;
            while (temp.next != null) {
                if (temp.data > temp.next.data) {
                    int t = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = t;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }
    void display() {
        DNode2 temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyListSort list = new DoublyListSort();
        list.insert(40);
        list.insert(10);
        list.insert(30);
        list.insert(20);
        System.out.print("Before: ");
        list.display();
        list.bubbleSort();
        System.out.print("After: ");
        list.display();
    }
}

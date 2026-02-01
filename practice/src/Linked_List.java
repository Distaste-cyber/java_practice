public class Linked_List {
    Node head;

    public Linked_List(Node head) {
        this.head = head;
    }

    public void traverseForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.rollNo + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Traverse backward
    public void traverseBackward() {
        if (head == null)
            return;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.rollNo + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public void insert(String rollNo, String grade) {
        Node inserted = new Node(rollNo);
        inserted.grade = grade;

        if (this.head == null) {
            this.head = inserted;
            return;
        }

        Node curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = inserted;

    }

    public Node linearSearch(String data) {
        if (this.head == null) {
            return null;
        }

        Node curr = this.head;
        while (curr != null) {
            if (curr.rollNo == data) {
                return curr;
            }
            curr = curr.next;
        }

        return null;
    }

    public void insert_at_begining(String rollNo, String grade) {
        Node inserted = new Node(rollNo);
        inserted.grade = grade;

        inserted.next = this.head;
        this.head = inserted;
        return;
    }

    public void insert(String data, String grade, int pos) {
        Node inserted = new Node(data);
        inserted.grade = grade;
        Node curr = this.head;
        int ptr = 0;
        if (ptr == pos) {
            inserted.next = this.head;
            this.head = inserted;
            return;
        }

        while (curr.next != null && ptr != pos) {
            curr = curr.next;
            ptr++;
        }
        inserted.next = curr.next;
        curr.next = inserted;
    }

    public void print() {
        Node curr = this.head;

        while (curr != null) {
            System.out.print(curr.rollNo + ": Grade: " + curr.grade + " -> ");
            curr = curr.next;

        }
    }

    public Node delete(String rollNo) {
        Node curr = this.head;
        Node prev = null;

        if (this.head == null) {
            return null;
        }

        if (curr.rollNo == rollNo) {
            this.head = curr.next;
            return curr;
        }

        while (curr != null) {
            if (curr.rollNo == rollNo) {
                prev.next = curr.next;

                return curr;
            }

            prev = curr;
            curr = curr.next;
        }

        return null;
    }
}
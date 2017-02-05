package darkRealm.CTCI.LinkedLists;

/**
 * Created by Jayam on 1/4/2017.
 */
public class LinkedList {
  public Node head;
  public Node tail;
  int size;

  public void appendToTail(Node d) {
    if (d == null) {
      return;
    }
    if (head == null) {
      head = new Node(d.data);
      tail = head;
      size++;
      return;
    }
    tail.next = new Node(d.data);
    tail = tail.next;
    size++;
  }

  public void add(int d) {
    appendToTail(new Node(d));
  }

  public void appendToHead(Node d) {
    if (head == null) {
      head = new Node(d.data);
      tail = head;
      size++;
      return;
    }
    Node temp = new Node(d.data);
    temp.next = head;
    head = temp;
    size++;
  }

  public Node removeFirst() {
    if (size() > 0) {
      Node temp = head;
      head = head.next;
      size--;
      return temp;
    }
    return null;
  }

  public Node removeLast() {
    Node trav = head;
    while (trav.next.next != null) {
      trav = trav.next;
    }
    Node temp = trav;
    tail = trav;
    size--;
    return temp;
  }

  public int size() {
    return size;
  }

  public LinkedList clone() {
    Node travA = this.head;
    LinkedList clone = new LinkedList();
    while (travA != null) {
      clone.add(travA.data);
      travA = travA.next;
    }
    return clone;
  }

  public void addAll(LinkedList list) {
    Node trav = list.head;
    while (trav != null) {
      if (this.tail == null) {
        this.tail = new Node(trav.data);
      } else {
        this.tail.next = new Node(trav.data);
      }
      this.tail = this.tail.next;
      trav = trav.next;
    }
  }

  public Node reverseBetween(int m, int n) {
    if (m < 1 || n < 1) {
      return head;
    }
    Node trav = head;
    Node pos = head;
    for (int i = 1; i < m; i++) {
      pos = trav;
      trav = trav.next;
    }
    Node prev = null;
    Node curr = trav;
    Node last = curr;
    Node temp = curr.next;
    int t = m;
    while (t <= n) {
      temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
      t++;
    }
    if (m == 1) {
      head = prev;
    } else {
      pos.next = prev;
    }
    last.next = temp;
    return head;
  }

  public Node getMid(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node mid = slow;
    if (fast == null) {//even
      mid = slow;
    } else {
      mid = slow.next;
    }
    return mid;
  }

  // will go till mid & reverse the link from mid to end , now will read from haed & mid & keep matching if all matched true
  public boolean isPalindrome(Node head) {
    if (head == null) {
      return true;
    }
    Node trav = head;
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node otherHalf;
    if (fast == null) { // even
      otherHalf = slow;
    } else {  // odd
      otherHalf = slow.next;
    }
    Node prev = null;
    Node trav2 = otherHalf;
    Node temp;
    while (trav2 != null) {
      temp = trav2.next;
      trav2.next = prev;
      prev = trav2;
      trav2 = temp;
    }
    otherHalf = prev;
    while (otherHalf != null & trav != slow) {
      if (otherHalf.data != trav.data) {
        break;
      }
      trav = trav.next;
      otherHalf = otherHalf.next;
    }
    if (otherHalf != null) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    Node trav = head;
    while (trav != null) {
      stringBuilder.append(" " + trav.data);
      trav = trav.next;
    }
    return stringBuilder.toString();
  }
}
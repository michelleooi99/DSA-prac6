package version3;

public class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T> {

  private Node firstNode;
  private int length;

  public SortedLinkedList() {
    firstNode = null;
    length = 0;
  }
  
  //method 1 : add
//  public SortedLinkedList(T[] array) {
//      for (int i = 0; i < array.length; i++) {
//          add(array[i]);
//      }
//      length++;
//  }
  
  //method 2 : add to front
//  public SortedLinkedList(T[] array) {
//      for (int i = array.length - 1; i >= 0; i--) {
//          Node newNode = new Node(array[i]);
//          newNode.next = firstNode;
//          firstNode = newNode;
//      }
//      length++;
//  }
  
  //method 3 : add to back
  public SortedLinkedList(T[] array) {
        Node lastNode = firstNode;

        for (int i = 0; i < array.length; i++) {
            Node newNode = new Node(array[i]);
      
          if (lastNode == null) {
              firstNode = newNode;
              lastNode = newNode;
          } else {
              lastNode.next = newNode;
              lastNode = newNode;
          }
          
          length++;
      }
  }

  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);

    Node nodeBefore = null;							// For linked list traversal: to reference the node before the current node
    Node currentNode = firstNode;				// For linked list traversal: to reference the current node
    while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
      nodeBefore = currentNode;
      currentNode = currentNode.next;
    }

    if (isEmpty() || (nodeBefore == null)) { // CASE 1: add at beginning
      newNode.next = firstNode;
      firstNode = newNode;
    } else {	// CASE 2: add in the middle or at the end, i.e. after nodeBefore
      newNode.next = currentNode;
      nodeBefore.next = newNode;
    }
    length++;
    
//    firstNode = add(newEntry, firstNode);
//    length++;
    return true;  
  }

  private Node add(T newEntry, Node currNode)
  {
      if((currNode == null)||newEntry.compareTo(currNode.data)<=0)
        {
            currNode = new Node(newEntry, currNode);
        } else {
            Node nodeAfter = add(newEntry, currNode.next);
            currNode.next = nodeAfter;
        }
        return currNode;
    }

    public boolean remove(T anEntry) {

        if (isEmpty()) {
            return false;
        } else {
            Node currentNode = firstNode;

            if (currentNode.data.equals(anEntry)) {
                if (currentNode.next == null) {
                    currentNode = null;
                } else {
                    firstNode.next = currentNode;
                }
                return true;
            }

            while (currentNode.next != null) {
                if (currentNode.next.data.equals(anEntry)) {
                    if (currentNode.next.next == null) {
                        currentNode = null;
                    } else {
                        currentNode.next = currentNode.next.next;
                    }
                    return true;
                }
                currentNode = currentNode.next;
            }
            return false;
        }
  }

  public int getPosition(T anEntry) {
    throw new UnsupportedOperationException();	// Left as Practical exercise
  }

  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result;
  }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {

            if (currentNode.data.compareTo(anEntry) > 0) {
                return found;
            } else if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
    return found;
    
    
//    boolean found = false;
//    Node tempNode = firstNode;
//    int pos = 1;
//
//    while (!found && (tempNode != null)) {
//      if (anEntry.compareTo(tempNode.data) <= 0) {
//        found = true;
//      } else {
//        tempNode = tempNode.next;
//        pos++;
//      }
//    }
//    System.out.println("\n***TRACE: tempNode.data is " + tempNode.data + " " + pos);
//    if (tempNode != null && tempNode.data.equals(anEntry))
//      return true;
//    else 
//      return false;
  }

  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      if (givenPosition == 1) {      	// CASE 1: remove first entry
        result = firstNode.data;     	// save entry to be removed 
        firstNode = firstNode.next;		// update firstNode to point to the next node
      } else {                         	// CASE 2: remove interior entry or last entry
        Node nodeBefore = firstNode;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }
        result = nodeBefore.next.data;  	// save entry to be removed	
        nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the 
      } 															// one to be deleted (to disconnect node from chain)

      length--;
    }

    return result;
  }

  public final void clear() {
    firstNode = null;
    length = 0;
  }

  public int getLength() {
    return length;
  }

  public boolean isEmpty() {
    return (length == 0);
  }

  public boolean isFull() {
    return false;
  }

  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";;
      currentNode = currentNode.next;
    }
    return outputStr;
  }

  private class Node {

    private T data;
    private Node next;

    private Node(T dataPortion) {
      data = dataPortion;
      next = null;
    }

    private Node(T dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    }
  }
}

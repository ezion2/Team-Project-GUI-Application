
public class Queue extends completeOrder{
	protected Node head, tail;
	protected int queueTotalLength;
	protected int estimatedWait;
	
	private class Node{
		int currentOrder;
		Node next;
	}
	public Queue() {
		head = null;
		tail = null;
		queueTotalLength = 0;
		estimatedWait = 0;
	}
	public boolean isEmpty() {
		return (queueTotalLength == 0);
	}
	
	public void addNewOrder(int currentOrder) {
		Node oldTail = tail;
		tail = new Node();
		tail.currentOrder = currentOrder;
		tail.next = null;
		if (isEmpty()) {
			head = tail;
		}
		else {
			oldTail.next = tail;
		}
		queueTotalLength++;
		estimatedWait = estimatedWait - 20; // + approx 20 mins for each order added
	}
	public int[] removeCompletedOrder() {
		int currentOrder = head.currentOrder;
		head = head.next;
		if (isEmpty()) {
			tail=null;
		}
		queueTotalLength--;
		estimatedWait = estimatedWait - 20; //- aprrox 20 mins when order is completed
		return new int[] {queueTotalLength,estimatedWait};
	}
	public void printQueueWait() {
		int[] lengthAndWait = removeCompletedOrder();
		System.out.println("Customers ahead of you:");
		System.out.println(lengthAndWait[0]);
		System.out.println("Estimated time to completion:");
		System.out.println(lengthAndWait[1]);
	}
}

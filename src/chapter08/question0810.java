package chapter08;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class question0810 {

	/**
	 * This is an implementation of a bounded queue in Java. This implementation
	 * supports common queue operations like enqueue and dequeue. Internally, an
	 * array of integers is used to store the elements in the queue. The size of
	 * the array expands as more elements are added to the queue. The enqueue()
	 * operation runs in amortized constant time and the dequeue operation runs
	 * in constant time.
	 * 
	 * @author Tao Qian (taoqian_2015@depauw.edu)
	 * 
	 */
	public class Queue {

		private int[] block;
		private int head;
		private int tail;
		private int size;
		private int bound;
		private final static int INITIAL_CAPACITY = 10;

		/**
		 * Constructs an empty queue with the specified initial capacity and
		 * bound.
		 * 
		 * @param initialCapacity
		 *            the initial capacity of the queue
		 * @param bound
		 *            the bound of the queue
		 * @exception IllegalArgumentException
		 *                if the specified initial capacity is negative
		 */
		public Queue(int initialCapacity, int bound) {
			if (initialCapacity < 0)
				throw new IllegalArgumentException("Illegal Capacity: "
						+ initialCapacity);
			if (bound < initialCapacity)
				throw new IllegalArgumentException(
						"Bound cannot be smaller than the capacity");
			this.block = new int[initialCapacity];
			this.bound = bound;
			head = 0;
			tail = 0;
			size = 0;
		}

		/**
		 * Constructs an empty queue with an initial capacity of 0, and the
		 * specified bound.
		 * 
		 * @param bound
		 *            the bound of the queue
		 */
		public Queue(int bound) {
			this(0, bound);
		}

		/**
		 * Constructs an empty list with an initial capacity of 10, and bound of
		 * Integer.MAX_VALUE, though the actually bound is a smaller value
		 * determined by the VM and the memory available.
		 * 
		 */
		public Queue() {
			this(INITIAL_CAPACITY, Integer.MAX_VALUE);
		}

		/**
		 * Increases the capacity of this <tt>Queue</tt> instance, if necessary,
		 * to ensure that it can hold at least the number of elements specified
		 * by the minimum capacity argument.
		 * 
		 * @param minCapacity
		 *            the desired minimum capacity, assumed to be no greater
		 *            than the bound
		 */
		private void ensureCapacity(int minCapacity) {
			int oldCapacity = block.length;
			if (minCapacity <= oldCapacity)// No need to expand the block
				return;

			int newCapacity = (oldCapacity * 3) / 2 + 1;// Increase the size by
														// at
														// least 50%.
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			if (newCapacity > bound)
				newCapacity = bound;

			// Copy data in the original array to a new one
			int[] newBlock;
			if (head != tail)// If tail did not wrap around
			{
				newBlock = Arrays.copyOf(block, newCapacity);
			} else// if tail wrapped around(head == tail)
			{
				newBlock = new int[newCapacity];
				int newPointer = 0;
				for (int i = head; i < oldCapacity; i++) {
					newBlock[newPointer] = block[i];
					newPointer++;
				}
				for (int i = 0; i < head; i++) {
					newBlock[newPointer] = block[i];
					newPointer++;
				}
				// Reset head and tail
				head = 0;
				tail = oldCapacity;
			}
			block = newBlock;
		}

		/**
		 * Add an item to the end of the queue.
		 * 
		 * @param item
		 *            the item to be added.
		 * @exception IllegalArgumentException
		 *                If the size of the queue reaches its bound
		 */
		public void enqueue(int item) {
			size++;
			if (size > bound) {
				throw new IllegalArgumentException(
						"Size of queue exceeded bound");
			}
			ensureCapacity(size);
			if (tail == block.length)
				tail = 0;
			block[tail] = item;
			tail++;
		}

		/**
		 * Remove an item from the front of the queue.
		 * 
		 * @return the item at the front of the queue
		 * @exception NoSuchElementException
		 *                If the queue is empty
		 */
		public int dequeue() {
			if (size == 0)// If array is empty
				throw new NoSuchElementException();
			size--;
			int item = block[head];
			head++;
			if (head == block.length)
				head = 0;
			return item;
		}
	}

}

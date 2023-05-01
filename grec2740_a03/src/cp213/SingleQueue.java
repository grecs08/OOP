package cp213;

/**
 * A single linked queue structure of <code>Node T</code> objects. Only the
 * <code>T</code> value contained in the queue is visible through the standard
 * queue methods. Extends the <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2022-10-26
 * @param <T> the SingleQueue data type.
 */
public class SingleQueue<T> extends SingleLink<T> {

    /**
     * Combines the contents of the left and right SingleQueues into the current
     * SingleQueue. Moves nodes only - does not refer to values in any way, or call
     * the high-level methods insert or remove. left and right SingleQueues are
     * empty when done. Nodes are moved alternately from left and right to this
     * SingleQueue.
     *
     * You have two source queues named left and right. Move all nodes from these
     * two queues to the current queue. It does not make a difference if the current
     * queue is empty or not, just get nodes from the right and left queues and add
     * them to the current queue. You may use any appropriate SingleLink helper
     * methods available.
     *
     * Do not assume that both right and left queues are of the same length.
     *
     * @param left  The first SingleQueue to extract nodes from.
     * @param right The second SingleQueue to extract nodes from.
     */
    public void combine(final SingleQueue<T> left, final SingleQueue<T> right) {
	boolean flag = true;
	while (!left.isEmpty() || !right.isEmpty()) {

	    if (flag) {
		if (!left.isEmpty()) {
		    this.moveFront(left);
		} else {
		    this.moveFront(right);
		}
	    } else {
		if (!right.isEmpty()) {
		    this.moveFront(right);
		} else {
		    this.moveFront(left);
		}
	    }
	    flag = !flag;
	}

	return;
    }

    /**
     * Adds value to the rear of the queue. Increments the queue length.
     *
     * @param datum The value to added to the rear of the queue.
     */
    public void insert(final T datum) {
	SingleNode<T> node = new SingleNode<T>(datum, null);
	if (this.isEmpty()) {
	    this.front = node;
	    this.rear = node;
	} else {
	    this.rear.setNext(node);
	    this.rear = node;
	}
	this.length++;

	return;
    }

    /**
     * Returns the front value of the queue and removes that value from the queue.
     * The next node in the queue becomes the new first node. Decrements the queue
     * length.
     *
     * @return The value at the front of the queue.
     */
    public T remove() {
	T datum = null;
	if (!this.isEmpty()) {
	    SingleNode<T> node = this.front;
	    this.front = this.front.getNext();
	    node.setNext(null);
	    this.length--;
	    datum = node.getDatum();
	}
	return datum;
    }

    /**
     * Splits the contents of the current SingleQueue into the left and right
     * SingleQueues. Moves nodes only - does not move value or call the high-level
     * methods insert or remove. this SingleQueue is empty when done. Nodes are
     * moved alternately from this SingleQueue to left and right. left and right may
     * already contain values.
     *
     * This is the opposite of the combine method.
     *
     * @param left  The first SingleQueue to move nodes to.
     * @param right The second SingleQueue to move nodes to.
     */
    public void splitAlternate(final SingleQueue<T> left, final SingleQueue<T> right) {
	boolean flag = true;
	while (this.length > 0) {
	    if (flag) {
		left.moveFront(this);
	    } else {
		right.moveFront(this);
	    }
	    flag = !flag;
	}
	return;
    }

    /**
     * Helper method to move the front node from the SingleQueue source to the rear
     * of this SingleQueue.
     *
     * @param source SingleQueue to move node from
     */

    private void moveFront(final SingleQueue<T> source) {
	final SingleNode<T> node = source.front;
	source.front = source.front.getNext();
	node.setNext(null);
	if (source.front == null) {
	    source.rear = null;
	}
	if (this.front == null) {
	    this.front = node;
	} else {
	    this.rear.setNext(node);
	}
	this.rear = node;
	this.length++;
	source.length--;
    }
}

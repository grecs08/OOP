package cp213;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2022-10-26
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The value to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {

	SingleNode<T> pre = null;
	SingleNode<T> current = this.front;
	boolean found = false;

	while (!found && current != null) {
	    if (current.getDatum().compareTo(key) == 0) {
		found = true;
	    } else {
		pre = current;
		current = current.getNext();

	    }
	}

	if (!found) {
	    pre = null;
	}

	return pre;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param datum The value to append.
     */
    public void append(final T datum) {

	SingleNode<T> node = new SingleNode<T>(datum, null);

	if (this.isEmpty()) {
	    this.front = node;
	} else {
	    SingleNode<T> current = this.front;
	    while (current.getNext() != null) {
		current = current.getNext();
	    }
	    current.setNext(node);
	}
	this.length++;

	return;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each value formerly present in this SingleList. The first occurrence of
     * each value is preserved.
     */
    public void clean() {

	SingleNode<T> p1 = this.front;
	SingleNode<T> p2 = null;
	while (p1 != null && p1.getNext() != null) {
	    p2 = p1;

	    while (p2.getNext() != null) {
		if (p1.getDatum().compareTo(p2.getNext().getDatum()) == 0) {
		    p2.setNext(p2.getNext().getNext());
		    this.length--;
		} else {
		    p2 = p2.getNext();
		}
	    }
	    p1 = p1.getNext();
	}

	return;
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

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
     * Determines if this SingleList contains key.
     *
     * @param key The key value to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

	return this.count(key) > 0;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The value to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

	int n = 0;
	SingleNode<T> current = this.front;

	while (current != null) {
	    if (current.getDatum().compareTo(key) == 0) {
		n++;
	    }
	    current = current.getNext();
	}
	return n;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {

	T data = null;
	if (this.count(key) != 0) {
	    if (this.length > 0) {
		final SingleNode<T> pre = this.linearSearch(key);

		if (pre == null) {
		    // data at front
		    data = this.front.getDatum();
		} else if (pre.getNext() != null) {
		    data = pre.getNext().getDatum();
		}
	    }
	}

	return data;

    }

    /**
     * Get the nth item in this SingleList.
     *
     * @param n The index of the item to return.
     * @return The nth item in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

	T data = null;
	if (n < this.length) {
	    int i = 0;
	    SingleNode<T> node = this.front;
	    while (node != null && i < n) {
		node = node.getNext();
		i++;
	    }
	    data = node.getDatum();
	}

	return data;
    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same values in the same order as
     *         source, false otherwise.
     */
    public boolean identical(final SingleList<T> source) {
	boolean ident = true;
	if (this.length == source.length) {
	    SingleNode<T> thisNode = this.front;
	    SingleNode<T> sourceNode = source.front;
	    while (ident && thisNode != null) {
		if (thisNode.getDatum().compareTo(sourceNode.getDatum()) != 0) {
		    ident = false;
		} else {
		    thisNode = thisNode.getNext();
		    sourceNode = sourceNode.getNext();
		}
	    }
	} else {
	    ident = false;
	}

	return ident;
    }

    /**
     * Finds the first location of a value by key in this SingleList.
     *
     * @param key The value to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {
	int i = 0;
	boolean found = false;
	SingleNode<T> node = this.front;
	while (!found && i < this.length) {
	    if (node.getDatum().compareTo(key) == 0) {
		found = true;
	    } else {
		i++;
		node = node.getNext();
	    }
	}

	if (!found) {
	    i = -1;
	}
	return i;

	// return 0;
    }

    /**
     * Inserts value into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i     The index to insert the new data at.
     * @param datum The new value to insert into this SingleList.
     */
    public void insert(int i, final T datum) {
	SingleNode<T> node = new SingleNode<T>(datum, null);

	if (i >= 0) {
	    int n = 0;
	    SingleNode<T> current = this.front;
	    if (i >= this.length) {
		while (current.getNext() != null) {
		    current = current.getNext();
		}
		current.setNext(node);
	    } else if (i == 0) {
		node.setNext(current);
		this.front = node;
	    } else {
		while (n < i - 1) {
		    current = current.getNext();
		    n++;
		}
		node.setNext(current.getNext());
		current.setNext(node);
	    }
	} else {
	    if (i <= -1 * this.length) {
		node.setNext(this.front);
		this.front = node;
	    } else {
		int a = -1 * this.length;
		SingleNode<T> temp = this.front;
		while (a < i) {
		    temp = temp.getNext();
		    a++;
		}
		node.setNext(temp.getNext());
		temp.setNext(node);
	    }

	}
	this.length++;
	return;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then values from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {

	for (T current : left) {
	    for (T checker : right) {
		if (current == checker) {
		    this.append(current);
		}
	    }
	}

	return;
    }

    /**
     * Finds the maximum value in this SingleList.
     *
     * @return The maximum value.
     */
    public T max() {

	T max = null;
	if (this.length > 0) {
	    max = this.front.getDatum();
	    SingleNode<T> current = this.front;
	    while (current.getNext() != null) {
		if (current.getDatum().compareTo(max) > 0) {
		    max = current.getDatum();
		}
		current = current.getNext();
	    }
	}

	return max;

    }

    /**
     * Finds the minimum value in this SingleList.
     *
     * @return The minimum value.
     */
    public T min() {

	T min = null;
	if (this.length > 0) {
	    min = this.front.getDatum();
	    SingleNode<T> current = this.front;
	    while (current.getNext() != null) {
		if (current.getDatum().compareTo(min) < 0) {
		    min = current.getDatum();
		}
		current = current.getNext();
	    }
	}
	return min;
    }

    /**
     * Inserts value into the front of this SingleList.
     *
     * @param datum The value to insert into the front of this SingleList.
     */
    public void prepend(final T datum) {
	SingleNode<T> newNode = new SingleNode<T>(datum, this.front);
	this.front = newNode;
	this.length += 1;
	return;
    }

    /**
     * Finds, removes, and returns the value in this SingleList that matches key.
     *
     * @param key The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {

	T match = null;
	SingleNode<T> current = this.front;
	SingleNode<T> prev = this.front;
	while (current != null) {
	    if (current.getDatum().equals(key)) {
		match = current.getDatum();
		if (this.length == 1) {
		    this.front = null;
		    this.rear = null;
		} else if (current == this.front) {
		    this.front = this.front.getNext();
		} else if (current == this.rear) {
		    this.rear.setNext(null);
		} else {
		    prev.setNext(current.getNext());
		}
		this.length--;
	    }
	    prev = current;
	    current = current.getNext();
	}
	return match;
    }

    /**
     * Removes the value at the front of this SingleList.
     *
     * @return The value at the front of this SingleList.
     */
    public T removeFront() {

	SingleNode<T> node = this.front;
	this.front = this.front.getNext();
	node.setNext(null);
	this.length--;
	return node.getDatum();

    }

    /**
     * Finds and removes all values in this SingleList that match key.
     *
     * @param key The value to search for.
     */
    public void removeMany(final T key) {
	SingleNode<T> temp = this.front;
	SingleNode<T> pre = null;
	while (temp != null && temp.getDatum().equals(key)) {
	    this.front = temp.getNext();
	    temp = this.front;
	    this.length -= 1;
	}
	while (temp != null) {
	    while (temp != null && !temp.getDatum().equals(key)) {
		pre = temp;
		temp = temp.getNext();
	    }
	    if (temp == null) {
		return;
	    }
	    pre.setNext(temp.getNext());
	    temp = pre.getNext();
	}
	return;
    }

    /**
     * Reverses the order of the values in this SingleList.
     */
    public void reverse() {

	SingleNode<T> newfront = null;
	SingleNode<T> temp = null;

	while (this.front != null) {
	    temp = this.front.getNext();
	    this.front.setNext(newfront);
	    newfront = this.front;
	    this.front = temp;
	}
	this.front = newfront;
	return;

    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * item than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

	int mid = this.length / 2;
	int i = 0;
	if (this.length % 2 != 0) {
	    mid++;
	}
	while (i < mid) {
	    left.moveFront(this);
	    i++;
	}
	while (!this.isEmpty()) {
	    right.moveFront(this);
	}
	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

	boolean flag = true;
	while (!this.isEmpty()) {
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
     * Creates a union of two other SingleLists into this SingleList. Copies value
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then values from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {
	SingleNode<T> current = left.front;
	while (current.getNext() != null) {
	    if (!this.contains(current.getDatum())) {
		this.append(current.getDatum());
	    }
	    current = current.getNext();
	}
	current = right.front;
	while (current.getNext() != null) {
	    if (!this.contains(current.getDatum())) {
		this.append(current.getDatum());
	    }
	    current = current.getNext();
	}
	return;
    }

    /**
     * A helper method to move the front node of the SingleList source to this
     * SingleList.
     *
     * @param source The list to move the front of.
     */
    private void moveFront(final SingleList<T> source) {
	SingleNode<T> node = source.front;
	source.length--;
	source.front = source.front.getNext();
	if (this.isEmpty()) {
	    this.front = node;
	} else {
	    SingleNode<T> current = this.front;
	    while (current.getNext() != null) {
		current = current.getNext();
	    }
	    current.setNext(node);
	}
	node.setNext(null);
	this.length++;
	return;

    }
}

import org.junit.Test;
import static org.junit.Assert.*;

import datastructures.*;

public class LinkedListTest {
	/**
	 * Probably won't compile... ?
	 */
	@Test
	public void testSomeLinkedListInit() {
		LinkedList<Integer> classUnderTest = new LinkedList<Integer>();
		assertEquals(0, classUnderTest.size());
	}
}

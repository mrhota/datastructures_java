import org.junit.Test;
import static org.junit.Assert.*;

import datastructures;

public class LinkedListTest {
	/**
	 * Probably won't compile... ?
	 */
	@Test
	public void testSomeLinkedListInit() {
		datastructures.LinkedList classUnderTest = new datastructures.LinkedList();
		assertEqual(0, classUnderTest.size());
	}
}

package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class _02_02_ReturnKthToLastTest {

    private _02_02_ReturnKthToLast s = new _02_02_ReturnKthToLast();

    @Test
    public void withOutOfScopeK() {
        assertNull(s.kthToLast(LinkedListNode.of(1, 2, 3), 4));
    }

    @Test
    public void returnLast() {
        assertEquals(3, s.kthToLast(LinkedListNode.of(1, 2, 3), 1).val);
    }

    @Test
    public void withNoneZero() {
        assertEquals(1, s.kthToLast(LinkedListNode.of(1, 2, 3), 3).val);
    }


}
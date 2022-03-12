/* Skeleton code copyright (C) 2008, 2022 Paul N. Hilfinger and the
 * Regents of the University of California.  Do not distribute this or any
 * derivative work without permission. */

package edu.berkeley.aep.ataxx;

import org.junit.Test;
import static org.junit.Assert.*;

import static ataxx.Move.*;

/** Test Move creation.
 *  @author P. N. Hilfinger
 */
public class MoveTest {

    @Test
    public void testPass() {
        Assert.assertTrue("bad pass", pass() != null && pass().isPass());
        assertEquals("bad pass string", "-", pass().toString());
    }

    @Test
    public void testMove() {
        Move m = move('a', '3', 'b', '2');
        Assert.assertNotNull(m);
        Assert.assertFalse("move is pass", m.isPass());
        Assert.assertTrue("move not extend", m.isExtend());
        Assert.assertFalse("move is jump", m.isJump());

        Move m1 = move('g', '1', 'g', '2');
        Assert.assertNotNull(m1);
        Assert.assertFalse("move is pass", m1.isPass());
        Assert.assertTrue("move not extend", m1.isExtend());
        Assert.assertFalse("move is jump", m1.isJump());
    }

    @Test
    public void testJump() {
        Move m = move('a', '3', 'a', '5');
        Assert.assertNotNull(m);
        Assert.assertFalse("move is pass", m.isPass());
        Assert.assertFalse("move is extend", m.isExtend());
        Assert.assertTrue("move not jump", m.isJump());

        Move m1 = move('g', '1', 'e', '3');
        Assert.assertNotNull(m1);
        Assert.assertFalse("move is pass", m1.isPass());
        Assert.assertFalse("move is extend", m1.isExtend());
        Assert.assertTrue("move not jump", m1.isJump());
    }

    @Test
    public void testToString() {
        Move m = move('a', '3', 'a', '5');
        assertEquals("wrong string for a3-a5", "a3-a5", m.toString());

        Move m1 = move('g', '1', 'e', '3');
        assertEquals("wrong string for g1-e3", "g1-e3", m1.toString());

        assertEquals("wrong string for pass", "-", pass().toString());
    }
}

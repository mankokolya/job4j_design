package ru.job4j.collection.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    private Tree<Integer> tree = new Tree<>(1);

    @Test
    public void when6LastThenFindLast6() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void whenParentNotExitThenOptionalEmpty() {
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenParentHasMore2ChildrenThenNotBinaryTree() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertFalse(tree.isBinary());
    }

    @Test
    public void whenParentHasLess2ChildrenThenBinaryTree() {
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenAddExistingChildThenAddFalse() {
        tree.add(1, 3);
        tree.add(1, 4);
        assertFalse(tree.add(1, 3));
    }

}
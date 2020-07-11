package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(Object parent, Object child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> newNode = findBy(child);
        if (newNode.isEmpty()) {
            parentNode.ifPresent(eNode -> eNode.children.add(new Node(child)));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(Object value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                result = false;
                break;
            }
            data.addAll(el.children);
        }
        return result;
    }
}

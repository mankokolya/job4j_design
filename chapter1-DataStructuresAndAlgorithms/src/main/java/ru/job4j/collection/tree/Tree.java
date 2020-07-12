package ru.job4j.collection.tree;

import java.util.*;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add(Object parent, Object child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> newNode = findBy(child);
        if (newNode.isEmpty()) {
            parentNode.ifPresent(eNode -> eNode.children.add(new Node<>((E) child)));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(Object value) {
        return findEl(el -> el.value.equals(value));
    }

    public boolean isBinary() {
        Optional<Node<E>> rsl = findEl(el -> el.children.size() > 2);
        return rsl.isEmpty();
    }


    private Optional<Node<E>> findEl(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}

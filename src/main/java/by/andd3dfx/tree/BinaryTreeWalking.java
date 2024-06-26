package by.andd3dfx.tree;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * Дан класс Node:
 *    class Node {
 *        int value;
 *        Node left, right;
 *    }
 *
 * Реализовать алгоритм обхода бинарного дерева из нод, чтобы в итоге развернуть его в список.
 * Исходно - дана корневая нода.
 * </pre>
 *
 * @see <a href="https://youtu.be/cEd6CPAp90I">Video solution</a>
 */
public class BinaryTreeWalking {

    @Data
    @RequiredArgsConstructor
    public static class Node<T> {
        private final T value;
        private final Node<T> left;
        private final Node<T> right;
    }

    public <T> List<Node<T>> breadthWalk(Node<T> root) {
        List<Node<T>> result = new ArrayList<>();

        Queue<Node> children = new ArrayDeque<>();
        children.add(root);
        while (!children.isEmpty()) {
            Node node = children.remove();

            // process node
            result.add(node);

            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }
        }

        return result;
    }

    public <T> List<Node<T>> forwardVerticalWalk(Node<T> root) {
        List<Node<T>> result = new ArrayList<>();
        forwardProcess(root, result);
        return result;
    }

    public <T> List<Node<T>> symmetricVerticalWalk(Node<T> root) {
        List<Node<T>> result = new ArrayList<>();
        symmetricProcess(root, result);
        return result;
    }

    public <T> List<Node<T>> backwardVerticalWalk(Node<T> root) {
        List<Node<T>> result = new ArrayList<>();
        backwardProcess(root, result);
        return result;
    }

    private <T> void forwardProcess(Node<T> root, List<Node<T>> list) {
        list.add(root);
        if (root.left != null) {
            forwardProcess(root.left, list);
        }
        if (root.right != null) {
            forwardProcess(root.right, list);
        }
    }

    private <T> void symmetricProcess(Node<T> root, List<Node<T>> list) {
        if (root.left != null) {
            symmetricProcess(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            symmetricProcess(root.right, list);
        }
    }

    private <T> void backwardProcess(Node<T> root, List<Node<T>> list) {
        if (root.left != null) {
            backwardProcess(root.left, list);
        }
        if (root.right != null) {
            backwardProcess(root.right, list);
        }
        list.add(root);
    }
}

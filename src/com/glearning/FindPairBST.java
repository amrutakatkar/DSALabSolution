package com.glearning;

// Find a pair with a given sum in Binary Search Tree

import java.util.HashSet;

public class FindPairBST {

    Node root;

    FindPairBST() {
        root = null;
    }

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }

    private boolean findPairDetails(Node node, int sum, HashSet<Integer> set) {
        if (node == null)
            return false;

        if (findPairDetails(node.left, sum, set))
            return true;

        if (set.contains(sum - node.data)) {
            System.out.println("Pair is ("
                    + (sum - node.data) + ", "
                    + node.data + ")");
            return true;
        } else
            set.add(node.data);

        return findPairDetails(node.right, sum, set);
    }

    public void findPair(int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findPairDetails(root, sum, set))
            System.out.println("Nodes are not found");
    }

    public static void main(String[] args) {
        FindPairBST findpairbst = new FindPairBST();

        findpairbst.insert(40);
        findpairbst.insert(20);
        findpairbst.insert(60);
        findpairbst.insert(10);
        findpairbst.insert(30);
        findpairbst.insert(50);
        findpairbst.insert(70);

        int sum = 130;

        findpairbst.findPair(sum);
    }

}

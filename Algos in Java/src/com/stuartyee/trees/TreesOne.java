package com.stuartyee.trees;

public class TreesOne {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(12) // should add to root
            .add(8) // should add to root's left
            .add(14) // should add to root's right
            .add(17) // should add to the root's right/right
            .add(4) // should add to the left with the node with 8
            .add(6); // should add to the right with the node with 8

        Integer[] values = {12, 8, 14, 17, 4, 6};
        Integer[] nonValues = {20, 108, 1, 5, 7};

        System.out.println("Root: " + bst.root.val.toString() + " " + bst.root.left.val.toString() + " " + bst.root.right.val.toString() );
        System.out.println("Root Left: " + bst.root.left.left.val.toString() + " " + bst.root.left.right.val.toString());
        System.out.println("Root right: "  + bst.root.right.right.val.toString());

        for (Integer val: values) {
            System.out.println("Checking " + val.toString() + ": ");
            System.out.println(bst.contains(val));
        }
        System.out.println("All of the above should be true, all of the below should be false");

        for (Integer val: nonValues) {
            System.out.println("Checking " + val.toString() + ": ");
            System.out.println(bst.contains(val));
        }

        System.out.println(bst.min());
        System.out.println(bst.max());

        BST empty = new BST();

        System.out.println(empty.isEmpty());
        System.out.println(bst.isEmpty());

        System.out.println(bst.size());

        System.out.println("empty BST");
        System.out.println(empty.size());
        System.out.println(empty.min());
        System.out.println(empty.max());
        System.out.println(empty.contains(5));

    }

    private static class BTNode {

        Integer val;
        BTNode left;
        BTNode right;
        BTNode(Integer value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }

    private static class BST {

        BTNode root;

        BST() {
            this.root = null;
        }

        public BST add(Integer value) {
            BTNode newNode = new BTNode(value);
            BTNode current = this.root;
            if (current == null) {
                this.root = newNode;
                return this;
            }
            while (true) {
                if (value < current.val) {
                    if (current.left == null) {
                        current.left = newNode;
                        return this;
                    } else {
                        if (current.right == null) {
                            current.right = newNode;
                            return this;
                        }
                        current = current.left;
                        continue;
                    }
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        return this;
                    } else {
                        current = current.right;
                        continue;
                    }
                }
            }

        }

        public boolean contains(Integer value) {
            if (this.root == null) {
                return false;
            }
            BTNode current = this.root;

            while (true) {
                if (current.val == value) {
                    return true;
                }
                if (value < current.val) {
                    if (current.left == null) {
                        return false;
                    } else if (value > current.left.val) {
                        current = current.right;
                        continue;
                    } else {
                        current = current.left;
                        continue;
                    }
                } else {
                    if (current.right == null) {
                        return false;
                    } else {
                        current = current.right;
                        continue;
                    }
                }
            }


        }

        public Integer min() {
            if (this.root == null) {
                return null;
            }
            BTNode current = this.root;
            while (true) {
                if (current.left == null) {
                    return current.val;
                } else {
                    current = current.left;
                    continue;
                }
            }
        }

        public Integer max() {
            if (this.root == null) {
                return null;
            }
            BTNode current = this.root;
            while (true) {
                if (current.right == null) {
                    return current.val;
                } else {
                    current = current.right;
                    continue;
                }
            }
        }
        public boolean isEmpty() {
            if (this.root == null) {
                return true;
            } else {
                return false;
            }
        }
        public Integer size(BTNode node){
            if (node.left == null && node.right == null) {
                return 1;
            } else if (node.left == null) {
                return size(node.right) + 1;
            } else if (node.right == null) {
                return size(node.left) + 1;
            } else {
                return size(node.left) + size(node.right) + 1;
            }
        }

        public Integer size() {
            if (this.root == null) {
                return 0;
            } else {
                return size(this.root);
            }
        }
    }
}

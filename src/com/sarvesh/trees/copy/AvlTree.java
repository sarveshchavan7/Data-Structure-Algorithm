package com.sarvesh.trees.copy;

public class AvlTree {

	Node root;

	AvlTree() {
		root = null;
	}

	class Node {
		Node left, right;
		int height, key;

		Node(int key) {
			left = right = null;
			this.key = key;
			height = 0;
		}
	}

	public Node getNewNode(int key) {
		Node newNode = new Node(key);
		return newNode;
	}

	public int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	public int max(int a, int b) {
		return (a > b ? a : b);
	}

	public int getBalanceFactor(Node node) {
		int bf = height(node.left) - height(node.right);
		return bf;
	}

	public Node rightRotate(Node A) {
		Node B = A.left;
		Node temp = B.right;

		// Perform rotation
		A.left = temp;
		B.right = A;

		// Update the height
		A.height = 1 + max(height(A.left), height(A.right));
		B.height = 1 + max(height(B.left), height(B.right));

		return B;
	}

	public Node leftRotate(Node A) {
		Node B = A.right;
		Node temp = B.left;

		// Perform rotation
		A.right = temp;
		B.left = A;

		// Update the height
		A.height = 1 + max(height(A.left), height(A.right));
		B.height = 1 + max(height(B.left), height(B.right));

		return B;
	}

	public Node insert(Node root, int key) {
		if (root == null) {

			return getNewNode(key);

		}

		if (key < root.key) {
			root.left = insert(root.left, key);
		} else if (key > root.key) {
			root.right = insert(root.right, key);
		}
		// No same value
		else {
			return root;
		}

		// update the height of the ancestor node
		root.height = 1 + max(height(root.left), height(root.right));

		// check the balance factor
		int bf = getBalanceFactor(root);

		// LL case - rightRotate
		if (bf > 1 && key < root.left.key) {
			return rightRotate(root);
		}

		// LR case - left right case
		if (bf > 1 && key > root.left.key) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// RR case - right right case
		if (bf < -1 && key > root.right.key) {
			return leftRotate(root);
		}

		// RL case - right left case
		if (bf < -1 && key < root.right.key) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	public void inorder(Node root) {
		
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.key + "->");
		inorder(root.right);
	}

	public int max(Node root) {
		if (root == null) {
			return -1;
		}
		while (root.right != null) {
			root = root.right;
		}
		return root.key;
	}

	// Using recursion
	public int min(Node root) {
		// base case
		if (root.left == null) {
			return root.key;
		}
		return min(root.left);
	}

	public Node delete(Node root, int key) {
		if (root == null)
			return root;

		if (root.key > key)
			root.left = delete(root.left, key);
		else if (root.key < key)
			root.right = delete(root.right, key);
		// we found the element we want to delete
		else {
			// leaf node
			if (root.left == null && root.right == null) {
				return root = null;
			}
			// node has one child
			else if (root.left == null || root.right == null) {
				if (root.right == null) {
					Node temp = root.left;
					root.left = null;
					return temp;
				} else {
					Node temp = root.right;
					root.right = null;
					return temp;
				}
			}
			// Two children
			else {
				// find the min the right sub tree
				int minValue = min(root.right);
				root.key = minValue;
				root.right = delete(root.right, minValue);
			}
		}

		// update the height of ancestor nodes
		root.height = 1 + max(height(root.left), height(root.right));

		// bf
		int bf = height(root.left) - height(root.right);

		// LL case
		if (bf > 1 && getBalanceFactor(root.left) >= 0) {
			return rightRotate(root);
		}

		// LR
		if (bf > 1 && getBalanceFactor(root.right) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// RR case
		if (bf < -1 && getBalanceFactor(root.right) < 0) {
			return leftRotate(root);
		}

		// RL case
		if (bf < -1 && getBalanceFactor(root.right) >= 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvlTree avl = new AvlTree();
		avl.root = avl.insert(avl.root, 20);
		avl.root = avl.insert(avl.root, 10);
		avl.root = avl.insert(avl.root, 5);
		avl.root = avl.insert(avl.root, 12);
		avl.root = avl.insert(avl.root, 15);
		avl.root = avl.insert(avl.root, 30);
		avl.root = avl.insert(avl.root, 3);
		avl.inorder(avl.root);
		System.out.println();
		avl.root = avl.delete(avl.root, 12);
		avl.inorder(avl.root);
		avl.root = avl.delete(avl.root, 3);
		avl.root = avl.delete(avl.root, 10);
		avl.root = avl.root = avl.insert(avl.root, 35);
		System.out.println();
		avl.inorder(avl.root);
		avl.root = avl.root = avl.insert(avl.root, 25);
		avl.root = avl.root = avl.insert(avl.root, 28);
		avl.root = avl.delete(avl.root, 5);
		System.out.println();
		avl.inorder(avl.root);
		
		System.out.println("\n" + avl.root.key);
		System.out.println("\nmin value is " + avl.min(avl.root));
		System.out.println("\nMax value is " + avl.max(avl.root));

	}

}

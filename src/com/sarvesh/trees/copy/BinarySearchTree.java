package com.sarvesh.trees.copy;

import com.sarvesh.D_Queue.*;

/*
 * Time complexity
 * Insert -O(h)- O(logn) if it's a balanced 
 * Search -O(h)- O(logn) if it's a balanced
 * delete -O(h)- 0(logn) if it's a balanced
 * 
 * Note - if the bst is skew tree so it is as good as linked list 
 *        so Time complexity T - O(h) and for skew tree h = n - 1 so T - O(n-1) ~ O(n)
 * 
 * preOrder - <root><left><right> T -O(n) S - O(h) where h is height of bst
 * InOrder  - <left><root><right> T -O(n) S - O(h) where h is height of bst
 * postOrder - <left><right><root> T -O(n) S - O(h) where h is height of bst
 * Note - in worst case the height of bst will be  (h =n-1) so S - O(n) 
 * 		  in the average case the S - O(logn)
 */
public class BinarySearchTree {

	Node root;

	class Node {
		Node left, right;
		int key;

		Node(int key) {
			left = right = null;
			this.key = key;
		}
	}

	public Node getNewNode(int key) {
		Node newNode = new Node(key);
		return newNode;
	}

	public Node insert(Node root, int key) {
		if (root == null) {
			root = getNewNode(key);
		} else if (root.key > key) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

	// findMin using recursion
	public int findMin(Node root) {
		if (root.left == null) {
			return root.key;
		}
		return findMin(root.left);
	}

	// findMax using iteration
	public int findMax(Node root) {
		if (root == null) {
			System.out.println("root is null");
			return -1;
		}
		Node temp = root;
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.key;
	}

	public boolean search(Node root, int key) {
		if (root == null) {
			return false;
		} else if (root.key == key) {
			return true;
		} else if (root.key > key) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	public void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + "->");
		preorder(root.left);
		preorder(root.right);
	}

	public void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.key + "->");
	}

	public void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.key + "->");
		inorder(root.right);
	}

	public int findHeight(Node root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		return (max(leftHeight, rightHeight) + 1);
	}

	public int max(int a, int b) {
		return (a > b ? a : b);
	}

	public Node delete(Node root, int key) {
		if (root == null) {
			return root;
		}

		if (root.key == key) {
			// if no child
			if (root.left == null && root.right == null) {
				return root = null;
			}
			// if exactly one child
			// right sub tree
			else if (root.left == null) {
				Node temp = root.right;
				root.right = null;
				return temp;
			}
			// left sub tree
			else if (root.right == null) {
				Node temp = root.left;
				root.left = null;
				return temp;
			}
			// Two child
			else {
				root.key = findMin(root.right);
				root.right = delete(root.right, root.key);
			}
		}

		if (root.key > key) {
			root.left = delete(root.left, key);
		} else {
			root.right = delete(root.right, key);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 15);
		bst.root = bst.insert(bst.root, 25);
		bst.root = bst.insert(bst.root, 5);

		bst.inorder(bst.root);
		boolean x = bst.search(bst.root, 25);
		if (x) {
			System.out.println("\nYes");
		} else {
			System.out.println("\nNo");
		}
		System.out.println(bst.findMin(bst.root));
		System.out.println(bst.findMax(bst.root));

		System.out.println("\n" + bst.findHeight(bst.root));

		System.out.println(bst.checkBst1(bst.root));

		System.out.println(bst.isBst(bst.root));

		/*
		 * bst.root = bst.delete(bst.root, 10); bst.inorder(bst.root);
		 * System.out.println(); bst.root = bst.delete(bst.root, 15);
		 * bst.inorder(bst.root); System.out.println(); bst.root =
		 * bst.delete(bst.root, 25); bst.inorder(bst.root);
		 */

		bst.InvertORMirror(bst.root);
		System.out.println("Inverted a binary tree");
		bst.inorder(bst.root);
		bst.InvertORMirror(bst.root);

		Node inorderSuccessor = bst.inOrderSuccessor(bst.root, 5);
		System.out.println("\nInorderSuccessor " + inorderSuccessor.key);
	}

	// check if the binary tree is binary search tree or not
	// T - O(n)
	// Method 1 : we can perform inOrder traversal and at each step
	// we will check the current element is greater then the previous element
	// if yes then it's a bst bcoz bst inOrder traversal is a sorted list
	Node prev = null;

	public boolean checkBst1(Node root) {
		if (root != null) {

			checkBst1(root.left);
			if (prev != null && root.key <= prev.key) {
				return false;
			}
			prev = root;
			return checkBst1(root.right);
		}
		return true;
	}

	// T - O(n)
	// Method 2: at each step we will put constrain to the node and if the
	// value of node fits in that constrain then it's a bst
	public boolean isBst(Node root) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return isBst(root, min, max);
	}

	boolean isBst(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.key > min && root.key < max && isBst(root.left, min, root.key) && isBst(root.right, root.key, max)) {
			return true;
		} else {
			return false;
		}
	}

	// T -O(n) - [not sure] Correct but not efficient
	// Method 3: we can find max value in the left subtree and min value in the
	// right subtree
	// and compare with the root so its should be [max in left subTree < root
	// value < min in right subTree]
	// For each node, check if max value in left subtree is smaller than the
	// node and min value in right subtree greater than the node.

	// Invert or mirror a binary tree T - O(n)
	public Node Invert(Node root) {
		if (root == null) {
			return root;
		}
		Node temp = root.right;
		root.right = root.left;
		root.left = temp;
		root.left = Invert(root.left);
		root.right = Invert(root.right);
		return root;
	}

	// Invert or mirror using queue - level order traversal T- O(n)
	public Node InvertORMirror(Node root) {
		if (root == null) {
			return root;
		}
		Queue_a q = new Queue_a();
		q.enqueue(root);
		while (!q.isEmpty()) {
			Node current = (Node) q.peek();
			q.dequeue();
			// swapped the two children
			Node temp = current.right;
			current.right = current.left;
			current.left = temp;
			if (current.left != null) {
				q.enqueue(current.left);
			}
			if (current.right != null) {
				q.enqueue(current.right);
			}

		}
		return root;
	}

	Node someNode;

	public Node searchNode(Node root, int key) {
		if (root == null) {
			return root;
		}

		if (root.key > key) {
			someNode = searchNode(root.left, key);
		} else if (root.key < key) {
			someNode = searchNode(root.right, key);
		}
		// we found the node simply return
		else {
			return root;
		}
		return someNode;
	}

	// Inorder successor
	// given a root node and key of the node
	// return inorder successor of that key
	public Node inOrderSuccessor(Node root, int key) {

		Node current = searchNode(root, key);
		if (current == null) {
			return null;
		}

		// case 1 : we have right child
		Node temp = current.right;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
		} else {

			// case 2: we have to find the deepest ancestor for which the node
			// lies in it's left subtree
			Node ancestor = root;
			Node successor = null;

			while (current != ancestor) {
				if (current.key < ancestor.key) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else {
					ancestor = ancestor.right;
				}
			}
			return successor;
		}
	}
}

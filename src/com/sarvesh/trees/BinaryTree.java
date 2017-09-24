package com.sarvesh.trees;
/*
 * Tree - non-linear data structure
 * 
 * 										Time complexity 
 * 
 *               Array          LinkedList        Array(sorted)       BST
 * search(x)     O(n)           O(n)              O(logn)            O(logn)
 *  
 * Insert(x)     O(1)           O(1)              O(n)               O(logn) 
 *
 * Remove(x)     O(n)           O(n)              o(n)               O(logn)
 * 
 * height of tree - No of edges in a longest path from root node to the leaf node.
 *                  height of the node is the no of edges in a longest path to a leaf node from that node
 * 
 * height of empty tree = -1
 * 
 * height of tree with one node = 0 
 * 
 * depth of node - no of edges from root node to that node
 *                 Note that depth doesn't make sense for a tree.
 * 
 * Binary Tree - a tree in which node can have at most two children
 *               single node can also be called as binary tree
 * 
 * Strict/Proper binary tree - Binary tree in which a node can have either 0 or 2 children
 * 
 * Complete Binary tree - Binary tree in which all the level except possibly the last level should be completely filled
 *                        and they should be placed as left as possible
 * 
 * Note - for Binary Tree max no of nodes at any level(i) is 2^i where i is level (level starts from 0)
 * 
 * Note - max no of nodes in a binary tree with height h  ?   
 * 
 * Note - what is the height of perfect binary tree with n node(n is the no of nodes)?
 * = 2^0 + 2^1 + 2^2 +.....+2^h
 * = (for perfect binary tree no of level = h+1 = depth of leaf node)
 * = 2^h+1 - 1 or 2^no of level -1
 * = if we take log on both side
 * n = 2^h+1 - 1 (taking log on both the sides)
 * log(n+1) = h
 * therefore we have [h = log(n+1) ] for perfect binahry tree
 *  
 * Note - height of complete binary tree - (logn)
 * 
 * Note - cost of many operations on tree depends on the height of tree so we want our binary tree 
 * to be dense as possible that means we want it to be balanced
 * 
 * Balanced Binary tree - binary tree in which difference between left and right sub tree of a node should be (+_ 1) i.e -1,0,1
 * 
 * Perfect Binary tree - binary tree in which all the level are completely filled  
 * 
 * Note - max no of edges in binary tree is n - 1 where n is no of nodes
 */
public class BinaryTree {

}

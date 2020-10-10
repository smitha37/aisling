//Java Program for Lowest Common Ancestor in a Binary Tree 
import java.util.ArrayList; 
import java.util.List; 

class Node { 
	int data; 
	Node left, right; 

	Node(int value) 
	{ 
		data = value; 
		left = right = null; 
	} 
} 
public class LowestCommonAncestor {

	Node root; 
	private List<Integer> path1 = new ArrayList<>(); 
	private List<Integer> path2 = new ArrayList<>(); 

	int findLowestCommonAncestor(int node1, int node2) 
	{ 
		path1.clear(); 
		path2.clear(); 
		return findLowestCommonAncestorInternal(root, node1, node2); 
	} 

	private int findLowestCommonAncestorInternal(Node root, int node1, int node2) 
	{ 
		if (!findPath(root, node1, path1) || !findPath(root, node2, path2)) 
		{ 
			System.out.println((path1.size() > 0) ? "node1 is present" : "node1 is missing"); 
			System.out.println((path2.size() > 0) ? "node2 is present" : "node2 is missing"); 
			return -1; 
		} 
		int i = 0;
		for (i = 0; i < path1.size() && i < path2.size(); i++) 
		{ 
			if (!path1.get(i).equals(path2.get(i))) 
				break; 
		} 
		return path1.get(i-1); 
	} 
	
	private boolean findPath(Node root, int n, List<Integer> path) 
	{ 
		if (root == null) 
		{ 
			return false; 
		} 
		path.add(root.data); 

		if (root.data == n) 
		{ 
			return true; 
		} 

		if (root.left != null && findPath(root.left, n, path)) 
		{ 
			return true; 
		} 

		if (root.right != null && findPath(root.right, n, path)) 
		{ 
			return true; 
		} 

		path.remove(path.size()-1); 

		return false; 
	} 

	public static void main(String[] args) 
	{ 
		LowestCommonAncestor tree = new LowestCommonAncestor(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		System.out.println("LCA(2, 4): " + tree.findLowestCommonAncestor(2,4)); 
		System.out.println("LCA(4, 6): " + tree.findLowestCommonAncestor(4,6)); 
		System.out.println("LCA(6, 7): " + tree.findLowestCommonAncestor(6,7)); 
		System.out.println("LCA(4, 7): " + tree.findLowestCommonAncestor(4,7)); 
	
	} 
} 
//This code was taken from https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//I made very minor changes to help with my understanding

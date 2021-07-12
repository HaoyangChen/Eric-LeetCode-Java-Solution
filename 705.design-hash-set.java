/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start

// class MyHashSet {
//     private Bucket[] bucketArray;
//     private int keyRange;
  
//     /** Initialize your data structure here. */
//     public MyHashSet() {
//       this.keyRange = 769;
//       this.bucketArray = new Bucket[this.keyRange];
//       for (int i = 0; i < this.keyRange; ++i)
//         this.bucketArray[i] = new Bucket();
//     }
  
//     protected int _hash(int key) {
//       return (key % this.keyRange);
//     }
  
//     public void add(int key) {
//       int bucketIndex = this._hash(key);
//       this.bucketArray[bucketIndex].insert(key);
//     }
  
//     public void remove(int key) {
//       int bucketIndex = this._hash(key);
//       this.bucketArray[bucketIndex].delete(key);
//     }
  
//     /** Returns true if this set contains the specified element */
//     public boolean contains(int key) {
//       int bucketIndex = this._hash(key);
//       return this.bucketArray[bucketIndex].exists(key);
//     }
//   }
  
  
//   class Bucket {
//     private LinkedList<Integer> container;
  
//     public Bucket() {
//       container = new LinkedList<Integer>();
//     }
  
//     public void insert(Integer key) {
//       int index = this.container.indexOf(key);
//       if (index == -1) {
//         this.container.addFirst(key);
//       }
//     }
  
//     public void delete(Integer key) {
//       this.container.remove(key);
//     }
  
//     public boolean exists(Integer key) {
//       int index = this.container.indexOf(key);
//       return (index != -1);
//     }
//   }


class MyHashSet {

  private Bucket[] bucketArray;
  private int keyRange;

  /** Initialize your data structure here. */
  public MyHashSet() {
      this.keyRange = 769;
      this.bucketArray = new Bucket[this.keyRange];
      for (int i = 0; i < this.keyRange; i++) {
        this.bucketArray[i] = new Bucket();
      }
  }
  
  protected int _hash(int key) {
    return (key % this.keyRange);
  }
  
  public void add(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].insert(key);
  }
  
  public void remove(int key) {
      int bucketIndex = this._hash(key);
      this.bucketArray[bucketIndex].delete(key);
  }
  
  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
      int bucketIndex = this._hash(key);
      return this.bucketArray[bucketIndex].exists(key);
  }
}

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class BSTree {
  TreeNode root = null;
  
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || val == root.val) return root;
    return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    
  }
}

class Bucket() {
  private BSTree tree;

  public Bucket() {
    tree = new BSTree();
  }

  public void insert(Integer key) {
    this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
  }

  public void delete(Integer key) {
    this.tree.root = this.tree.deleteNode(this.tree.root, key);
  }

  public boolean exists(Integer key) {
    TreeNode node = this.tree.searchBST(this.tree.root, key);
    return (node != null);
  }
}





/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end


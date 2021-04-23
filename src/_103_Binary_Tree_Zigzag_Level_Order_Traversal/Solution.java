package _103_Binary_Tree_Zigzag_Level_Order_Traversal;


 // Definition for a binary tree node.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


  class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null ){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>(); // the result set
        LinkedList<Integer> level = new LinkedList<Integer>(); // level of value
        boolean isLeft = true; // teh flag to determine the way of direction
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>(); // add the root element with a delimiter to kick off the BFS loop
        node_queue.addLast(root);
        node_queue.addLast(null);

        while(node_queue.size() > 0){
            TreeNode curr_node = node_queue.pollFirst();

            if(curr_node != null){
                if(isLeft){
                    level.addLast(curr_node.val);
                }else {
                    level.addFirst(curr_node.val);
                }

                if(curr_node.left != null) node_queue.addLast(curr_node.left);
                if(curr_node.right != null) node_queue.addLast(curr_node.right);
            }else {
                result.add(level);
                level = new LinkedList<Integer>(); // finished a level
                if(node_queue.size() > 0) node_queue.addLast(null);
                isLeft = !isLeft;
            }

        }

        return result;
    }

 }
import java.util.*;

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {

            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if (first == null && second == null)
                continue;

            if (first == null || second == null)
                return false;

            if (first.val != second.val)
                return false;

            queue.add(first.left);
            queue.add(second.left);

            queue.add(first.right);
            queue.add(second.right);
        }

        return true;
    }
}
class Solution {

    Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node temp = dummy;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }
            temp = temp.child;
        }

        temp.child = (a != null) ? a : b;

        return dummy.child;
    }

    Node flatten(Node root) {

        if (root == null || root.next == null)
            return root;

        root.next = flatten(root.next);

        return merge(root, root.next);
    }
}

package practice.modernjava.functional.tree;

public class Tree {

    String key;
    int val;
    Tree left;
    Tree right;

    public Tree(String k, int v, Tree l, Tree r) {
        key = k;
        val = v;
        left = l;
        right = r;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Tree [key=" + key + ", val=" + val + ", left=" + left + ", right=" + right + "]";
    }
}

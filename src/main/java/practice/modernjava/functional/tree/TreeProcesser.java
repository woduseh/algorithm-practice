package practice.modernjava.functional.tree;

public class TreeProcesser {

    public static int lookup(String k, int defaultValue, Tree t) {
        if (t == null) {
            return defaultValue;
        }
        if (k.equals(t.getKey())) {
            return t.getVal();
        }
        if (k.compareTo(t.getKey()) < 0) {
            return lookup(k, defaultValue, t.getLeft());
        } else {
            return lookup(k, defaultValue, t.getRight());
        }
    }

    public static Tree update(String k, int newVal, Tree t) {
        if (t == null) {
            t = new Tree(k, newVal, null, null);
        } else if (k.equals(t.getKey())) {
            t.setVal(newVal);
        } else if (k.compareTo(t.getKey()) < 0) {
            t.setLeft(update(k, newVal, t.getLeft()));
        } else {
            t.setRight(update(k, newVal, t.getRight()));
        }

        return t;
    }

    public static Tree functionalUpdate(String k, int newVal, Tree t) {
        return t == null ? new Tree(k, newVal, null, null) :
                k.equals(t.getKey()) ? new Tree(k, newVal, t.getLeft(), t.getRight()) :
                        k.compareTo(t.getKey()) < 0 ? new Tree(t.getKey(), t.getVal(),
                                functionalUpdate(k, newVal, t.getLeft()), t.getRight()) :
                                new Tree(t.getKey(), t.getVal(), t.getLeft(),
                                        functionalUpdate(k, newVal, t.getRight()));
    }
}

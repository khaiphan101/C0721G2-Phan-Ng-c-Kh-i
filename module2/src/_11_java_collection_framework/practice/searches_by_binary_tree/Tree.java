package _11_java_collection_framework.practice.searches_by_binary_tree;

public interface Tree<E> {
    public boolean insert(E e);
    public void inorder();
    public int getSize();
}

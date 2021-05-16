package com.example.anifuli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Categories2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories2);
    }

    private Node root;

    public Categories2() {
        root = null;
    }

    public void insert(int key) {
        root = insert(key, root);
    }

    private static Node insert(int key, Node t) {
        if (t == null)
            t = new Node(key, null, null);
        else if (key < t.getKey())
            t.leftChild = insert(key, t.leftChild);
        else if (key > t.getKey())
            t.rightChild = insert(key, t.rightChild);
        else
            ;
        return t;
    }

    public Node search(int key) {
        return search(key, root);
    }

    private static Node search(int key, Node t) {
        if (t == null)
            return null;
        else if (key < t.getKey())
            return search(key, t.leftChild);
        else if (key > t.getKey())
            return search(key, t.rightChild);
        else
            return t;
    }

    public void remove(int key) {
        root = remove(key, root);
    }

    private static Node remove(int key, Node t) {
        if (t == null)
            return t;
        if (key < t.getKey())
            t.leftChild = remove(key, t.leftChild);
        else if (key > t.getKey())
            t.rightChild = remove(key, t.rightChild);
        else if (t.leftChild != null && t.rightChild != null) {
            t.leftChild = remove(t.getKey(), t.leftChild);

        } else if (t.leftChild != null)
            t = t.leftChild;
        else
            t = t.rightChild;
        return t;
    }
}
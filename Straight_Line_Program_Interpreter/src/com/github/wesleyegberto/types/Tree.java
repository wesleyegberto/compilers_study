package com.github.wesleyegberto.types;

public class Tree {
	Tree left;
	String key;
	Tree right;

	public Tree(Tree l, String k, Tree r) {
		left = l;
		key = k;
		right = r;
	}

	public Tree insert(String key, Tree t) {
		if (t == null)
			return new Tree(null, key, null);
		else if (key.compareTo(t.key) < 0)
			return new Tree(insert(key, t.left), t.key, t.right);
		else if (key.compareTo(t.key) > 0)
			return new Tree(t.left, t.key, insert(key, t.right));
		else
			return new Tree(t.left, key, t.right);
	}
	
	public boolean member(String key) {
		if(key.compareTo(this.key) == 0) {
			return true;
		} else if(key.compareTo(this.key) < 0) {
			return left.member(key);
		} else if(key.compareTo(this.key) > 0) {
			return right.member(key);
		}
		return false;
	}
}
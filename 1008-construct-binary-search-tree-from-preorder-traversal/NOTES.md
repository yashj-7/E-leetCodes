approach 1:- the inorder of a bst is always in ascending order, sort the preorder and you will get a inorder. then construct the tree using inorder and preorder
​
approach 2:- the first elemment in preorder is root then find the next element greater to root, all elements left to that element will be to the left and others will be on right,
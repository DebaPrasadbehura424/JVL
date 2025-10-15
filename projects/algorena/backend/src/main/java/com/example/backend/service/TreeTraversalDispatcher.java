package com.example.backend.service;

import java.util.List;

import com.example.backend.utils.TreeTraversalAlgorithims;

public class TreeTraversalDispatcher {

    public String TreetraversalCompute(List<String> lists, String type) {
        if (type.equalsIgnoreCase("preorder")) {
            return TreeTraversalAlgorithims.preorderTraversal(lists);
        } else if (type.equalsIgnoreCase("inorder")) {
            return TreeTraversalAlgorithims.inorderTraversal(lists);
        } else if (type.equalsIgnoreCase("postorder")) {
            return TreeTraversalAlgorithims.postorderTraversal(lists);
        } else {
            return "Invalid type";
        }
    }

}

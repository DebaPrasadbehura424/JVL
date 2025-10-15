package com.example.backend.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.OprationalModel;
import com.example.backend.service.TreeTraversalDispatcher;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("")
@RestController
@RequestMapping("/tree_traversal")
public class TreeTraversalController {

    @PostMapping("/calculate1")
    public String computeTreeTraversal(@RequestBody OprationalModel oprationalModel) {
        String type = oprationalModel.getType();
        List<String> lists = oprationalModel.getInput();
        TreeTraversalDispatcher traversalDispatcher = new TreeTraversalDispatcher();
        String ans = traversalDispatcher.TreetraversalCompute(lists, type);

        return ans;
    }

}

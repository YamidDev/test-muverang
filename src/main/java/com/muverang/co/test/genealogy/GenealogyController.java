package com.muverang.co.test.genealogy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/genealogy")
public class GenealogyController {

    @Autowired
    private GenealogyService service;
    
    @GetMapping("/genealogytree")
    public TreeNode test() throws IOException {
        return service.treeGenealogy();
    }
}

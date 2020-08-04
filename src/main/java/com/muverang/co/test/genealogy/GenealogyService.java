package com.muverang.co.test.genealogy;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenealogyService {

    public TreeNode treeGenealogy() throws IOException {
        File file = new File("src/main/resources/static/arbol_genealogico.csv");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader streamReader = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(streamReader);

        Map<Integer, TreeNode> map = new HashMap<>();

        String line;

        int l = 0;

        while ((line = reader.readLine()) != null) {
            if (l == 0) {
                l++;
                continue;
            } 
            String[] data = line.split(";");
            TreeNode node = new TreeNode(Integer.parseInt(data[0]), data[1]);
            map.put(Integer.parseInt(data[0]), node);
            
            if (data.length == 3) {
                if (map.containsKey(Integer.parseInt(data[2]))) {
                    TreeNode mother = map.get(Integer.parseInt(data[2]));
                    mother.addChild(node);
                }
            }
        }

        return map.get(1);
    }
}

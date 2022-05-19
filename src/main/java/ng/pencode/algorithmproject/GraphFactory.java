/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.pencode.algorithmproject;

import java.io.IOException;

/**
 *
 * @author RAJAB IMAM
 * Use factory designs pattern for creating different type of Graphs
 */
public class GraphFactory {
     public static Digraph createDiGraphFromTextFile(String path) throws IOException {
        return new Digraph(path);
    }

    public static WDgraph createWDGraphFromTextFile(String path) throws IOException {
        return new WDgraph(path);
    }
}

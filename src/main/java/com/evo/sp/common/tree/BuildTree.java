package com.evo.sp.common.tree;

import java.util.ArrayList;
import java.util.List;


public class BuildTree {
    /**
     * @param nodes
     * @return
     */
    public static <T> Tree<T> build(List<Tree<T>> nodes, String topNode) {

        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<Tree<T>>();

        for (Tree<T> children : nodes) {

            String pid = children.getParentId();
            if (pid == null || "-1".equals(pid)) {
                topNodes.add(children);

                continue;
            }

            for (int i = 0; i < nodes.size(); i++) {
                String id = nodes.get(i).getId();
                if (id != null && id.equals(pid)) {
                    nodes.get(i).getChildren().add(children);
                    children.setParent(true);
                    children.setTreeId(nodes.get(i).getTreeId() + "-" + i);
                    nodes.get(i).setChildren(true);
                    continue;
                }
            }

        }

        Tree<T> root = new Tree<T>();
        root.setId("-1");
        root.setTreeId("0-0");
        root.setParentId("");
        root.setParent(false);
        root.setChildren(true);
        root.setChecked(true);
        root.setChildren(topNodes);
        root.setText(topNode);
        root.setPath("#");
        root.setLevel(0);
        return root;
    }
}

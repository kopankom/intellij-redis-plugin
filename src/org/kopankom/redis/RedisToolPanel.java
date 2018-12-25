package org.kopankom.redis;

import com.intellij.ui.treeStructure.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RedisToolPanel extends JPanel {
    private class TObject extends Object {
        public String objectPath;
        public String title;

        public TObject(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return this.title;
        }
    }

    public RedisToolPanel() {
        this.setLayout(new GridLayout(0, 1));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
        vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
        vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
        vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
        vegetableNode.add(new DefaultMutableTreeNode("Potato"));
        TObject tobject = new TObject("Better potato");
        tobject.objectPath = "redis:n1";
        vegetableNode.add(new DefaultMutableTreeNode(tobject));

        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
        DefaultMutableTreeNode banana = new DefaultMutableTreeNode("Banana");
        banana.add(new DefaultMutableTreeNode("Yellow"));
        fruitNode.add(banana);
        fruitNode.add(new DefaultMutableTreeNode("Mango"));
        fruitNode.add(new DefaultMutableTreeNode("Apple"));
        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
        fruitNode.add(new DefaultMutableTreeNode("Orange"));
        root.add(vegetableNode);
        root.add(fruitNode);

        Tree tree = new Tree(root);
        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                            tree.getLastSelectedPathComponent();
                    if (node == null) return;
                    Object nodeInfo = node.getUserObject();

                    RedisFileSystem.getInstance().openEditor(
                            new RedisObjectFile(RedisToolWindowFactory.project));
                }
            }
        });
        add(tree);
    }

}

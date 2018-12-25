package org.plantuml.idea.toolwindow;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.ui.TreeSpeedSearch;
import com.intellij.ui.treeStructure.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightPane extends JPanel {
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

    private JPasswordField passwordField1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;

    public RightPane() {
//        this.add(this.checkBox1);
//        this.add(this.checkBox2);
//        this.add(this.passwordField1);
//        Tree mongoTree = createTree();
//        mongoTree.add("rio", this.passwordField1);
//        mongoTree.add("rio", this.checkBox1);
//        MongoTreeBuilder mongoTreeBuilder = new MongoTreeBuilder(mongoTree);
//        tBuilder tBuilder1 = new tBuilder();
//        tBuilder1.initRootNode();
//        this.add(mongoTree);
        this.setLayout(new GridLayout(0, 1));
//        this.setBackground(new Color(0,0,0));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
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
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);

        //create the tree by passing in the root node
//        tree = new JTree(root);
        Tree tree = new Tree(root);
        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                            tree.getLastSelectedPathComponent();
                    if (node == null) return;
                    Object nodeInfo = node.getUserObject();
                    nodeInfo = nodeInfo;

                    RedisFileSystem.getInstance().openEditor(
                            new RedisObjectFile(PlantUmlToolWindowFactory.project));
                    // Cast nodeInfo to your object and do whatever you want
                }
            }
        });
        add(tree);

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setTitle("JTree Example");
//        this.pack();
//        this.setVisible(true);
    }

    private Tree createTree() {

        Tree tree = new Tree() {

            private final JLabel myLabel = new JLabel(
                    String.format("<html><center>No Mongo server available<br><br>You may use <img src=\"%s\"> to add configuration</center></html>", "SERVER")
            );

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                myLabel.setFont(getFont());
                myLabel.setBackground(getBackground());
                myLabel.setForeground(getForeground());
                Rectangle bounds = getBounds();
                Dimension size = myLabel.getPreferredSize();
                myLabel.setBounds(0, 0, size.width, size.height);

                int x = (bounds.width - size.width) / 2;
                Graphics g2 = g.create(bounds.x + x, bounds.y + 20, bounds.width, bounds.height);
                try {
                    myLabel.paint(g2);
                } finally {
                    g2.dispose();
                }
            }
        };

        tree.getEmptyText().clear();
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setName("mongoTree");
        tree.setRootVisible(true);

        new TreeSpeedSearch(tree, treePath -> {
            return "<empty>";
        });

        return tree;
    }
}

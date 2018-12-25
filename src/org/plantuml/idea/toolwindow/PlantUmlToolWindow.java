package org.plantuml.idea.toolwindow;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.*;

/**
 * @author Eugene Steinberg
 */
public class PlantUmlToolWindow extends JPanel implements Disposable {
    private static Logger logger = Logger.getInstance(PlantUmlToolWindow.class);

    private ToolWindow toolWindow;

    private Project project;

    public PlantUmlToolWindow(Project project, final ToolWindow toolWindow) {
        super(new BorderLayout());
        this.project = project;
        this.toolWindow = toolWindow;
        setupUI();
    }

    private void setupUI() {
//        final JPanel imagesPanel = new JPanel();
//        imagesPanel.setLayout(new BoxLayout(imagesPanel, BoxLayout.Y_AXIS));
//
//        final JBScrollPane scrollPane = new JBScrollPane(imagesPanel);
//        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
//        final Usage usage = new Usage("Usage:\n");
//        usage.setText("some text here");
//        imagesPanel.add(usage);
//        imagesPanel.add(new RightPane());

//        add(scrollPane, BorderLayout.CENTER);
        add(new RightPane(), BorderLayout.PAGE_START);

//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                Usage u1 = (Usage)imagesPanel.getComponent(0);
//                u1.setText("some text here 123");
//            }
//        };
//        r1.run();
    }
    @Override
    public void dispose() {
        logger.debug("dispose");
    }

}


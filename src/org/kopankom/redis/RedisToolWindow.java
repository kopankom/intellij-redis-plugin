package org.kopankom.redis;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.*;

public class RedisToolWindow extends JPanel implements Disposable {
    private static Logger logger = Logger.getInstance(RedisToolWindow.class);

    private ToolWindow toolWindow;

    private Project project;

    public RedisToolWindow(Project project, final ToolWindow toolWindow) {
        super(new BorderLayout());
        this.project = project;
        this.toolWindow = toolWindow;
        setupUI();
    }

    private void setupUI() {
        add(new RedisToolPanel(), BorderLayout.PAGE_START);
    }
    @Override
    public void dispose() {
        logger.debug("dispose");
    }

}


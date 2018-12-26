package org.kopankom.Redis;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class RedisToolWindowFactory implements ToolWindowFactory, DumbAware {

    public static Project project;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        RedisToolWindowFactory.project = project;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new RedisToolPanel(), BorderLayout.PAGE_START);
        Content content = contentFactory.createContent(mainPanel, "2", true);
        toolWindow.getContentManager().addContent(content);
    }

}

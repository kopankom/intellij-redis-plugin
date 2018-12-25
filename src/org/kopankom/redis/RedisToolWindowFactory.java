package org.kopankom.redis;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class RedisToolWindowFactory implements ToolWindowFactory, DumbAware {

    public static Project project;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        RedisToolWindowFactory.project = project;
        RedisToolWindow plantUmlToolWindow = new RedisToolWindow(project, toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(plantUmlToolWindow, "2", true);
        toolWindow.getContentManager().addContent(content);
    }

}

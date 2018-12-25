package org.plantuml.idea.toolwindow;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author Eugene Steinberg
 */
public class PlantUmlToolWindowFactory implements ToolWindowFactory, DumbAware {

    public static final String ID = "PlantUML 123";

    public static Project project;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        PlantUmlToolWindowFactory.project = project;
        RedisToolWindow plantUmlToolWindow = new RedisToolWindow(project, toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(plantUmlToolWindow, "sdfsdf", true);
        toolWindow.getContentManager().addContent(content);
    }

}

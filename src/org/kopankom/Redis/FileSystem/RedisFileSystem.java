package org.kopankom.Redis.FileSystem;

import com.intellij.openapi.application.ApplicationManager;
import org.kopankom.IntellijPlugin.FileSystem.BaseFileSystem;

public class RedisFileSystem extends BaseFileSystem {

    public RedisFileSystem() {
        super("REDIS", true);
    }

    public static BaseFileSystem getInstance() {
        return ApplicationManager.getApplication().getComponent(RedisFileSystem.class);
    }
}

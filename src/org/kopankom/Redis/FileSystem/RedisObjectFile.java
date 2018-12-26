package org.kopankom.Redis.FileSystem;

import com.intellij.openapi.vfs.VirtualFileSystem;
import org.kopankom.IntellijPlugin.FileSystem.ObjectFile;

public class RedisObjectFile extends ObjectFile {

    public RedisObjectFile(String fileName) {
        super(fileName);
    }

    @Override
    public VirtualFileSystem getFileSystem() {
        return RedisFileSystem.getInstance();
    }
}

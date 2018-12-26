package org.kopankom.IntellijPlugin.FileSystem;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.util.LocalTimeCounter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class ObjectFile extends VirtualFile {

    private final long modificationTimestamp;
    private final String fileName;

    public ObjectFile(String fileName) {
        this.modificationTimestamp = LocalTimeCounter.currentTime();
        this.fileName = fileName;
    }

    @NotNull
    @Override
    public String getName() {
        return this.fileName;
    }

    public abstract VirtualFileSystem getFileSystem();

    @NotNull
    @Override
    public String getPath() {
        return fileName;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public VirtualFile getParent() {
        return null;
    }

    @Override
    public VirtualFile[] getChildren() {
        return new VirtualFile[0];
    }

    @NotNull
    @Override
    public OutputStream getOutputStream(Object requestor, long newModificationStamp, long newTimeStamp) {
        throw new UnsupportedOperationException("File is read-only");
    }

    @Override
    public long getModificationStamp() {
        return modificationTimestamp;
    }

    @NotNull
    @Override
    public byte[] contentsToByteArray() {
        return new byte[0];
    }

    @Override
    public long getTimeStamp() {
        return 0;
    }

    @Override
    public long getLength() {
        return 0;
    }

    @Override
    public void refresh(boolean asynchronous, boolean recursive, @Nullable Runnable postRunnable) {}

    @Override
    public InputStream getInputStream() {
        return null;
    }
}

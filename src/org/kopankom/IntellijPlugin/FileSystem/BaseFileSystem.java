package org.kopankom.IntellijPlugin.FileSystem;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileListener;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.openapi.vfs.newvfs.impl.NullVirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kopankom.Redis.RedisToolWindowFactory;

public class BaseFileSystem extends VirtualFileSystem {

    private final String procol;
    private final boolean readOnly;

    public BaseFileSystem(String protocolName, boolean readOnly) {
        this.procol = protocolName;
        this.readOnly = readOnly;
    }

    @NotNull
    @Override
    public String getProtocol() {
        return this.procol;
    }

    public void openEditor(final ObjectFile objectFile) {
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(RedisToolWindowFactory.project);
        fileEditorManager.openFile(objectFile, true);
    }

    @Nullable
    @Override
    public VirtualFile findFileByPath(@NotNull @NonNls String path) {
        return null;
    }

    @Override
    public void refresh(boolean asynchronous) {

    }

    @Nullable
    @Override
    public VirtualFile refreshAndFindFileByPath(@NotNull String path) {
        return null;
    }

    @Override
    public void addVirtualFileListener(@NotNull VirtualFileListener listener) {

    }

    @Override
    public void removeVirtualFileListener(@NotNull VirtualFileListener listener) {

    }

    @Override
    protected void deleteFile(Object requestor, @NotNull VirtualFile vFile) {

    }

    @Override
    protected void moveFile(Object requestor, @NotNull VirtualFile vFile, @NotNull VirtualFile newParent) {

    }

    @Override
    protected void renameFile(Object requestor, @NotNull VirtualFile vFile, @NotNull String newName) {

    }

    @NotNull
    @Override
    protected VirtualFile createChildFile(Object requestor, @NotNull VirtualFile vDir, @NotNull String fileName) {
        return NullVirtualFile.INSTANCE;
    }

    @NotNull
    @Override
    protected VirtualFile createChildDirectory(Object requestor, @NotNull VirtualFile vDir, @NotNull String dirName) {
        return NullVirtualFile.INSTANCE;
    }

    @NotNull
    @Override
    protected VirtualFile copyFile(Object requestor, @NotNull VirtualFile virtualFile, @NotNull VirtualFile newParent, @NotNull String copyName) {
        return NullVirtualFile.INSTANCE;
    }

    @Override
    public boolean isReadOnly() {
        return this.readOnly;
    }
}

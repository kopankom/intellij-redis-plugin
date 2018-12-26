package org.kopankom.Redis;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import com.intellij.openapi.util.UserDataHolderBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.beans.PropertyChangeListener;

class RedisDataEditor extends UserDataHolderBase implements FileEditor {


    private DataExplorerPanel panel;
    private boolean disposed;

    public RedisDataEditor() {
        panel = new DataExplorerPanel();
    }

    @NotNull
    @Override
    public JComponent getComponent() {
        return this.disposed ? new JPanel() : panel;
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return panel == null ? null : null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void dispose() {
        if (!disposed) {
            panel.dispose();
            panel = null;
            disposed = true;
        }
    }

    @NotNull
    @Override
    public FileEditorState getState(@NotNull FileEditorStateLevel level) {
        return FileEditorState.INSTANCE;
    }

    @Override
    public void setState(@NotNull FileEditorState state) {}

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void selectNotify() {}

    @Override
    public void deselectNotify() {}

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {}

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {}

    @Nullable
    @Override
    public BackgroundEditorHighlighter getBackgroundHighlighter() {
        return null;
    }

    @Nullable
    @Override
    public FileEditorLocation getCurrentLocation() {
        return null;
    }

    @Nullable
    @Override
    public StructureViewBuilder getStructureViewBuilder() {
        return null;
    }
}

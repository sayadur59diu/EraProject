package com.devmonplugin;

import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import org.jetbrains.annotations.NotNull;

public class EditorActivityListener implements EditorFactoryListener {

    @Override
    public void editorCreated(@NotNull EditorFactoryEvent event) {
        // Attach a DocumentListener to detect edits
        event.getEditor().getDocument().addDocumentListener(new DocumentActivityListener(event));
        System.out.println("Listener attached to editor: " + event.getEditor());
    }

    @Override
    public void editorReleased(@NotNull EditorFactoryEvent event) {
        System.out.println("Editor closed, listener removed automatically.");
    }
}

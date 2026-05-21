package com.devmonplugin;


import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class DocumentActivityListener implements DocumentListener {

    private final EditorFactoryEvent editorEvent;

    public DocumentActivityListener(EditorFactoryEvent event) {
        this.editorEvent = event;
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        Project project = editorEvent.getEditor().getProject();
        String projectName = project != null ? project.getName() : "Unknown Project";
        String fileName = FileDocumentManager.getInstance().getFile(event.getDocument()) != null
                ? FileDocumentManager.getInstance().getFile(event.getDocument()).getName()
                : "Unknown File";

        System.out.println("User edited file: " + fileName + " in project: " + projectName + " at " + LocalDateTime.now());

        // Send to Spring Boot API
        DevActivitySender.sendActivity(projectName, fileName, "ACTIVE", LocalDateTime.now());
    }
}


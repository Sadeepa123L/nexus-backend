package com.nexus.workspace_service.controller;

import com.nexus.workspace_service.dto.WorkspaceRequestDTO;
import com.nexus.workspace_service.dto.WorkspaceResponseDTO;
import com.nexus.workspace_service.service.custom.WorkspaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping("/save")
    public ResponseEntity<WorkspaceResponseDTO> createWorkspace(@Valid @RequestBody WorkspaceRequestDTO workspaceRequestDTO) {
        WorkspaceResponseDTO response = workspaceService.createWorkspace(workspaceRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceResponseDTO> getWorkspace(@PathVariable Long id) {
        WorkspaceResponseDTO response = workspaceService.getWorkspaceById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkspaceResponseDTO> updateWorkspace(@PathVariable Long id, @Valid @RequestBody WorkspaceRequestDTO workspaceRequestDTO) {
        WorkspaceResponseDTO response = workspaceService.updateWorkspace(id, workspaceRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable Long id) {
        workspaceService.deleteWorkspace(id);
        return ResponseEntity.noContent().build();
    }
}

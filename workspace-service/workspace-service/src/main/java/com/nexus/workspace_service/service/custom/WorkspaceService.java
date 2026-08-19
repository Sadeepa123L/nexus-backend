package com.nexus.workspace_service.service.custom;

import com.nexus.workspace_service.dto.WorkspaceRequestDTO;
import com.nexus.workspace_service.dto.WorkspaceResponseDTO;
import org.hibernate.jdbc.Work;

import java.util.List;

public interface WorkspaceService {
    WorkspaceResponseDTO createWorkspace(WorkspaceRequestDTO workspaceRequestDTO);

    WorkspaceResponseDTO getWorkspaceById(Long workspaceId);

    List<WorkspaceResponseDTO> getAllWorkspaces();

    WorkspaceResponseDTO updateWorkspace(Long workspaceId, WorkspaceRequestDTO workspaceRequestDTO);

    void deleteWorkspace(Long workspaceId);
}

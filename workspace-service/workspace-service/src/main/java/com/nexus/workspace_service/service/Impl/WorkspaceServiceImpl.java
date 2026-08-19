package com.nexus.workspace_service.service.Impl;

import com.nexus.workspace_service.dto.WorkspaceRequestDTO;
import com.nexus.workspace_service.dto.WorkspaceResponseDTO;
import com.nexus.workspace_service.entity.Workspace;
import com.nexus.workspace_service.repository.WorkspaceRepository;
import com.nexus.workspace_service.service.custom.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Override
    public WorkspaceResponseDTO createWorkspace(WorkspaceRequestDTO workspaceRequestDTO) {
        Workspace workspace = new Workspace();
        workspace.setName(workspaceRequestDTO.getName());
        workspace.setDescription(workspaceRequestDTO.getDescription());

        Workspace savedWorkspace = workspaceRepository.save(workspace);

        return mapToResponse(savedWorkspace);
    }

    @Override
    public WorkspaceResponseDTO getWorkspaceById(Long workspaceId) {
        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace not found with id: " + workspaceId));
        return mapToResponse(workspace);

    }

    @Override
    public List<WorkspaceResponseDTO> getAllWorkspaces() {
        List<Workspace> workspaces = workspaceRepository.findAll();
        return workspaces.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public WorkspaceResponseDTO updateWorkspace(Long workspaceId, WorkspaceRequestDTO workspaceRequestDTO) {
        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace not found with id: " + workspaceId));
        workspace.setName(workspaceRequestDTO.getName());
        workspace.setDescription(workspaceRequestDTO.getDescription());

        Workspace updatedWorkspace = workspaceRepository.save(workspace);
        return mapToResponse(updatedWorkspace);
    }

    @Override
    public void deleteWorkspace(Long workspaceId) {
        workspaceRepository.deleteById(workspaceId);
    }

    private WorkspaceResponseDTO mapToResponse(Workspace workspace) {
        return new WorkspaceResponseDTO(
                workspace.getId(),
                workspace.getName(),
                workspace.getDescription()
        );
    }
}

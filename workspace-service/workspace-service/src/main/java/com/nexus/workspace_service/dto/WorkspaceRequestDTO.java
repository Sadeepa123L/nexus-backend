package com.nexus.workspace_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceRequestDTO {
    @NotBlank(message = "Workspace name is required and cannot be empty")
    private String name;
    @NotBlank(message = "Workspace description is required and cannot be empty")
    private String description;
}

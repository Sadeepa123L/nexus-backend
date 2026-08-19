package com.nexus.workspace_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceResponseDTO {
    private Long id;
    private String name;
    private String description;
}

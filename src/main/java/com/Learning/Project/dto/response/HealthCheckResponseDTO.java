
package com.Learning.Project.dto.response;

public class HealthCheckResponseDTO {
    private String status;

    public HealthCheckResponseDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

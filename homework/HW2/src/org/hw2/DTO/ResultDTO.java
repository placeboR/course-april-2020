package org.hw2.DTO;

public class ResultDTO {
    int status;

    public ResultDTO() {
    }

    public ResultDTO(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "status='" + status + '\'' +
                '}';
    }
}

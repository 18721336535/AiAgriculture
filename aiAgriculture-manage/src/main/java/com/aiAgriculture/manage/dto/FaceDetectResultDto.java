package com.aiAgriculture.manage.dto;

public class FaceDetectResultDto {
    private String potId;
    private String faceExist;
    private String comments;

    public FaceDetectResultDto(String potId, String faceExist, String comments) {
        this.potId = potId;
        this.faceExist = faceExist;
        this.comments = comments;
    }

    public String getPotId() {
        return potId;
    }

    public void setPotId(String potId) {
        this.potId = potId;
    }

    public String getFaceExist() {
        return faceExist;
    }

    public void setFaceExist(String faceExist) {
        this.faceExist = faceExist;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

package com.blog.post.vo;

import java.time.LocalDateTime;


public class PostVo {

    private Long id;                    // 게시글 ID
    private String title;              // 제목
    private String previewContent;     // 내용 요약 (SUBSTRING 처리)
    private String thumbnailUrl;       // 썸네일 이미지 URL
    private String writerName;         // 작성자 닉네임
    private String writerProfileImg;   // 작성자 프로필 이미지
    private LocalDateTime createdAt;   // 작성일시
    private int commentCount;          // 댓글 수

    public PostVo() {

    }

    public PostVo(Long id,
                  String title,
                  String previewContent,
                  String thumbnailUrl,
                  String writerName,
                  String writerProfileImg,
                  LocalDateTime createdAt,
                  int commentCount) {
        this.id = id;
        this.title = title;
        this.previewContent = previewContent;
        this.thumbnailUrl = thumbnailUrl;
        this.writerName = writerName;
        this.writerProfileImg = writerProfileImg;
        this.createdAt = createdAt;
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "PostVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", previewContent='" + previewContent + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", writerName='" + writerName + '\'' +
                ", writerProfileImg='" + writerProfileImg + '\'' +
                ", createdAt=" + createdAt +
                ", commentCount=" + commentCount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreviewContent() {
        return previewContent;
    }

    public void setPreviewContent(String previewContent) {
        this.previewContent = previewContent;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterProfileImg() {
        return writerProfileImg;
    }

    public void setWriterProfileImg(String writerProfileImg) {
        this.writerProfileImg = writerProfileImg;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

}//class

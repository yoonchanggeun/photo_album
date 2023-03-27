package com.squarecross.photoalbum.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
    @Entity //DB테이블과 1-1 매칭되는 클래스 단위 객체(@Column) 하나가 DB의 ROW
    @Table(name = "photo", schema = "photo_album", uniqueConstraints = {@UniqueConstraint(columnNames = "photo_id")}) //매핑되는 테이블 관련정보를 정
    public class Photo {
        @Id //해당 Entity PK로 사용 @Id는 중복 값 x
        @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id 값을 새롭게 부여할떄 사용하는 방법에 대한 정보를 입력
        @Column(name = "photo_id", unique = true, nullable = false) // photo 테이블의 매핑되는 column 정보를 입력
        private Long photoId;

        @Column(name = "file_name", unique = false, nullable = true)
        private String fileName;

        @Column(name = "file_size", unique = false, nullable = true)
        private int fileSize;

        @Column(name = "original_url", unique = false, nullable = true)
        private String originalUrl;

        @Column(name = "thumb_url", unique = false, nullable = true)
        private String thumbUrl;

        @Column(name = "uploaded_at", unique = false, nullable = true)
        @CreationTimestamp // 업데이트 하면 자동으로 시간 입력
        private Date uploadedAt;

        @ManyToOne(fetch = FetchType.LAZY)  // 다른 테이블을 참조할때 어떤 관계인지 @ManyToOne, @OneToMany
        @JoinColumn(name = "album_id") //JoinColumn은 관계의 주인, 즉 관계가 있는 Entity의 Foreign Key를 자신의 Column으로 정의된 곳에서 사용합니다.
        private Album album;

        public Photo() {
        }

        ;

        public Long getPhotoId() {
            return photoId;
        }

        public void setPhotoId(Long photoId) {
            this.photoId = photoId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }

        public String getOriginalUrl() {
            return originalUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        public Date getUploadedAt() {
            return uploadedAt;
        }

        public void setUploadedAt(Date uploadedAt) {
            this.uploadedAt = uploadedAt;
        }

        public Album getAlbum() {
            return album;
        }

        public void setAlbum(Album album) {
            this.album = album;
        }

    }

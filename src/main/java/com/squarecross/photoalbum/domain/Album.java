package com.squarecross.photoalbum.domain;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity // 데이터베이스 테이블과 1-1로 매핑되는 클래스 단위 객체 하나가 DB의 레코드(Row)
@Table(name = "album", schema = "photo_album", uniqueConstraints ={@UniqueConstraint(columnNames="album_id")})  // 매핑되는 테이블 관련 정보를 정의
public class Album {

    @Id  //해당 Entity PK로 사용 @Id는 중복 값 x
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id 값을 새롭게 부여할떄 사용하는 방법에 대한 정보를 입력
    @Column(name = "album_id", unique = true, nullable = false) // album 테이블의 매핑되는 column 정보를 입력
    private Long albumId;

    @Column(name = "album_name", unique = false, nullable = false)
    private String albumName;

    @Column(name="created_at", unique = false, nullable = true)
    @CreationTimestamp // 새로운 앨범을 생성해 DB INSERT 할때 자동으로 현재 시간 입력해줌
    private Date createdAt;

    public Album(){};

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

package com.squarecross.photoalbum.repository;

import com.squarecross.photoalbum.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // spring bean으로 등록해서 loc에서 관리하게하기
public interface AlbumRepository extends JpaRepository<Album, Long> {/*JpaRepository를 상속하고 Album엔터티,PK의 타입정의*/
    Optional<Album> findAlbumByAlbumName(String albumName);

}

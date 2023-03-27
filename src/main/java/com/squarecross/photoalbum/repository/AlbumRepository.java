package com.squarecross.photoalbum.repository;

import com.squarecross.photoalbum.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // spring bean으로 등록해서 loc에서 관리하게하기
public interface AlbumRepository extends JpaRepository<Album, Long> {

}

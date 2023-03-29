package com.squarecross.photoalbum.service;

import com.squarecross.photoalbum.domain.Album;
import com.squarecross.photoalbum.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //스프링 컨테이너 내에 있는 모든 빈을 DI로 가져와서 사용하게 만듬
@Transactional // test시 db에 저장되면 좋지 않기에 주석표시
class AlbumServiceTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Test
    void getAlbum() {
        Album album = new Album();
        album.setAlbumName("테스트");
        Album savedAlbum = albumRepository.save(album);

        Album resAlbum = albumService.getAlbum(savedAlbum.getAlbumId());
        assertEquals("테스트", resAlbum.getAlbumName());
    }

    @Test
    void getAlbumByAlbumName() {
        Album album = new Album();
        album.setAlbumName("Test Album");
        albumRepository.save(album);

        Album resAlbum = albumService.getAlbumByAlbumName("Test Album");
        assertEquals("Test Album", resAlbum.getAlbumName());
    }
}

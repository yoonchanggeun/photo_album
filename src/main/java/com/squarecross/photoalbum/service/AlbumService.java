package com.squarecross.photoalbum.service;

import com.squarecross.photoalbum.domain.Album;
import com.squarecross.photoalbum.dto.AlbumDto;
import com.squarecross.photoalbum.mapper.AlbumMapper;
import com.squarecross.photoalbum.repository.AlbumRepository;
import com.squarecross.photoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service //Bean으로 등록하여 loc 컨테이너에 추가
public class AlbumService {

    @Autowired //컨테이너에 등록된 빈을 가져와서 사용
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;

    public AlbumDto getAlbum(Long albumId){
        Optional<Album> res = albumRepository.findById(albumId);  //albumRepository에서 DB에 있는 앨범 ID를 찾는다 Optional은 예외처리
        if (res.isPresent()){ // 만약에 findById를 한 res가 null이 아니면 return에서 앨범 엔터티를 반환
           AlbumDto albumDto = AlbumMapper.convertDto(res.get());
           albumDto.setCount(photoRepository.countByAlbum_AlbumId(albumId));
            return albumDto;
        }else { //res가 null이면 메서드 실행
            throw new EntityNotFoundException(String.format("앨범 아이디 %d로 조회되지 않았습니다", albumId));

        }
    }

    public Album getAlbumByAlbumName(String albumName) {
        Optional<Album> optionalAlbum = albumRepository.findAlbumByAlbumName(albumName);
        if (optionalAlbum.isPresent()) {
            return optionalAlbum.get();
        } else {
            throw new EntityNotFoundException(String.format("앨범명 %s로 조회되지 않았습니다", albumName));
        }
    }
}



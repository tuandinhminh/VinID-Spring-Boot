package com.example.demo.service;

import com.example.demo.dto.MoviesDTO;
import com.example.demo.entity.MoviesEntity;
import com.example.demo.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {
    @Autowired
    private IMoviesRepository iMoviesRepository;
    public List<MoviesDTO> getMovies(){
        List<MoviesEntity> entities = iMoviesRepository.findAll();
        List<MoviesDTO> dtos = new ArrayList<>();
        for (MoviesEntity item: entities){
            MoviesDTO dto = new MoviesDTO(
                    item.getId(),
                    item.getCreatedDate(),
                    item.getCreatedDate(),
                    item.getTitle(),
                    item.getDurationMin(),
                    item.getImage(),
                    item.getDescription(),
                    item.getStatus()
            );
            dtos.add(dto);
        }
        return  dtos;
    }

    public MoviesDTO saveMovie(MoviesDTO model){
        MoviesEntity entity = new MoviesEntity();
        if (model.getId() != null){
            entity = iMoviesRepository.findOneById(model.getId());
        }
        entity.setDescription(model.getDescription());
        entity.setDurationMin(model.getDuration_min());
        entity.setImage(model.getImage());
        entity.setStatus(model.getStatus());
        entity.setTitle(model.getTitle());

        entity =iMoviesRepository.save(entity);
        MoviesDTO dto = new MoviesDTO(
                entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getDescription(),
                entity.getDurationMin(),
                entity.getImage(),
                entity.getStatus(),
                entity.getTitle()
        );
        return dto;
    }

    public void deleteMovies(long[] ids) {
        for(long item: ids) {
            iMoviesRepository.deleteById(item);
        }
    }
}

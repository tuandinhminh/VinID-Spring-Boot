package com.example.demo.service;

import com.example.demo.dto.ScreeningsDTO;
import com.example.demo.entity.ScreeningsEntity;
import com.example.demo.repository.IScreeningsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScreeningsService {
    @Autowired
    private IScreeningsRepository iScreeningsRepository;
    public List<ScreeningsDTO> getScreeningsByMovieId(Long id){
        List<ScreeningsEntity> entities = iScreeningsRepository.findAllByMovieId(id);
        List<ScreeningsDTO> dtos = new ArrayList<>();
        for (ScreeningsEntity item: entities){
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(item.getStartTime());
            pattern = "HH:mm";
            simpleDateFormat = new SimpleDateFormat(pattern);
            String time = simpleDateFormat.format(item.getStartTime());
            ScreeningsDTO dto = new ScreeningsDTO(
                    item.getId(),
                    item.getCreatedDate(),
                    item.getCreatedDate(),
                    item.getAmount(),
                    item.getAuditorium().getId(),
                    time,
                    date,
                    item.getMovie().getId()
            );
            dtos.add(dto);
        }
        return  dtos;
    }
}

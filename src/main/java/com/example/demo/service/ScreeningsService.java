package com.example.demo.service;

import com.example.demo.Exception.ScreeningAmountException;
import com.example.demo.dto.ScreeningsDTO;
import com.example.demo.dto.SeatsDTO;
import com.example.demo.entity.*;
import com.example.demo.form.ResponseSeats;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningsService {
    @Autowired
    private IScreeningsRepository iScreeningsRepository;
    @Autowired
    private IAuditoriumsRepository iAuditoriumsRepository;
    @Autowired
    private IMoviesRepository iMoviesRepository;
    @Autowired
    private ISeatsRepository iSeatsRepository;
    @Autowired
    private IReservedSeatsRepository iReservedSeatsRepository;

    Calendar calendar = Calendar.getInstance();
    public List<ScreeningsDTO> getScreeningsByMovieId(Long id){
        List<ScreeningsEntity> entities = iScreeningsRepository.findAllByMovieId(id);
        List<ScreeningsDTO> dtos = new ArrayList<>();
        for (ScreeningsEntity item: entities){
            calendar.setTime(item.getStartTime());
            calendar.add(Calendar.HOUR_OF_DAY,-7);
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(calendar.getTime());
            pattern = "HH:mm";
            simpleDateFormat = new SimpleDateFormat(pattern);
            String time = simpleDateFormat.format(calendar.getTime());
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

    public List<ScreeningsDTO> getScreeningsByStartDate(String date1,String date2){
        List<ScreeningsEntity> entities = iScreeningsRepository.findAllByStartDate(date1,date2);
        List<ScreeningsDTO> dtos = new ArrayList<>();
        for(ScreeningsEntity entity : entities){
            calendar.setTime(entity.getStartTime());
            calendar.add(Calendar.HOUR_OF_DAY,-7);
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(calendar.getTime());
            pattern = "HH:mm";
            simpleDateFormat = new SimpleDateFormat(pattern);
            String time = simpleDateFormat.format(calendar.getTime());
            ScreeningsDTO dto = new ScreeningsDTO(
                    entity.getId(),
                    entity.getCreatedDate(),
                    entity.getModifiedDate(),
                    entity.getAmount(),
                    entity.getAuditorium().getId(),
                    time,
                    date,
                    entity.getMovie().getId()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    public ScreeningsDTO saveScreening(ScreeningsDTO model) throws ParseException {
        ScreeningsEntity entity = new ScreeningsEntity();
        if (model.getId() != null){
            entity = iScreeningsRepository.findOneById(model.getId());
        }
        entity.setAmount(model.getAmount());

        String pattern = "HH:mm dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(model.getStart_time()+" "+model.getStart_date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY,7);
        entity.setStartTime(calendar.getTime());

        AuditoriumsEntity auditoriumsEntity = iAuditoriumsRepository.findOneById(model.getAuditorium_id());
        entity.setAuditorium(auditoriumsEntity);
        MoviesEntity moviesEntity = iMoviesRepository.findOneById(model.getMovie_id());
        entity.setMovie(moviesEntity);
        entity =iScreeningsRepository.save(entity);
        //get response
        calendar.setTime(entity.getStartTime());
        calendar.add(Calendar.HOUR_OF_DAY,-7);
        pattern = "dd-MM-yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern);
        String date1 = simpleDateFormat.format(calendar.getTime());
        pattern = "HH:mm";
        simpleDateFormat = new SimpleDateFormat(pattern);
        String time = simpleDateFormat.format(calendar.getTime());
        ScreeningsDTO dto = new ScreeningsDTO(
                entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                entity.getAmount(),
                entity.getAuditorium().getId(),
                time,
                date1,
                entity.getMovie().getId()
        );
        return dto;
    }

    public void updateAmount(Long screening_id) {
        ScreeningsEntity entity = iScreeningsRepository.findOneById(screening_id);
        int amount = entity.getAmount();
        if (amount >= 1){
            amount-=1;
            entity.setAmount(amount);
            entity = iScreeningsRepository.save(entity);
        }
        else
        {
            throw new ScreeningAmountException();
        }
    }

    public ResponseSeats getAllSeats(long id) {
        ResponseSeats responseSeats = new ResponseSeats(id);
        List<SeatsEntity> entities = iSeatsRepository.findAll();
        List<SeatsDTO> dtos = new ArrayList<>();
        for(SeatsEntity entity : entities){
            SeatsDTO dto = new SeatsDTO(
                    entity.getId(),
                    entity.getSeatNumber(),
                    entity.getSeatRow(),
                    0
            );
            dtos.add(dto);
        }
        List<ReservedSeatsEntity> entities1 = iReservedSeatsRepository.findAllByScreeningId(id);
        for(ReservedSeatsEntity entity : entities1){
            SeatsDTO dto = dtos.get(Math.toIntExact(entity.getSeat().getId())-1);
            dtos.set(Math.toIntExact(entity.getSeat().getId())-1,new SeatsDTO(
                    dto.getId(),
                    dto.getSeat_number(),
                    dto.getSeat_row(),
                    1
            ));
        }
        responseSeats.setSeats(dtos);
        return responseSeats;
    }
}

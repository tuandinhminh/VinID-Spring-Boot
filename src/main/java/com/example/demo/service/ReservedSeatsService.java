package com.example.demo.service;

import com.example.demo.dto.ReservedSeatsDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservedSeatsService {
    @Autowired
    private IReservedSeatsRepository iReservedSeatsRepository;
    @Autowired
    private IReservationsRepository iReservationsRepository;
    @Autowired
    private IScreeningsRepository iScreeningsRepository;
    @Autowired
    private ISeatsRepository iSeatsRepository;
    @Autowired
    private ISeatTypesRepository iSeatTypesRepository;
    public List<ReservedSeatsDTO> getReservedSeats(){
        List<ReservedSeatsEntity> entities = iReservedSeatsRepository.findAll();
        List<ReservedSeatsDTO> dtos = new ArrayList<>();
        for (ReservedSeatsEntity item: entities){
            ReservedSeatsDTO dto = new ReservedSeatsDTO(
                    item.getId(),
                    item.getCreatedDate(),
                    item.getCreatedDate(),
                    item.getSeat().getId(),
                    item.getReservation().getId(),
                    item.getScreening().getId(),
                    item.getSeatType().getId()
                    );
            dtos.add(dto);
        }
        return  dtos;
    }

    public List<ReservedSeatsDTO> getReservedSeatsByReservationsId(Long res_id){
        List<ReservedSeatsEntity> entities = iReservedSeatsRepository.findAllByReservationId(res_id);
        List<ReservedSeatsDTO> dtos = new ArrayList<>();
        for (ReservedSeatsEntity item: entities){
            ReservedSeatsDTO dto = new ReservedSeatsDTO(
                    item.getId(),
                    item.getCreatedDate(),
                    item.getCreatedDate(),
                    item.getSeat().getId(),
                    item.getReservation().getId(),
                    item.getScreening().getId(),
                    item.getSeatType().getId()
            );
            dtos.add(dto);
        }
        return  dtos;
    }

    public List<ReservedSeatsDTO> getReservedSeatsByScreeningId(Long scr_id){
        List<ReservedSeatsEntity> entities = iReservedSeatsRepository.findAllByScreeningId(scr_id);
        List<ReservedSeatsDTO> dtos = new ArrayList<>();
        for (ReservedSeatsEntity item: entities){
            ReservedSeatsDTO dto = new ReservedSeatsDTO(
                    item.getId(),
                    item.getCreatedDate(),
                    item.getCreatedDate(),
                    item.getSeat().getId(),
                    item.getReservation().getId(),
                    item.getScreening().getId(),
                    item.getSeatType().getId()
            );
            dtos.add(dto);
        }
        return  dtos;
    }

    public ReservedSeatsDTO saveReservedSeat(ReservedSeatsDTO model) {
        ReservedSeatsEntity entity = new ReservedSeatsEntity();

        if (model.getId() != null){
            entity = iReservedSeatsRepository.findOneById(model.getId());
        }
        ReservationsEntity reservationsEntity = iReservationsRepository.findOneById(model.getReservation_id());
        entity.setReservation(reservationsEntity);
        ScreeningsEntity screeningsEntity = iScreeningsRepository.findOneById(model.getScreening_id());
        entity.setScreening(screeningsEntity);
        SeatsEntity seatsEntity = iSeatsRepository.findOneById(model.getSeat_id());
        entity.setSeat(seatsEntity);
        SeatTypesEntity seatTypesEntity = iSeatTypesRepository.findOneById(model.getType_id());
        entity.setSeatType(seatTypesEntity);
        entity = iReservedSeatsRepository.save(entity);
        ReservedSeatsDTO dto = new ReservedSeatsDTO(
                entity.getId(),
                entity.getCreatedDate(),
                entity.getModifiedDate(),
                reservationsEntity.getId(),
                screeningsEntity.getId(),
                seatsEntity.getId(),
                seatTypesEntity.getId()
            );
        return dto;
    }

    public void deleteReservedSeats(long[] ids) {
        for(long item: ids) {
            iReservedSeatsRepository.deleteById(item);
        }
    }
}

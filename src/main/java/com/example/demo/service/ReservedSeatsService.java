package com.example.demo.service;

import com.example.demo.dto.ReservedSeatsDTO;
import com.example.demo.entity.ReservedSeatsEntity;
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

//    public ReservedSeatsDTO saveReservation(ReservedSeatsDTO model) {
//        ReservedSeatsEntity ReservedSeatsEntity = new ReservedSeatsEntity();
//
//        if (model.getId() != null){
//            ReservedSeatsEntity = iReservedSeatsRepository.findOneById(model.getId());
//            ReservedSeatsEntity.setStatus(model.getStatus());
//        }
//        else {
//            ReservedSeatsEntity.setStatus(model.getStatus());
//        }
//        UsersEntity usersEntity = iUsersRepository.findOneById(model.getUser_id());
//        ReservedSeatsEntity.setUser(usersEntity);
//        ReservedSeatsEntity = iReservedSeatsRepository.save(ReservedSeatsEntity);
//        ReservedSeatsDTO ReservedSeatsDTO = new ReservedSeatsDTO(
//                ReservedSeatsEntity.getId(),
//                ReservedSeatsEntity.getCreatedDate(),
//                ReservedSeatsEntity.getModifiedDate(),
//                ReservedSeatsEntity.getStatus(),
//                usersEntity.getId());
//        return ReservedSeatsDTO;
//    }

    public void deleteReservedSeats(long[] ids) {
        for(long item: ids) {
            iReservedSeatsRepository.deleteById(item);
        }
    }
}

package com.example.demo.service;

import com.example.demo.dto.ReservationsDTO;
import com.example.demo.entity.ReservationsEntity;
import com.example.demo.entity.UsersEntity;
import com.example.demo.repository.IReservationsRepository;
import com.example.demo.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {
    @Autowired
    private IReservationsRepository iReservationsRepository;
    @Autowired
    private IUsersRepository iUsersRepository;
    public List<ReservationsDTO> getReservations(){
        List<ReservationsEntity> reservationsEntities = iReservationsRepository.findAll();
        List<ReservationsDTO> reservationsDTOS = new ArrayList<>();
        for (ReservationsEntity item: reservationsEntities){
            ReservationsDTO reservationsDTO = new ReservationsDTO(
                    item.getId(),
                    item.getCreatedDate(),
                    item.getCreatedDate(),
                    item.getStatus(),
                    item.getUser().getId());
            reservationsDTOS.add(reservationsDTO);
        }
        return  reservationsDTOS;
    }

    public ReservationsDTO saveReservation(ReservationsDTO model) {
        ReservationsEntity reservationsEntity = new ReservationsEntity();

        if (model.getId() != null){
            reservationsEntity = iReservationsRepository.findOneById(model.getId());
            reservationsEntity.setStatus(model.getStatus());
        }
        else {
            reservationsEntity.setStatus(model.getStatus());
        }
        UsersEntity usersEntity = iUsersRepository.findOneById(model.getUser_id());
        reservationsEntity.setUser(usersEntity);
        reservationsEntity = iReservationsRepository.save(reservationsEntity);
        ReservationsDTO reservationsDTO = new ReservationsDTO(
                reservationsEntity.getId(),
                reservationsEntity.getCreatedDate(),
                reservationsEntity.getModifiedDate(),
                reservationsEntity.getStatus(),
                usersEntity.getId());
        return reservationsDTO;
    }
    public ResponseEntity<?> getReservationById(long id) {
        ReservationsDTO dto = new ReservationsDTO();
        ReservationsEntity entity = iReservationsRepository.findOneById(id);
        if (entity != null) {
            dto.setId(entity.getId());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedDate(entity.getModifiedDate());
            dto.setStatus(entity.getStatus());
            dto.setUser_id(entity.getUser().getId());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Đã có lỗi xảy ra");

    }
    public void deleteReservations(long[] ids) {
        for(long item: ids) {
            iReservationsRepository.deleteById(item);
        }
    }
}

package com.example.demo.service.imp;

import com.example.demo.model.Park;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ParkRepository;
import com.example.demo.service.ParkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkServiceImp implements ParkService {

    private final ParkRepository parkRepository;

    public ParkServiceImp(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }



    @Override
    public List<Park> getPark() {
        return parkRepository.findAll();
    }
}

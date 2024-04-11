package edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.entities.Surgery;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.repositories.SurgeryRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerieslab6.services.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }


    @Override
    public Surgery createSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public List<Surgery> getAllSurgery() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery updateSurgery(Surgery surgery) {
        return surgeryRepository.saveAndFlush(surgery);
    }

    @Override
    public void deleteSurgery(Surgery surgery) {
        surgeryRepository.delete(surgery);
    }
}

package edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.services;

import edu.miu.cs.cs489appsd.adsdentalsurgerieslab7.entities.OfficeManager;

import java.util.List;

public interface OfficeManagerService {
    OfficeManager createOfficeManager(OfficeManager officeManager);
    List<OfficeManager> getOfficeManagers();
    OfficeManager updateOfficeManager(OfficeManager officeManager);
    void deleteOfficeManager(OfficeManager officeManager);
}

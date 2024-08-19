package com.bloodbank.service;

import com.bloodbank.dao.UtilizatorDAO;
import com.bloodbank.model.Utilizator;

public class UtilizatorService {
    private final UtilizatorDAO utilizatorDAO;

    public UtilizatorService() {
        this.utilizatorDAO = new UtilizatorDAO();
    }

    public boolean autentificareUtilizator(String username, String password) {
        Utilizator utilizator = utilizatorDAO.getUtilizatorByUsernameAndPassword(username, password);
        return utilizator != null;
    }

    public void addUtilizator(Utilizator utilizator) {
        utilizatorDAO.addUtilizator(utilizator);
    }

    public void updateUtilizator(Utilizator utilizator) {
        utilizatorDAO.updateUtilizator(utilizator);
    }

    public void deleteUtilizator(int id) {
        utilizatorDAO.deleteUtilizator(id);
    }
}
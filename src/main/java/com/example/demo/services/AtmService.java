package com.example.demo.services;

import com.example.demo.models.Atm;
import java.util.List;

public interface AtmService {
  public List<Atm> getByIdno(String idno);

  public List<Atm> getByremitterIdno(String remitterIdno);

  public void saveAtm(Atm[] atms);

  public void delete(Long id);

  public List<Atm> getAll();
}

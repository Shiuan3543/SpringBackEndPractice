package com.example.demo.services;

import com.example.demo.models.Atm;
import com.example.demo.Repository.AtmRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImp implements AtmService {

  @Autowired
  private AtmRepository atmRepository;

  // 用名字取出各項交易
  @Override
  public List<Atm> getByremitterIdno(String remitterIdno) {
    System.out.println("--------------Test getByremitterIdno--------------");
    return this.atmRepository.getByRemitterIdno(remitterIdno);
  }

  // 用身分證取出各項交易
  @Override
  public List<Atm> getByIdno(String idno) {
    System.out.println("--------------Test getByIdno--------------");

    List<Atm> returnList = new ArrayList<Atm>();
    List<Atm> atmList = this.atmRepository.getByIdno(idno);
    for (int i = 0; i < atmList.size(); i++) {
      if (!atmList.get(i).isIsFinish()) {
        returnList.add(atmList.get(i));
      }
    }

    return returnList;
  }

  // 存入各項交易
  @Override
  public void saveAtm(Atm[] atms) {
    for (int i = 0; i < atms.length; i++) {
      this.atmRepository.save(atms[i]);
    }
  }

  // 刪除交易
  @Override
  public void delete(Long id) {
    this.atmRepository.deleteById(id);
  }

  @Override
  public List<Atm> getAll() {
    // TODO Auto-generated method stub
    return this.atmRepository.findAll();
  }
}

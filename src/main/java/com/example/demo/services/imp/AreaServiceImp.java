package com.example.demo.services.imp;

import com.example.demo.models.Area;
import com.example.demo.Repository.AreaRepository;
import com.example.demo.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImp implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> getByHsn_cd(String hsnCd) {
        return areaRepository.getByHsnCd(hsnCd);
    }

    @Override
    public List<Area> getAll() {
        return areaRepository.findAll();
    }
}

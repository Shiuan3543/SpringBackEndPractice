package com.example.demo.services;

import com.example.demo.models.Area;

import java.util.List;

public interface AreaService {

    public List<Area> getByHsn_cd(String hsn_sd);

    public List<Area> getAll();
}

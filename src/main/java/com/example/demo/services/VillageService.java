package com.example.demo.services;

import com.example.demo.models.Village;

import java.util.List;

public interface VillageService {

    public List<Village> getVillages(String hsnCd, String townCd);
}

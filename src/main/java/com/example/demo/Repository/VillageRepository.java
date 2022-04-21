package com.example.demo.Repository;

import com.example.demo.models.Village;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VillageRepository extends JpaRepository<Village, Long> {

    public List<Village> getByHsnCd(String hsnCd);
}

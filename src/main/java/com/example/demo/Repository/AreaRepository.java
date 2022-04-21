package com.example.demo.Repository;

import com.example.demo.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {

    public List<Area> getByHsnCd(String hsnCd);
}

package com.example.demo.controllers;

import com.example.demo.models.Atm;
import com.example.demo.services.AtmService;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AtmController {

  @Autowired
  private AtmService atmService;

  @PostMapping("/atm/getByName")
  public ResponseEntity<List<Atm>> getByName(@RequestBody Atm atm) {
    // public ResponseEntity<List<com.example.demo.models.Atm>> getByName(@RequestBody Atm atm)
    System.out.println("--------Post mapping test--------");
    try {
      List<Atm> atmList = atmService.getByremitterIdno(atm.getAgentIdno());
      if (atmList == null) {
        return new ResponseEntity<List<Atm>>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<List<Atm>>(atmList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<Atm>>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/atm/getByIdno")
  public ResponseEntity<List<Atm>> getByIdno(@RequestBody String idno) {
    // public ResponseEntity<List<com.example.demo.models.Atm>> getByName(@RequestBody Atm atm)
    System.out.println("--------Post mapping test--------");
    try {
      List<Atm> atmList = atmService.getByIdno(idno);
      if (atmList == null) {
        return new ResponseEntity<List<Atm>>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<List<Atm>>(atmList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<List<Atm>>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/atm/add")
  public ResponseEntity<Atm[]> add(@RequestBody Atm[] atms) {
    try {
      if (atms == null) {
        return new ResponseEntity<Atm[]>(HttpStatus.NOT_FOUND);
      }
      atmService.saveAtm(atms);
      return new ResponseEntity<Atm[]>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<Atm[]>(HttpStatus.NOT_FOUND);
    }
  }

  // @DeleteMapping("/atm/delete")
  // public void delete(@RequestBody Atm atm) {
  //     atmService.delete(atm.getId());
  // }
  @DeleteMapping("/atm/delete/{id}")
  public void delete(@PathVariable Long id) {
    atmService.delete(id);
  }

  @GetMapping("/atm/all")
  public List<Atm> getAll() {
    return atmService.getAll();
  }
}

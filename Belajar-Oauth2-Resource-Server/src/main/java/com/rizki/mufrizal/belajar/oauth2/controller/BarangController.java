package com.rizki.mufrizal.belajar.oauth2.controller;

import com.rizki.mufrizal.belajar.oauth2.domain.Barang;
import com.rizki.mufrizal.belajar.oauth2.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @Secured({"ADMIN","USER"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/barang", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Barang> getBarang(){
        return barangService.getBarangList();
    }

}

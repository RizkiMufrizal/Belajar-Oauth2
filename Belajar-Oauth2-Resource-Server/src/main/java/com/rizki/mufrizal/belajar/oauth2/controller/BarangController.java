package com.rizki.mufrizal.belajar.oauth2.controller;

import com.rizki.mufrizal.belajar.oauth2.domain.Barang;
import com.rizki.mufrizal.belajar.oauth2.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = BarangController.API)
public class BarangController {

    @Autowired
    private BarangService barangService;

    public static final String API = "/api";
    public static final String LIST_BARANG = "/Barang";
    public static final String SAVE_BARANG = "/SaveBarang";
    public static final String UPDATE_BARANG = "/UpdateBarang";
    public static final String DELETE_BARANG = "/DeleteBarang/{idBarang}";

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = LIST_BARANG, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Barang> getBarang() {
        return barangService.getBarangList();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = SAVE_BARANG, method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> saveBarang(@RequestBody Barang barang) {

        barangService.save(barang);

        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Info", "Save Data Berhasil");

        return message;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = UPDATE_BARANG, method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateBarang(@RequestBody Barang barang) {

        barangService.update(barang);

        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Info", "Update Data Berhasil");

        return message;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = DELETE_BARANG, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteBarang(@PathVariable("idBarang")String idBarang) {

        Barang barang = barangService.getBarang(idBarang);
        barangService.delete(barang);

        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Info", "Data Berhasil Dihapus");

        return message;
    }

}

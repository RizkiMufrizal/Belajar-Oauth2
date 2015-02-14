package com.rizki.mufrizal.belajar.oauth2.service;

import com.rizki.mufrizal.belajar.oauth2.domain.Barang;

import java.util.List;

public interface BarangService {
    public void save(Barang barang);

    public void update(Barang barang);

    public void delete(Barang barang);

    public Barang getBarang(String idBarang);

    public List<Barang> getBarangList();
}

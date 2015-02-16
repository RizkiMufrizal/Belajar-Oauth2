package com.rizki.mufrizal.belajar.oauth2.service.impl;

import com.rizki.mufrizal.belajar.oauth2.domain.Barang;
import com.rizki.mufrizal.belajar.oauth2.repository.BarangRepository;
import com.rizki.mufrizal.belajar.oauth2.service.BarangService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BarangServiceImpl implements BarangService {

    @Resource
    private BarangRepository barangRepository;

    @Transactional(readOnly = false)
    @CacheEvict(value = "barang", allEntries = true)
    @Override
    public void save(Barang barang) {
        barangRepository.save(barang);
    }

    @Transactional(readOnly = false)
    @CacheEvict(value = "barang", allEntries = true)
    @Override
    public void update(Barang barang) {
        barangRepository.saveAndFlush(barang);
    }

    @Transactional(readOnly = false)
    @CacheEvict(value = "barang", allEntries = true)
    @Override
    public void delete(Barang barang) {
        barangRepository.delete(barang);
    }

    @Cacheable(value = "barang", key = "#idBarang")
    @Override
    public Barang getBarang(String idBarang) {
        return barangRepository.findOne(idBarang);
    }

    @Cacheable(value = "barang")
    @Override
    public List<Barang> getBarangList() {
        return barangRepository.findAll();
    }
}

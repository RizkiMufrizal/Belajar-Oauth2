package com.rizki.mufrizal.belajar.oauth2.repository;

import com.rizki.mufrizal.belajar.oauth2.domain.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, String>{
}

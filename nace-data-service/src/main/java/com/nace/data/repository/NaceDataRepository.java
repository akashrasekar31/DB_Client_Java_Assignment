package com.nace.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nace.data.bean.NaceBean;
public interface NaceDataRepository extends JpaRepository<NaceBean,Long> {

}

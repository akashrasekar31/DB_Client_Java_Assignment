package com.nace.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nace.data.bean.NaceBean;
public interface NaceDataRepository extends JpaRepository<NaceBean,Long> {
	Optional<List<NaceBean>> findByLevel(int level);
	List<NaceBean> findAll();
}

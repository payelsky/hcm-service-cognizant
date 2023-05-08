package com.springboot.hcmservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hcmservice.dto.Employee;
import com.springboot.hcmservice.entity.Hcm;

public interface HcmRepository extends JpaRepository<Hcm, Integer> {

	List<Hcm> findByemployeeIdIn(List<Integer> idList);
}

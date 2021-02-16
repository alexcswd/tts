package com.samples.tts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.samples.tts.domain.Department;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

}

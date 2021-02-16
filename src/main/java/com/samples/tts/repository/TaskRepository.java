package com.samples.tts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.samples.tts.domain.Task;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
	
}

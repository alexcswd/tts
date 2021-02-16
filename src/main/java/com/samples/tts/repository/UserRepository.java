package com.samples.tts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.samples.tts.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}

package com.samples.tts.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.samples.tts.domain.Comment;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

}

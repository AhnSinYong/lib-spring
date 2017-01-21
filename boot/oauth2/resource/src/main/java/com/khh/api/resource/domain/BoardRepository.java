package com.khh.api.resource.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface BoardRepository extends PagingAndSortingRepository<Board, Long> {}


package com.darrenforsythe.jpa.unidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
	
	ParentEntity findByChildrenId(Long id);

}

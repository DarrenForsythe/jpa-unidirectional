package com.darrenforsythe.jpa.unidirectional;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.darrenforsythe.jpa.unidirectional.repository.ChildEntity;
import com.darrenforsythe.jpa.unidirectional.repository.ChildRepository;
import com.darrenforsythe.jpa.unidirectional.repository.ParentEntity;
import com.darrenforsythe.jpa.unidirectional.repository.ParentRepository;

@Component
public class PersistenceService {

	private ParentRepository parentRepository;

	private ChildRepository childRepository;

	private ParentMapper mapper;

	public PersistenceService(ParentRepository parentRepository, ChildRepository childRepository, ParentMapper mapper) {
		this.parentRepository = parentRepository;
		this.childRepository = childRepository;
		this.mapper = mapper;
	}

	@Transactional
	public ParentEntity save(Parent parent) {
		return parentRepository.save(mapper.map(parent));
	}

	@Transactional(readOnly = true)
	public ParentEntity getByChildId(long id) {
		return parentRepository.findByChildrenId(id);
	}

	@Transactional(readOnly = true)
	public List<ChildEntity> getChildrenByParentId(Long id) {
		return childRepository.findByParentId(id);
	}

}

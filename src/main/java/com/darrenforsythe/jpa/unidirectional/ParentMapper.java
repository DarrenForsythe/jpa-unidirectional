package com.darrenforsythe.jpa.unidirectional;

import java.util.List;

import org.mapstruct.Mapper;

import com.darrenforsythe.jpa.unidirectional.repository.ChildEntity;
import com.darrenforsythe.jpa.unidirectional.repository.ParentEntity;

@Mapper(componentModel = "spring")
public interface ParentMapper {

	ParentEntity map(Parent parent);

	List<ChildEntity> map(List<Child> children);

	ChildEntity map(Child child);

}

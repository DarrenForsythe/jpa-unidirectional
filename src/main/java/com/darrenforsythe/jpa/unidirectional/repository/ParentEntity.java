package com.darrenforsythe.jpa.unidirectional.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "parent")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ParentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
	private List<ChildEntity> children = new ArrayList<>();

	public void setChildren(List<ChildEntity> children) {
		this.children.addAll(children);
		children.stream().forEach(child -> child.setParent(this));
	}

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime updatedAt;

}

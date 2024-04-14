package com.donchung.server.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "persons")
public class Person implements Serializable{
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	// Nhiều người được quản lý bởi một người
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Person manager;
	
	// Thuộc tính enum
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	// Thuộc tính đa trị: chỉ có string, int, ...
	// nếu là đối tượng thì là OneToMany
	// C1: @ElementCollection
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "person_id"))
	@Column(name = "phone")
	private List<String> phones;
}

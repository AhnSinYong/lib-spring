package com.khh.api.resource.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Board {
	@Id
	@GeneratedValue
	Long id;
	String title;
	String content;
	String pwd;
}
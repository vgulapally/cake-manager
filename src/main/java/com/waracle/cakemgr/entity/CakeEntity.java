package com.waracle.cakemgr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CAKE")
public class CakeEntity implements Serializable {

	private static final long serialVersionUID = 5119962375421296889L;

	@Id
	@Column(name = "ID")
	private Long id;

	@NotBlank
	@Size(min = 1, max = 100)
	@Column(name = "TITLE")
	private String title;

	@NotBlank
	@Size(min = 1, max = 100)
	@Column(name = "DESCRIPTION")
	private String description;

	@NotBlank
	@Size(min = 1, max = 300)
	@Column(name = "IMAGE")
	private String image;

}
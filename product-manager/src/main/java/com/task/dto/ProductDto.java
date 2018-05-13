package com.task.dto;

public class ProductDto {

	private Long id;
	private Long typeId;
	private String name;
	private String photo;
	private String description;
	private Long[] relatedTypes;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long[] getRelatedTypes() {
		return relatedTypes;
	}
	public void setRelatedTypes(Long[] relatedTypes) {
		this.relatedTypes = relatedTypes;
	}
}

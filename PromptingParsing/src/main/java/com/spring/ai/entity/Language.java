package com.spring.ai.entity;

public class Language {
	private String name;
	private String description;
	private String formulatedYear;
	private String popularity;
	public Language(String name, String description, String formulatedYear, String popularity) {
		this.name = name;
		this.description = description;
		this.formulatedYear = formulatedYear;
		this.popularity = popularity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormulatedYear() {
		return formulatedYear;
	}
	public void setFormulatedYear(String formulatedYear) {
		this.formulatedYear = formulatedYear;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
}

package com.bezkoder.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "targets")
public class Target {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Lob
	private byte[] data;

	@Column(name = "name")
	private String name;

	@Column(name = "architecture")
	private String architecture;

	@Column(name = "core")
	private String core;

	@Column(name = "chip")
	private String chip;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;



	public Target() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}



	public Target(long id, String name, String architecture, String core, String chip, String description,
			boolean published) {
		this.id = id;
		this.name = name;
		this.architecture = architecture;
		this.core = core;
		this.chip = chip;
		this.description = description;
		this.published = published;
    	
	}

	@Override
	public String toString() {
		return "Target [id=" + id + ", name=" + name + ", architecture=" + architecture + ", core=" + core + ", chip="
				+ chip + ", description=" + description + ", published=" + published + "]";
	}
	
	

}

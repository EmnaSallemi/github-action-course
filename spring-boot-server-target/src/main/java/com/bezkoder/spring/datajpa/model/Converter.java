package com.bezkoder.spring.datajpa.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "converter")
public class Converter {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String type;

  private String architecture;

  @Lob
  private byte[] data;

  public Converter() {
  }

  public void setId(String id) {
    this.id = id;
}

public String getArchitecture() {
    return architecture;
}

public void setArchitecture(String architecture) {
    this.architecture = architecture;
}

public Converter(String name, String type,String architecture, byte[] data) {
    this.name = name;
    this.type = type;
    this.architecture=architecture;
    this.data = data;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}

package com.bussinesscom.Africa.GsuitAfrica.AutoComplet;

public class DataTest {
  private String value;
  private Integer data;

  public DataTest(String name,Integer data) {
    this.value = name;
    this.data = data;
  }

  public Integer getData() {
    return data;
  }

  public void setData(Integer data) {
    this.data = data;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}

package com.crs.flipkart.bean;

import java.util.Objects;

public class PairPOJO {
    private String key;
    private String value;

    public PairPOJO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public PairPOJO() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairPOJO pairPOJO = (PairPOJO) o;
        return Objects.equals(key, pairPOJO.key) && Objects.equals(value, pairPOJO.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "PairPOJO{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

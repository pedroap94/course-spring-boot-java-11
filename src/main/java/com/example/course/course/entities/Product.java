package com.example.course.course.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private String name;
    private Double price;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Product(){}

    public Product(long id, String description, String name, Double price, String imgUrl, Category category) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                Objects.equals(getImgUrl(), product.getImgUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getName(), getPrice(), getImgUrl());
    }
}

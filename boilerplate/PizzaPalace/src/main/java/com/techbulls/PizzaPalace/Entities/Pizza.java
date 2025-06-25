package com.techbulls.PizzaPalace.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Table(name = "pizza")
@Validated
public class Pizza {


    @Id
    @Column(name = "pizza_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "image_url")
    private String imageUrl;

    @NotNull(message = "price cannot be nulll")
    @Positive(message = "price cannot be negative")
    @Column(name = "price_regular_size")
    private  Integer priceRegularSize;

    @NotNull(message = "price cannot be nulll")
    @Positive(message = "price cannot be negative")
    @Column(name = "price_medium_size")
    private Integer priceMediumSize;

    @NotNull(message = "price cannot be nulll")
    @Positive(message = "price cannot be negative")
    @Column(name = "price_large_size")
    private Integer priceLargeSize;


    @OneToMany(mappedBy = "pizza",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JsonManagedReference("pizza-orderline")
    private List<OrderLine> orderLine;

    public Pizza() {
    }

    public Pizza(int id, String name, String description, String type, String imageUrl, Integer priceRegularSize, Integer priceMediumSize, Integer priceLargeSize) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.imageUrl = imageUrl;
        this.priceRegularSize = priceRegularSize;
        this.priceMediumSize = priceMediumSize;
        this.priceLargeSize = priceLargeSize;
    }

    public Pizza(int id, String name, String description, String type, String imageUrl, Integer priceRegularSize, Integer priceMediumSize, Integer priceLargeSize, List<OrderLine> orderLine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.imageUrl = imageUrl;
        this.priceRegularSize = priceRegularSize;
        this.priceMediumSize = priceMediumSize;
        this.priceLargeSize = priceLargeSize;
        this.orderLine = orderLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPriceRegularSize() {
        return priceRegularSize;
    }

    public void setPriceRegularSize(Integer priceRegularSize) {
        this.priceRegularSize = priceRegularSize;
    }

    public Integer getPriceMediumSize() {
        return priceMediumSize;
    }

    public void setPriceMediumSize(Integer priceMediumSize) {
        this.priceMediumSize = priceMediumSize;
    }

    public Integer getPriceLargeSize() {
        return priceLargeSize;
    }

    public void setPriceLargeSize(Integer priceLargeSize) {
        this.priceLargeSize = priceLargeSize;
    }

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", priceRegularSize=" + priceRegularSize +
                ", priceMediumSize=" + priceMediumSize +
                ", priceLargeSize=" + priceLargeSize +
                ", orderLine=" + orderLine +
                '}';
    }
}

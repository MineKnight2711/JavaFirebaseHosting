package com.example.javabackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import java.util.List;

@Data
@Getter
@Setter
@Entity(name="Topping")
@Table(name="Topping")
public class Topping {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ToppingID;
    @Column(name = "ToppingName",length = 50)
    private String ToppingName;
    @Column(name = "Unit",length = 30)
    private String Unit;
    @DecimalMin(value = "0.0", inclusive = true)
    private double Price;
    @Column(name = "Image",length = 1000)
    private String Image;
    @OneToMany(mappedBy = "topping")
    @JsonIgnore
    private List<OrderDetailsTopping> orderDetailsToppings;
}

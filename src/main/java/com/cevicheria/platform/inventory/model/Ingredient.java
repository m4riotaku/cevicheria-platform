package com.cevicheria.platform.inventory.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredient", uniqueConstraints = @UniqueConstraint(
    name = "uk_ingredient_business_code", columnNames = {"business_id", "code"}))
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long businessId;

    @Column(nullable = false)
    private Long categoryId;

    @Column(nullable = false, length = 30)
    private String code;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private UnitOfMeasure baseUnit;

    @Column(length = 120)
    private String storageLocation;

    @Column(length = 120)
    private String storageCondition;

    @Column(nullable = false)
    private boolean requiresBatch;

    @Column(nullable = false)
    private boolean requiresExpiration;

    @Column(nullable = false, precision = 7, scale = 4)
    private BigDecimal yieldPercentage = new BigDecimal("100.0000");

    @Column(nullable = false)
    private boolean active = true;
}
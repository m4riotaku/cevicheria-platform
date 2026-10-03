package com.cevicheria.platform.inventory.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "inventory_balance", uniqueConstraints = @UniqueConstraint(
    name = "uk_inventory_balance_ingredient_warehouse",
    columnNames = {"ingredient_id", "warehouse_id"}))
public class InventoryBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long ingredientId;

    @Column(nullable = false)
    private Long warehouseId;

    @Column(nullable = false, precision = 14, scale = 4)
    private BigDecimal quantityOnHand = BigDecimal.ZERO;

    @Column(nullable = false, precision = 14, scale = 4)
    private BigDecimal averageUnitCost = BigDecimal.ZERO;

    @Column(precision = 14, scale = 4)
    private BigDecimal minimumStock;

    private LocalDateTime updatedAt;
}
package com.example.RentCarProject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    @Column(nullable = false)
    private LocalDate invoiceDate;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private boolean isPaid;

    // Constructors, getters, setters, and other methods

    // Constructor without ID as it will be generated automatically
    public Invoice(Rental rental, LocalDate invoiceDate, BigDecimal amount, boolean isPaid) {
        this.rental = rental;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.isPaid = isPaid;
    }

}


package com.wallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message="Name is mandatory")
    private String name;
    private double balance;
    @JsonIgnore
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
    public Wallet() {
    }
    public Wallet(String wallet1, int i) {
        this.name=wallet1;
        this.balance = i;
    }

    public Wallet(Long id,String wallet1, double i) {
        this.id=id;
        this.name=wallet1;
        this.balance = i;
    }
}

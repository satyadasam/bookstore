package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javassist.SerialVersionUID;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by z00382545 on 12/28/16.
 */
@Entity
public class ShoppingCart implements Serializable {


    private static final long serialVersionUID = -6792254538997397079L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal GrandTotal;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItemList;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        GrandTotal = grandTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foodforall.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 *
 * @author mrsch
 */

@Data
@Entity
public class Allergy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allergyId;
    
    
    private String name;    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "AllergyIngredient",
            joinColumns = @JoinColumn(name = "allergyId"),
            inverseJoinColumns = @JoinColumn(name = "IngredientId")
    )
    private List<Ingredient> ingredients;
}

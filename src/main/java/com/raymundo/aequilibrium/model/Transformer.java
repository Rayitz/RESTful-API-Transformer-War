package com.raymundo.aequilibrium.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * The persistent class for the transformer database table.
 * 
 */
@Entity
@Table(name=" transformer")
@NamedQuery(name="Transformer.findAll", query="SELECT t FROM Transformer t")
public class Transformer implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
   
	@Column(name="name")
	@NotEmpty(message = "name can not be empty")
	@NotNull(message = "name is required")
	private String name;
	
	
	@Column(name="type")
	@Pattern(regexp = "^D|A$",message = "type only can be a letter 'D' for Decepticon or 'A' for Autobot")
	@NotNull(message = "type is required")
	private String type;
	
	
	@Column(name="strength")
	@NotNull(message = "strength is required")
	@Min(1)
	@Max(10)
	private int strength;
	
	
	@Column(name="intelligence")
	@NotNull(message = "intelligence is required")
	@Min(1)
	@Max(10)
	private int intelligence;
	
	
	@Column(name="speed")
	@NotNull(message = "speed is required")
	@Min(1)
	@Max(10)
	private int speed;
	
	
	@Column(name="endurance")
	@NotNull(message = "endurance is required")
	@Min(1)
	@Max(10)
	private int endurance;
	
	
	@Column(name="rank")
	@NotNull(message = "rank is required")
	@Min(1)
	@Max(10)
	private int rank;
	
	
	@Column(name="courage")
	@NotNull(message = "courage is required")
	@Min(1)
	@Max(10)
	private int courage;
	
	
	@Column(name="firepower")
	@NotNull(message = "firepower is required")
	@Min(1)
	@Max(10)
	private int firepower;
	
	
	@Column(name="skill")
	@NotNull(message = "skill is required")
	@Min(1)
	@Max(10)
	private int skill;


	public Transformer() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getEndurance() {
		return endurance;
	}


	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getCourage() {
		return courage;
	}


	public void setCourage(int courage) {
		this.courage = courage;
	}


	public int getFirepower() {
		return firepower;
	}


	public void setFirepower(int firepower) {
		this.firepower = firepower;
	}


	public int getSkill() {
		return skill;
	}


	public void setSkill(int skill) {
		this.skill = skill;
	}

	
	

}
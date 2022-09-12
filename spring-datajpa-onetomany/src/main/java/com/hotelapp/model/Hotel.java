package com.hotelapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@NamedQuery(name = "readByCat",query = "from Hotel h inner join h.itemList  i where i.category=?1")

public class Hotel {

	@Id
	@GeneratedValue(generator = "hotel_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hotel_gen",sequenceName = "hotel_sequence",initialValue = 100,allocationSize = 1)
	@Column(name="hotelid")
	private Integer hotelId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	@Enumerated(value = EnumType.STRING)
	private Type  type;//veg or non-veg
	@Column(length = 20)
	private String city;
	private double ratings;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_id")
	private Set<Item> itemList;
	public Hotel() {
		super();
	}
	
	public Hotel(String name, Type type, String city, double ratings, Set<Item> itemList) {
		super();
		this.name = name;
		this.type = type;
		this.city = city;
		this.ratings = ratings;
		this.itemList = itemList;
	}

	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	public Set<Item> getItemList() {
		return itemList;
	}
	public void setItemList(Set<Item> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", city=" + city + ", ratings=" + ratings + "]";
	}
	
	
	
}

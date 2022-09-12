package com.hotelapp.service;

import java.util.List;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;

public interface IHotelService {

	Hotel addHotel(Hotel hotel);

	void updateHotel(Hotel hotel);

	void deleteHotel(int hotelId);

	Hotel getById(int hotelId);

	List<Hotel> getAll();

	List<Hotel> getByCity(String city);

	List<Hotel> getByType(Type type);

	List<Hotel> getByRating(double ratings);

	List<Hotel> getByItemName(String itemName);

	List<Hotel> getByItemNameCategory(String itemName, Category category);

	List<Hotel> getByCuisine(String cuisine);

	List<Hotel> getByCategory(Category category);

	List<Hotel> getByCuisineAndType(String cuisine, Type type);

	List<Hotel> getByItemNameLessprice(String itemName, double price);
}

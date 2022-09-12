package com.hotelapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;
import com.hotelapp.repository.IHotelRepository;



@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	IHotelRepository hotelRepository;

	@Override
	public Hotel addHotel(Hotel hotel) {

		return hotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {

		hotelRepository.save(hotel);
	}

	@Override
	public void deleteHotel(int hotelId) {

		hotelRepository.deleteById(hotelId);
	}

	@Override
	public Hotel getById(int hotelId) {
		Optional<Hotel> hotelNumber = hotelRepository.findById(hotelId);
		if (hotelNumber.isPresent())
			return hotelNumber.get();
		return null;

	}

	@Override
	public List<Hotel> getAll() {
		Sort sort=Sort.by("name");
		
		return hotelRepository.findAll(sort);
	}

	@Override
	public List<Hotel> getByCity(String city) {
		return hotelRepository.findByCity(city);
	}

	@Override
	public List<Hotel> getByType(Type type) {
		return hotelRepository.findByType(type,Sort.by("name"));
	}

	@Override
	public List<Hotel> getByRating(double ratings) {
		return hotelRepository.findByRatings(ratings);
	}

	@Override
	public List<Hotel> getByItemName(String itemName) {
		return hotelRepository.findByItemName(itemName);
	}

	@Override
	public List<Hotel> getByItemNameCategory(String itemName, Category category) {
		return hotelRepository.findByItemNameCategory(itemName, category);
	}

	@Override
	public List<Hotel> getByCuisine(String cuisine) {
		return hotelRepository.findByCuisine(cuisine);
	}

	@Override
	public List<Hotel> getByCategory(Category category) {
		return hotelRepository.findByCategory(category);
	}

	@Override
	public List<Hotel> getByCuisineAndType(String cuisine, Type type) {
		return hotelRepository.findByCuisineAndType(cuisine, type);
	}

	@Override
	public List<Hotel> getByItemNameLessprice(String itemName, double price) {
		return hotelRepository.findByItemNameLessprice(itemName, price);
	}

}

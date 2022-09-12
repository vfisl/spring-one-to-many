package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Category;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Type;



@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {

	List<Hotel> findByCity(String city);

	List<Hotel> findByType(Type type,Sort sort);

	@Query(" from Hotel where ratings >?1 ")
	List<Hotel> findByRatings(double ratings);

	@Query("from Hotel h inner join h.itemList  i where i.itemName=?1")
	List<Hotel> findByItemName(String itemName);

	@Query("from Hotel h inner join h.itemList  i where i.itemName=?1 or i.category=?2")
	List<Hotel> findByItemNameCategory(String itemName, Category category);

	@Query(value = "select * from hotel h inner join item i on i.hotel_id=h.hotelid where i.cuisine=?1",nativeQuery = true)
//	@Query("from Hotel h inner join h.itemList  i where i.cuisine=?1")
	List<Hotel> findByCuisine(String cuisine);

	@Query(name="readByCat")
	List<Hotel> findByCategory(Category category);

	@Query("from Hotel h inner join h.itemList  i where i.cuisine=?1 or i.itemType=?2")
	List<Hotel> findByCuisineAndType(String cuisine, Type type);

	@Query("from Hotel h inner join h.itemList  i where i.itemName=?1 or i.price<?2")
	List<Hotel> findByItemNameLessprice(String itemName, double price);
}

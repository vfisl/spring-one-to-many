package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.model.Hotel;
import com.hotelapp.model.Item;

import com.hotelapp.model.Category;
import com.hotelapp.model.Type;
import com.hotelapp.service.IHotelService;

@SpringBootApplication
public class SpringDatajpaOnetomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaOnetomanyApplication.class, args);
	}

	@Autowired
	IHotelService hotelService;

	@Override
	public void run(String... args) throws Exception {

		Item item1 = new Item("Dosa", Category.FASTFOOD, "Chinese", Type.VEG, 100);
		Item item2 = new Item("Idly", Category.FASTFOOD, "Chinese", Type.VEG, 120);
		Item item3 = new Item("IceCreams", Category.BEVERAGES, "Juices", Type.VEG, 200);

		Set<Item> items = new HashSet<>(Arrays.asList(item1, item2, item3));

		Hotel hotel = new Hotel("Udupi", Type.VEG, "Bangalore", 8, items);

		hotelService.addHotel(hotel);

		Item item4 = new Item("Dosa", Category.BREAKFAST, "SI", Type.VEG, 100);
		Item item5 = new Item("Idly", Category.BREAKFAST, "SI", Type.VEG, 120);
		Item item6 = new Item("Chicken Biryani", Category.MAINCOURSE, "Andra", Type.NONVEG, 200);
		Set<Item> itemList = new HashSet<Item>(Arrays.asList(item4, item5, item6));
		Hotel hotel1 = new Hotel("Dragon King", Type.VEG, "Bangalore", 6, itemList);

		hotelService.addHotel(hotel1);

		System.out.println("Get All");
		hotelService.getAll().forEach(System.out::println);
		System.out.println();

		System.out.println("Get By HotelId");
		System.out.println(hotelService.getById(100));
		System.out.println();

		System.out.println("Get get By Category");
		hotelService.getByCategory(Category.BREAKFAST).forEach(System.out::println);
		System.out.println();

		System.out.println("Get get By Type");
		hotelService.getByType(Type.VEG).forEach(System.out::println);
		System.out.println();

		System.out.println("Get get By City");
		hotelService.getByCity("Bangalore").forEach(System.out::println);
		System.out.println();

		System.out.println("Get get By Cuisine");
		hotelService.getByCuisine("SI").forEach(System.out::println);
		System.out.println();

		System.out.println("Get By Cuisine And Type");
		hotelService.getByCuisineAndType("SI", Type.VEG).forEach(System.out::println);
		System.out.println();

		System.out.println("Get By ItemName");
		hotelService.getByItemName("Fried Rice").forEach(System.out::println);
		System.out.println();

		System.out.println("Get By ItemName Category");
		hotelService.getByItemNameCategory("Dosa", Category.BREAKFAST).forEach(System.out::println);
		System.out.println();

		System.out.println("Get By ItemName Lessprice");
		hotelService.getByItemNameLessprice("Idli", 200).forEach(System.out::println);
		System.out.println();

		System.out.println("Get By Rating");
		hotelService.getByRating(5).forEach(System.out::println);
		System.out.println();
	}

}

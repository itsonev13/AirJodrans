package com.jordans.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jordans.models.Shoe;

public interface ShoeService {
	List<Shoe> getShoes();

	List<Shoe> getTwoShoes(Pageable page);

	void createShoe(Shoe shoe);

	int getNumberOfShoePages();

	List<Shoe> getShoeBySearchString(String searchString);
}

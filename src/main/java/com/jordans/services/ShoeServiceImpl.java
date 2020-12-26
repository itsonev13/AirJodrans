package com.jordans.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jordans.models.Shoe;
import com.jordans.repositories.ShoeRepository;

@Service
public class ShoeServiceImpl implements ShoeService {
	private ShoeRepository shoeRepository;

	@Autowired
	ShoeServiceImpl(ShoeRepository shoeRepository) {
		this.shoeRepository = shoeRepository;
	}

	@Override
	public List<Shoe> getShoes() {

		return this.shoeRepository.findAll();
	}

	@Override
	public List<Shoe> getTwoShoes(Pageable page) {
		Page<Shoe> pageOfShoes = this.shoeRepository.findAll(page);
		List<Shoe> listOfShoes = pageOfShoes.toList();
		return listOfShoes;
	}

	@Override
	public void createShoe(Shoe shoe) {
		this.shoeRepository.saveAndFlush(shoe);
		return;
	}

	@Override
	public int getNumberOfShoePages() {
		List<Shoe> shoesList = this.shoeRepository.findAll();
		return shoesList.size() / 2;
	}

	@Override
	public List<Shoe> getShoeBySearchString(String searchString) {
		if (searchString.trim() == "") {
			return null;
		}
		return this.shoeRepository.findByModelContaining(searchString);
	}

}

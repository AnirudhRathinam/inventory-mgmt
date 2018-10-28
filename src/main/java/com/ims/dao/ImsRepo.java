package com.ims.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ims.models.Item;


@Repository
public interface ImsRepo extends CrudRepository<Item, Long> {
	

}

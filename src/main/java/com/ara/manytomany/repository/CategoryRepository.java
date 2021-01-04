package com.ara.manytomany.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ara.manytomany.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository <Category,Long>{
	List<Category>findAll();

}

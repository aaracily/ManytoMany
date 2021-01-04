package com.ara.manytomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ara.manytomany.model.Category;
import com.ara.manytomany.model.Product;
import com.ara.manytomany.repository.CategoryRepository;
import com.ara.manytomany.repository.ProductRepository;

@Service
public class CategoryService {
	private final CategoryRepository catRep;
	private final ProductRepository prodRep;
	
	public CategoryService(CategoryRepository catRep, ProductRepository prodRep) {
		this.catRep = catRep;
		this.prodRep = prodRep;
	}
		//crear categoria
		public Category crearCategoria(Category cat) {
			return catRep.save(cat);
		}
		
		//listar categorias
		public List<Category> listarCategorias(){
			return catRep.findAll();
		}
		
		//encontrar categoria por su id
		public Category encontrarPorId(Long id) {
			Optional<Category>optionalCategory = catRep.findById(id);
			if(optionalCategory.isPresent()) {
				return optionalCategory.get();
			}else {
				return null;
			}
		}
		
		
		//almacenar categoria, necesitas el id de producto para guardarla
		public Product agregarCat(Long id,Category categoria) {
			Optional<Product> producto = prodRep.findById(id);
			if(producto.isPresent()) {
				producto.get().getCategories().add(categoria);
				
				return prodRep.save(producto.get());
			}else {
				return null;
			}
		}
}

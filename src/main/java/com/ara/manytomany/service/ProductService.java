package com.ara.manytomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ara.manytomany.model.Category;
import com.ara.manytomany.model.Product;
import com.ara.manytomany.repository.CategoryRepository;
import com.ara.manytomany.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository prodRep;
	private final CategoryRepository catRep;
	public ProductService(ProductRepository prodRep, CategoryRepository catRep) {
		this.prodRep = prodRep;
		this.catRep = catRep;
	}
	
	//crear producto
	public Product crearProducto(Product pro) {
		return prodRep.save(pro);
	}
	
	//listar los productos
	public List<Product> listarProductos(){
		return prodRep.findAll();
	}
	
	//encontrar un producto por su id
	public Product encontrarPorId(Long id) {
		Optional<Product>optionalProduct = prodRep.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
 /*//almacenar categoria, necesitas el id de producto para guardarla
		public Product agregarCat(Long id,Category categoria) {
			Optional<Product> producto = prodRep.findById(id);
			if(producto.isPresent()) {
				producto.get().getCategories().add(categoria);
				
				return prodRep.save(producto.get());
			}else {
				return null;
			}
		}*/
	
	//para guardar el producto necesitas el id de la categoria
	public Category agregarProd(Long id, Product prod) {
		Optional<Category> categoria = catRep.findById(id);
		if(categoria.isPresent()) {
			categoria.get().getProducts().add(prod);
			return catRep.save(categoria.get());
		}else {
			return null;
		}
		
	}
}

package com.ara.manytomany.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ara.manytomany.model.Category;
import com.ara.manytomany.model.Product;
import com.ara.manytomany.service.CategoryService;
import com.ara.manytomany.service.ProductService;

@Controller
public class ProductController {
	private final ProductService prodS;
	private final CategoryService catS;
	
	public ProductController(ProductService prodS, CategoryService catS) {
		this.prodS= prodS;
		this.catS = catS;
	}
	//mostrar formulario vacio para crear un producto
	@RequestMapping("/products/new")
	public String nuevoProd(@ModelAttribute("producto")Product product) {
		return "newProduct.jsp";
	}
	//recibir y almacenar información enviada dese el formulario
	@RequestMapping(value="/products/new",method=RequestMethod.POST)
	public String guardarProducto(@Valid @ModelAttribute("producto")Product product,BindingResult result) {
		prodS.crearProducto(product);
		return"redirect:/products/new";
	}
	@RequestMapping("/categories/new")
	public String nuevacateg(@ModelAttribute("categoria") Category category) {
		return "newCategory.jsp";
	}
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String crearCategoria(@Valid @ModelAttribute("categoria")Category category) {
		catS.crearCategoria(category);
		return "redirect:/categories/new";
	}
	//encontrar producto por id y enviarlo a la vista, mostrar categoria y agregar una categoria 
	@RequestMapping("/products/{id}")
	public String mostrarAgregarCat( @ModelAttribute("categoriaV")Category categ,@PathVariable("id") Long id, Model model) {
		Product productoid= prodS.encontrarPorId(id);
		model.addAttribute("producto",productoid);
		model.addAttribute("categorias", catS.listarCategorias());
		
		return "agregarCat.jsp";
	}
	//recibe y almacena la categoria seleccionada
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	public String guardarCat(@ModelAttribute("categoriaV")Category categ, @PathVariable("id")Long id) {
		
		catS.agregarCat(id, categ);
		return "redirect:/products/"+id;
	}
	//encontrar un categoria por id, enviarla a la vista, mostrar los productos asociados y agregas nuevo producto
	
	@RequestMapping("/categories/{id}")
	public String mostrarAgregarPro(@ModelAttribute("prodValido")Product prod,@PathVariable("id")Long id,Model modelo) {
		Category categ = catS.encontrarPorId(id);
		modelo.addAttribute("categoriaID", categ);
		
		List<Product> productos = prodS.listarProductos();
		modelo.addAttribute("productos", productos);
		return "agregarProd.jsp";
	}
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public String agregarproducto(@ModelAttribute("prodValido")Product prod,@PathVariable Long id) {
		prodS.agregarProd(id, prod);
		 
		return "redirect:/categories/";
	
	}
}

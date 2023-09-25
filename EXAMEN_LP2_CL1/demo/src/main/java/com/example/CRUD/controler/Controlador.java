package com.example.CRUD.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.CRUD.interfaceService.IEmpleadoService;
import com.example.CRUD.model.Empleado;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IEmpleadoService service;
	
	@GetMapping("/error")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Empleado>empleados= service.listar();
		model.addAttribute("empleados",empleados);
		return "index";
	}
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("empleado",new Empleado());
		return "form";
	}
	@PostMapping("/save")
	public String save(@Valid Empleado p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	@GetMapping("/editar/{id}")
	public String editar( @PathVariable int id, Model model) {
		Optional<Empleado>empleado=service.listarId(id);
		model.addAttribute("empleado",empleado);
		return "form";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);	
		return "redirect:/listar";
	}
	
	
}

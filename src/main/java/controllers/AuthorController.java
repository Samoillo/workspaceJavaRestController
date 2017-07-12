package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Author;

@RestController
@RequestMapping("/books")
public class AuthorController {

	@RequestMapping("/author")
	public Author helloAuthor(){	
	return	new	Author("Andrzej", "Samoillo", 11);
	}																			
	
}

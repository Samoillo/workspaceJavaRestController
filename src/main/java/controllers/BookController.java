package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.MockBookService;
import models.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private MockBookService bookService;
	
	@GetMapping("/helloBook")
	public String getList() {
		return "{lista ksiazek}";

	}
	
	@RequestMapping("/all")
	public List<Book> getListOfBooks(){
		List<Book> List = this.bookService.getList();
		return List;
	}																			
	
	@RequestMapping("/{id}")
	public Book getOneBook(@PathVariable Long id){
		return this.bookService.getById(id);
	}
	
	@PostMapping("/")
	public void putBook(HttpServletRequest request){
		
		try {
			String bookJson = request.getReader().readLine();
			Book book = new ObjectMapper().readValue(bookJson, Book.class);
			this.bookService.add(book);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		this.bookService.deleteById(id);

	}

	
	
}

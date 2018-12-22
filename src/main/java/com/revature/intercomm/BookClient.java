package com.revature.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.caliber.beans.Book;


@FeignClient("book-service")
public interface BookClient {

	@GetMapping("/books")
	public List<Book> getAllBooks();
}

package com.revature.caliber.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.service.NoteService;
import com.revature.intercomm.BookClient;
import com.revature.caliber.beans.Book;
import com.revature.caliber.beans.Note;

/**
 * Controllers for handling all requests having to do with notes.
 * @author thienle
 *
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/note")
public class NoteController {

	private static final Logger log = Logger.getLogger(NoteController.class);
	
	@Autowired
	private NoteService service;
	
	@Autowired
	private BookClient client;
	
	@GetMapping("/home")
	public String welcome() {
		return "welcome home";
	}
	
	@GetMapping("/audit-books")
	public List<Book> getAllBooks() {
		return client.getAllBooks();
	}
	
	/**
	 * Handles get request for returning all notes
	 * @return
	 */
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		
		log.trace("in notes: Looking for note");
		return service.getAllNotes();
	}
	
	/**
	 * 
	 * @param id
	 * @return a note based on noteId
	 */
	@GetMapping(value="/note/{id}") 
	public Note getNote(@PathVariable Integer id) {
		log.trace("IN FIND ONE NOTE");
		return service.findById(id);
	}
	
	
	/**
	 * Handles post request for creating a note
	 * @param note 
	 * @return The created note as well as an OK status code
	 */
	@PostMapping(path="/note",
			     consumes = MediaType.APPLICATION_JSON_VALUE,
			     produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Note> createNote(@RequestBody Note note) {
		
		log.debug("SAVING NOTE: " + note);
		note = service.createNote(note);
		
		if(note == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(note, HttpStatus.CREATED);
		}
		
	}
	
	
	/**
	 * 
	 * @param note
	 * @return
	 */
	@PutMapping(path="/note")
	public ResponseEntity<Note> updateNote(@RequestBody Note note) {
		log.debug("Updating note: " + note);
		note = service.updateNote(note);
		

		if(note == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(note, HttpStatus.CREATED);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="/note/{id}") 
	public boolean deleteNote(@PathVariable Integer id) {
		service.deleteNote(id);
		return true;
	}
	
	
}

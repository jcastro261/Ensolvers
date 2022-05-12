package com.ApiEnsolvers.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiEnsolvers.app.Entity.Note;
import com.ApiEnsolvers.app.dto.NoteDto;
import com.ApiEnsolvers.app.service.NoteService;
import com.ApiEnsolvers.app.util.Util;

@RestController
@RequestMapping("/api/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping
	@RequestMapping("/add")
	public ResponseEntity<?> create (@RequestBody NoteDto noteDto){
		
		if(Util.checkParameters(noteDto.getTitle(), noteDto.getText(), new Date())) {
			Note Note = new Note (noteDto.getTitle(), noteDto.getText(),new Date(),true);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(noteService.save(Note));
		} else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong parameters");
		
	}
	
	@GetMapping("consult/{idNote}")
	public ResponseEntity<?> read (@PathVariable Long idNote){
		Optional<Note> oNote = noteService.findById(idNote);
		
		if(!oNote.isPresent()) {
			return ResponseEntity.badRequest().build();
		}else 
			return ResponseEntity.ok(oNote);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Note>> getAll() {
		
		
		return new ResponseEntity<List<Note>>(noteService.finByStatus(true), HttpStatus.OK);

	}
	
	@GetMapping("/findArchived")
	public ResponseEntity<List<Note>> getNames() {
				
		return new ResponseEntity<List<Note>>(noteService.finByStatus(false), HttpStatus.OK);

	}
	
	@PutMapping
	@RequestMapping("/update")
	public ResponseEntity<?> update (@RequestBody Note noteDetail){
		
		if(Util.checkNote(noteDetail)) {
			
			Optional<Note> note = noteService.findById(noteDetail.getIdNote());
			
			if (!note.isPresent())
				return ResponseEntity.notFound().build();
			
			note.get().setTitle(noteDetail.getTitle());
			note.get().setText(noteDetail.getText());
			note.get().setUpdateDate(new Date());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(noteService.save(note.get()));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong parameters");
	}
	
	@PutMapping
	@RequestMapping("/archive")
	public ResponseEntity<?> archive(@PathVariable Long idNote){
	
	if (Util.checkId(idNote)) {
		
		Optional<Note> note = noteService.findById(idNote);
		
		if(!note.isPresent()) 
			note.get().setStatus(false);
			
			return ResponseEntity.status(HttpStatus.OK).body(noteService.save(note.get()));
		}else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong parameters");
	}
	
	@PutMapping
	@RequestMapping("/unarchive")
	public ResponseEntity<?> unarchive(@PathVariable Long idNote){
	
	if (Util.checkId(idNote)) {
		
		Optional<Note> note = noteService.findById(idNote);
		
		if(!note.isPresent()) 
			note.get().setStatus(true);
			
			return ResponseEntity.status(HttpStatus.OK).body(noteService.save(note.get()));
		}else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong parameters");
	}
	
	@DeleteMapping("/delete/{idNote}")
	public ResponseEntity delete (@PathVariable Long idNote) {
		
		if(Util.checkId(idNote)) {
			
			Optional<Note> note = noteService.findById(idNote);
			
			if(!note.isPresent())
				
				return ResponseEntity.notFound().build();
			
			noteService.deletById(idNote);
			return ResponseEntity.notFound().build();
		}else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong parameters");
	}
	

}

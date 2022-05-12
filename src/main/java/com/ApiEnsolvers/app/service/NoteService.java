package com.ApiEnsolvers.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ApiEnsolvers.app.Entity.Note;

public interface NoteService {

	public Iterable<Note> finAll();

	public Page<Note> finAll(Pageable pageable);

	public Optional<Note> findById(Long idNote);
	
	public List<Note> finByStatus(boolean status);

	public Note save(Note note);

	public void deletById(Long idNote);

}

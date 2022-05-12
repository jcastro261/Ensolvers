package com.ApiEnsolvers.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApiEnsolvers.app.Entity.Note;
import com.ApiEnsolvers.app.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository notaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Note> finAll() {
		
		return notaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Note> finAll(Pageable pageable) {
		
		return notaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Note> findById(Long idNote) {
		
		return notaRepository.findById(idNote);
	}
	
	@Override
	public List<Note> finByStatus(boolean status) {
		
		return notaRepository.findByStatus(status);
	}

	@Override
	@Transactional
	public Note save(Note note) {
		
		return notaRepository.save(note);
	}

	@Override
	public void deletById(Long idNote) {
		notaRepository.deleteById(idNote);
		
	}


}

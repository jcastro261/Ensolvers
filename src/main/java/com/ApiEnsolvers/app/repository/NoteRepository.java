package com.ApiEnsolvers.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ApiEnsolvers.app.Entity.Note;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
	
	
	List<Note> findByStatus(boolean status);

}

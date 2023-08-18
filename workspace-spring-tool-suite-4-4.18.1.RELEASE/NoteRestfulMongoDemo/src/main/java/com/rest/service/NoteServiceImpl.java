package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.NoteAlreadyExistsException;
import com.rest.exception.NoteNotFoundException;
import com.rest.model.Note;
import com.rest.repository.INoteRepository;
@Service
public class NoteServiceImpl implements INoteService{
	@Autowired
	private INoteRepository noterepository;
	@Override
	public Note saveNote(Note nobj) throws NoteAlreadyExistsException{
		Optional<Note> optional=this.noterepository.findById(nobj.getId());
		System.out.println(optional.get());
		Note addNote=null;
		if(optional.isPresent()) {
			System.out.println("Note is present");
			throw new NoteAlreadyExistsException();
			
		}else {
			System.out.println("another msg1");
			addNote=this.noterepository.save(nobj);
			System.out.println("another msg2");
		}
		return addNote;
	}

	@Override
	public Note updateNote(Note nobj, int nid) throws NoteNotFoundException {
		Optional<Note> optional=this.noterepository.findById(nid);
		Note getObj=null;
		Note updateData=null;
		if(optional.isPresent()) {
			System.out.println("Record exist");
			getObj=optional.get();
			getObj.setTitle(nobj.getTitle());
			getObj.setText(nobj.getText());
			updateData=this.noterepository.save(getObj);
		}else {
			System.out.println("Note not found");
			
		}
		return updateData;
	}

	@Override
	public Note getNoteById(int nid) throws NoteNotFoundException {
		Optional<Note> optional=this.noterepository.findById(nid);
		Note nobj=null;
		if(optional.isPresent()) {
			System.out.println("Record is present");
			nobj=optional.get();
		}else {
			System.out.println("Note not found");
			throw new NoteNotFoundException();
		}
		return null;
	}

	@Override
	public List<Note> getAllNotes() {
		return this.noterepository.findAll();
	}

	@Override
	public boolean delNoteById(int nid) throws NoteNotFoundException {
		Optional<Note> optional=this.noterepository.findById(nid);
		boolean status=false;
		if(optional.isPresent()) {
			System.out.println("Note already exists");
			this.noterepository.delete(optional.get());
			status=true;
		}else {
			System.out.println("note not found");
			throw new NoteNotFoundException();
		}
		return status;
	}

}

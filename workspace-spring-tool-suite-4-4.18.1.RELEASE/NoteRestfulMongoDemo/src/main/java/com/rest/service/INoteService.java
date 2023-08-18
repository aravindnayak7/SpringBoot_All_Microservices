package com.rest.service;

import java.util.List;

import com.rest.exception.NoteAlreadyExistsException;
import com.rest.exception.NoteNotFoundException;
import com.rest.model.Note;

public interface INoteService {
public Note saveNote(Note nobj) throws NoteAlreadyExistsException;
public Note updateNote(Note nobj,int nid) throws NoteNotFoundException;
public Note getNoteById(int nid) throws NoteNotFoundException;
public List<Note> getAllNotes();
public boolean delNoteById(int nid) throws NoteNotFoundException;
}

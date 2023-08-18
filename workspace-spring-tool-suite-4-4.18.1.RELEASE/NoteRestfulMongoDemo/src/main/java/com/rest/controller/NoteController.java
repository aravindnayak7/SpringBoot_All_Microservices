package com.rest.controller;

import java.util.List;

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

import com.rest.exception.NoteAlreadyExistsException;
import com.rest.exception.NoteNotFoundException;
import com.rest.model.Note;
import com.rest.service.INoteService;
//http://localhost:8084/api/v1/addnotesu
//http://localhost:8084/api/v1/getAllemps
//http://localhost:8084/api/v1/deleteemp
//http://localhost:8084/api/v1/updateemp
//http://localhost:8084/api/v1/getempbyid
@RestController
@RequestMapping("/api/v1")
public class NoteController {
	@Autowired
private INoteService noteService;
private ResponseEntity<?> responseEntity;
@PostMapping("/addnotesu")
public ResponseEntity<?> saveNoteHandler(@RequestBody Note nobj){
	Note newNote=null;
	System.out.println("hello");
	try {
		newNote=this.noteService.saveNote(nobj);
		System.out.println("hello");
	}catch(NoteAlreadyExistsException e) {
		e.printStackTrace();
	}
	responseEntity=new ResponseEntity<>(newNote,HttpStatus.CREATED);
	return responseEntity;
}

@PutMapping("/updatedata/{nid}")
public ResponseEntity<?> updateHandler(@RequestBody Note nobj,@PathVariable int nid)throws NoteNotFoundException{
	Note updateData=null;
	updateData=this.noteService.updateNote(nobj, nid);
	responseEntity=new ResponseEntity<>(updateData,HttpStatus.OK);
	return responseEntity;
}
@GetMapping("/getnotebyid/{nid}")
public ResponseEntity<?> getnoteByIdHandler(@PathVariable int nid)throws NoteNotFoundException{
	Note getnotById=null;
	getnotById=this.noteService.getNoteById(nid);
	responseEntity=new ResponseEntity<>(getnotById,HttpStatus.OK);
	return responseEntity;
}
@GetMapping("/getAllnotes")
public ResponseEntity<?> getAllnotesHandler(){
	List<Note> allNote=this.noteService.getAllNotes();
	responseEntity=new ResponseEntity<>(allNote,HttpStatus.OK);
	return responseEntity;
}
 @DeleteMapping("/deleteNotes/{nid}")
public ResponseEntity<?> deleteNotesHandler(@PathVariable int nid)throws NoteNotFoundException{
	boolean status=this.noteService.delNoteById(nid);
	responseEntity=new ResponseEntity<>("Notes deleted",HttpStatus.OK);
	return responseEntity;
}
}

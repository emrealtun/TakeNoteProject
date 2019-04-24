package com.emre.takenotproject1;

import java.util.ArrayList;
import java.util.Locale;

import com.emre.entity.Note;
import com.emre.service.MailService;
import com.emre.service.NoteService;
import com.mchange.net.MailSender;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    public static String url ="http://localhost:8083/takenotproject1_war_exploded/";

	@Autowired
	private NoteService noteService;

    @Autowired
    private MailService mailService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		model.addAttribute("baslik","TakeNote");

		model.addAttribute("notlar", noteService.getAll(1l));
		return "index";
	}

	@RequestMapping(value = "/detay/{id}", method = RequestMethod.GET)
	public String detay(@PathVariable("id") Long id , Model model)  {

		model.addAttribute("id",id);
       // mailService.registerMail("altunemre6@gmail.com","123");

		return "detail";
	}


	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Locale locale, Model model) {
		
		return "error_404";
	}

	@RequestMapping(value = "/addNote", method = RequestMethod.GET)
	public String addNote(Locale locale, Model model) {

		return "addNote";
	}


	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
	public ResponseEntity<String> addNote(@RequestBody Note note, HttpServletRequest request){

		noteService.createNote(note,request);
		return new ResponseEntity<>("ok", HttpStatus.CREATED);

	}

	@RequestMapping(value = "/updateNote", method = RequestMethod.POST)
	public ResponseEntity<String> updateNote(@RequestBody Note note, HttpServletRequest request){

		Note oldNote = noteService.getFindById(note.getId());
		oldNote.setTitle(note.getTitle());
		oldNote.setContent(note.getContent());

		noteService.updateNote(oldNote,request);
		return new ResponseEntity<>("ok", HttpStatus.CREATED);

	}

    @RequestMapping(value = "/deleteNote", method = RequestMethod.POST)
    public ResponseEntity<String> deleteNote(@RequestBody Note note, HttpServletRequest request){

        Note oldNote = noteService.getFindById(note.getId());
        noteService.deleteNote(oldNote,request);
        return new ResponseEntity<>("ok", HttpStatus.CREATED);

    }


	@RequestMapping(value = "/getNotes", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Note>> getNotes(HttpServletRequest request){

		return new ResponseEntity<ArrayList<Note>>(noteService.getAll(1l),HttpStatus.OK);

	}



	@RequestMapping(value = "/getNote", method = RequestMethod.POST)
	public ResponseEntity<Note>getNote(@RequestBody String id, HttpServletRequest request){

		return new ResponseEntity<Note>(noteService.getFindById(Long.parseLong(id)),HttpStatus.CREATED);

	}

}







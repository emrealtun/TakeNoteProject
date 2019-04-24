package com.emre.service;

import com.emre.dao.NoteDAO;
import com.emre.entity.Note;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class NoteService {

    @Autowired
    private NoteDAO noteDAO;

    public Long createNote(Note note, HttpServletRequest request)
    {
        //TODO: user id değişecek.
        note.setUser_id(1l);
        return noteDAO.insert(note);
    }
    public Long updateNote(Note note, HttpServletRequest request)
    {
         noteDAO.update(note);
         return 1l;
    }
    public Long deleteNote(Note note, HttpServletRequest request)
    {
        noteDAO.delete(note);
        return 1l;
    }


    public ArrayList<Note> getAll()
    {
        return noteDAO.getAll();
    }


    public ArrayList<Note> getAll(Long user_id)
    {
        return  noteDAO.getAll(user_id);
    }


    public  Note getFindById(Long id)
    {
        return noteDAO.getFindById(id);
    }
}

package com.emre.dao;

import com.emre.entity.Note;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class NoteDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Long insert(Note note)
    {
     return (Long) sessionFactory.getCurrentSession().save(note);
    }

    public void  update(Note note)
    {
        sessionFactory.getCurrentSession().update(note);
    }

    public  void  delete(Note note)
    {
        sessionFactory.getCurrentSession().delete(note);
    }


    public ArrayList<Note> getAll()
    {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Note");
        return (ArrayList<Note>) query.getResultList();
    }


    public ArrayList<Note> getAll(Long user_id)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE user_id=:user_id")
                .setLong("user_id",user_id);
        return (ArrayList<Note>) query.getResultList();
    }

     public  Note getFindById(Long id)
    {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE id=:id")
                .setLong("id",id);
        return (Note) query.getSingleResult();
    }
}

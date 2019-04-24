package com.emre.endpoint;


import com.emre.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class NoteEndPoint {


    @Autowired
    private NoteService noteService;


}

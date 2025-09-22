package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import com.example.demo.entity.User;
import com.example.demo.service.JournalEntryService;
import com.example.demo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal2")
@Tag(name = "Journal APIs")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String helath(){
        return "ok";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/name")
    @Operation(summary="Get All Entry Of User")
    public ResponseEntity<?> getAllEntriesOfUser(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry> all=user.getJournalEntries();
        if (all !=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //update this method


    @Operation(summary="Create a Entry")
    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myentry){
        try {
            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            String userName=authentication.getName();
            journalEntryService.saveEntry(myentry,userName);
            return new ResponseEntity<>(myentry ,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }





    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("id/{id}")
    @Operation(summary="Get All Entry By Id")
    public ResponseEntity<JournalEntry> getJournalEnteryById(@PathVariable ObjectId id){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry> collect=user.getJournalEntries().stream().filter(x->x.getId().equals(id)).collect(Collectors.toList());
        if (!collect.isEmpty()){
            Optional<JournalEntry> all=journalEntryService.getEntryById(id);
            if(all.isPresent()){
                return new ResponseEntity<>(all.get(),HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //debuge this method



    //debuge this method also debug
    @PutMapping("/id/{id}")
    @Operation(summary="Update Journal By Id")
    public ResponseEntity<JournalEntry> upadateJournalById(@PathVariable ObjectId id,
                                                           @RequestBody JournalEntry newentry)
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry> collect=user.getJournalEntries().stream().filter(x->x.getId().equals(id)).collect(Collectors.toList());
        if (!collect.isEmpty()){
            Optional<JournalEntry> journalEntry=journalEntryService.getEntryById(id);
            if(journalEntry.isPresent()){
                JournalEntry old=journalEntry.get();
                old.setTitle(newentry.getTitle() != null && !newentry.getTitle().isEmpty() ? newentry.getTitle(): old.getTitle());
                old.setContent(newentry.getContent() !=null && !newentry.getContent().equals("") ? newentry.getContent(): old.getContent());

                journalEntryService.saveEntry(old);
                return new ResponseEntity<>(old,HttpStatus.OK);

            }
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @DeleteMapping("/id/{id}")
    @Operation(summary="Remove Journal By ID")
    public ResponseEntity<?> removedJournalEnteryById(@PathVariable ObjectId id){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();

        Boolean remove=journalEntryService.deleteById(id,userName);
        if (remove){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }






}


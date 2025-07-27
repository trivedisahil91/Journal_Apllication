package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JounralEntryController {

    public Map<String, JournalEntry> journal=new HashMap<>();

    @GetMapping
    public ArrayList<JournalEntry> getAll(){
        return new ArrayList<>(journal.values());
    }

    @PostMapping
    public Boolean create(@RequestBody JournalEntry myentry){
//        journal.put(myentry.getId(),myentry); aa ma db vapru chhe bija class ma jema id ObjectId datatype rakho chhe atale aaya aa error throw kar tu tu atale commment mar vu padu
        return true;
    }

    @GetMapping("id/{id}")
    public JournalEntry getJournalEnteryById(@PathVariable String id){
        return journal.get(id);
    }

    @PutMapping("id/{id}")
    public JournalEntry upadateJournalEnteryById(@PathVariable String id,@RequestBody JournalEntry myentry){
        return journal.put(id,myentry);

    }

    @DeleteMapping("id/{id}")
    public String removedJournalEnteryById(@PathVariable String id){
        journal.remove(id);
        return "Deleted Entery:-"+id ;
    }





}

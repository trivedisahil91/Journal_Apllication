package com.example.demo.service;

import com.example.demo.entity.JournalEntry;
import com.example.demo.entity.User;
import com.example.demo.repository.JournalEntryRepositry;
import com.example.demo.repository.UserRepositry;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

    private static final Logger log = LoggerFactory.getLogger(JournalEntryService.class);
    @Autowired
    private JournalEntryRepositry journalEntryRepositry;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepositry userRepositry;


    @Transactional
    public void saveEntry(JournalEntry myentry,String useName){
        try {
            User user=userService.findByUserName(useName);
            myentry.setDate(LocalDateTime.now());
            journalEntryRepositry.save(myentry);
            user.getJournalEntries().add(myentry);  //aaya myentery ma journal entry ni ObjectId jase aana thi bane foren key na concept thi relete kar se
            userService.saveUser(user);
        }catch (Exception e){
            log.error(String.valueOf(e));

        }
    }


    public void saveEntry(JournalEntry myentry){
        try {
            journalEntryRepositry.save(myentry);
        }catch (Exception e){
            log.error("Exception ",e);

        }
    }
    public List<JournalEntry> getAll(){
        return journalEntryRepositry.findAll();
    }

    public Optional<JournalEntry> getEntryById(ObjectId myid){
        return journalEntryRepositry.findById(myid);
    }

    @Transactional
    public Boolean deleteById(ObjectId myid,String userName){
        boolean removed=false;
        try {
            User user=userService.findByUserName(userName);
            removed=user.getJournalEntries().removeIf(x->x.getId().equals(myid));  //removeIf a loop chalave chhe jema vara farati badhi journal entry a loop ma aave tayar bad vara farati lembada experesion ma te condtion chek thay jo sachi pade condtion to te journal entry ne remove kar va ma aave
            if (removed){
                userService.saveUser(user);
                journalEntryRepositry.deleteById(myid);
            }
        }catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry.",e);

        }
        return removed;


    }




}

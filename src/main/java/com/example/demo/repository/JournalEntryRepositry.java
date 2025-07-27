package com.example.demo.repository;

import com.example.demo.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface JournalEntryRepositry extends MongoRepository<JournalEntry, ObjectId> {
}

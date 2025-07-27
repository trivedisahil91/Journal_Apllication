package com.example.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "journalEntry")
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;

    private String title;

    private LocalDateTime date;

    private String content;


}

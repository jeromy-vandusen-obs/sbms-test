package com.sbms.test.stepdefs;

import com.mongodb.client.MongoCollection;
import com.sbms.test.TestApplication;
import com.sbms.test.model.Message;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.bson.Document;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
public class ArrangementSteps implements En {
    private static final String COLLECTION_MESSAGES = "messages";

    private final MongoTemplate mongoTemplate;

    @Before("@UsesMessages")
    public void createMessagesCollection() {
        mongoTemplate.getCollection(COLLECTION_MESSAGES).drop();
        mongoTemplate.createCollection(COLLECTION_MESSAGES);
    }

    @After("@UsesMessages")
    public void dropMessagesCollection() {
        mongoTemplate.getCollection(COLLECTION_MESSAGES).drop();
    }

    public ArrangementSteps(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;

        Given("^the messages collection contains a message for the language \"([^\"]*)\" that says \"([^\"]*)\"$", (String language, String content) -> {
            MongoCollection<Document> messages = mongoTemplate.getCollection(COLLECTION_MESSAGES);
            messages.insertOne(new Message(language, content).toDocument());
        });

        Given("^the messages collection contains exactly these messages:$", (DataTable messages) -> {
            messages.asLists(String.class)
                    .stream()
                    .map(cells -> new Message(cells.get(0), cells.get(1)))
                    .forEach(message -> mongoTemplate.getCollection(COLLECTION_MESSAGES).insertOne(message.toDocument()));
        });
    }
}

package com.rn.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin({"http://localhost:3000", "http://10.219.180.21:3000"})
@RestController
public class ContactController {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Contact>> getAllContacts(){
        return new ResponseEntity<List<Contact>>((List<Contact>) contactRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id){
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (!optionalContact.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        contactRepository.delete(optionalContact.get());
        return new ResponseEntity<>(contactRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addContact(@RequestBody Contact contact){
        contactRepository.save(contact);
        return new ResponseEntity<>(contactRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Long id){
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (!optionalContact.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Contact contact = optionalContact.get();
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}

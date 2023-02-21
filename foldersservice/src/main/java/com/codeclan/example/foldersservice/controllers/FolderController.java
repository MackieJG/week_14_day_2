package com.codeclan.example.foldersservice.controllers;

import com.codeclan.example.foldersservice.models.Folder;
import com.codeclan.example.foldersservice.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public List<Folder> getAllFolder(){
        return  folderRepository.findAll();
    }

    @GetMapping(value = "/folders/{id}")
    public Optional<Folder> getFolder(@PathVariable Long id){
        return folderRepository.findById(id);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}

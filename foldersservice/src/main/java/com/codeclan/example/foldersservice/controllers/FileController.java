package com.codeclan.example.foldersservice.controllers;

import com.codeclan.example.foldersservice.models.File;
import com.codeclan.example.foldersservice.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public List<File> getAllFiles(){
        return  fileRepository.findAll();
    }

    @GetMapping(value = "/files/{id}")
    public Optional<File> getFile(@PathVariable Long id){
        return fileRepository.findById(id);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}

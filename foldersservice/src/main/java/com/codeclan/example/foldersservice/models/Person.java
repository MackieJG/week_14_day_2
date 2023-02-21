package com.codeclan.example.foldersservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String secondName;

    @JsonIgnoreProperties({"person"})
    @OneToMany(mappedBy = "person")
    private List<Folder> folders;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.folders = new ArrayList<>();
    }

    public Person(){

    }

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }
}

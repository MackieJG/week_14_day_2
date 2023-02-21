package com.codeclan.example.foldersservice.components;

import com.codeclan.example.foldersservice.models.File;
import com.codeclan.example.foldersservice.models.Folder;
import com.codeclan.example.foldersservice.models.Person;
import com.codeclan.example.foldersservice.repositories.FileRepository;
import com.codeclan.example.foldersservice.repositories.FolderRepository;
import com.codeclan.example.foldersservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!Test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person johnWayne = new Person("John", "Wayne");
        personRepository.save(johnWayne);

        Person bruceWillis = new Person("Bruce", "Willis");
        personRepository.save(bruceWillis);

        Person marthaDyke = new Person("Martha", "Dyke");
        personRepository.save(marthaDyke);


        Folder folderConfidential = new Folder("Confidential", bruceWillis);
        folderRepository.save(folderConfidential);

        Folder folderPublic = new Folder("Public", johnWayne);
        folderRepository.save(folderPublic);

        Folder folderPrivate = new Folder("Private", marthaDyke);
        folderRepository.save(folderPrivate);


        File file1 = new File("10 Disney Songs", "txt", 11, folderPublic);
        fileRepository.save(file1);

        File file2 = new File("Top secret codes", "ppt", 71, folderConfidential);
        fileRepository.save(file2);

        File file3 = new File("Singing interview", "mp4", 133, folderPrivate);
        fileRepository.save(file3);


        johnWayne.addFolder(folderConfidential);
        johnWayne.addFolder(folderPrivate);
        personRepository.save(johnWayne);

        marthaDyke.addFolder(folderPrivate);
        marthaDyke.addFolder(folderPublic);
        personRepository.save(marthaDyke);

        bruceWillis.addFolder(folderConfidential);
        bruceWillis.addFolder(folderPublic);
        personRepository.save(bruceWillis);


        folderPublic.addFile(file1);
        folderPublic.addFile(file3);
        folderRepository.save(folderPublic);

        folderConfidential.addFile(file2);
        folderPublic.addFile(file3);
        folderRepository.save(folderConfidential);

        folderPrivate.addFile(file2);
        folderPublic.addFile(file1);
        folderRepository.save(folderPrivate);

    }
}

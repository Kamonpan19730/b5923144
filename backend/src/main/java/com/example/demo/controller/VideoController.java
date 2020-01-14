package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

import com.example.demo.repository.LibrarianRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.VideoRepository;

import com.example.demo.entity.Librarian;
import com.example.demo.entity.Video;
import com.example.demo.entity.Type;
import com.example.demo.entity.Category;;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class VideoController {
    @Autowired
    private final VideoRepository videoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private TypeRepository typeRepository;


    VideoController(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }


    @GetMapping("/video")
    public Collection<Video> Video() {
        return videoRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/addVideo/{librarianid}/{videoName}/{typeid}/{categoryid}")
        public Video newVideo(Video newVideo,
                                  @PathVariable long librarianid,
                                  @PathVariable String videoName,
                                  @PathVariable long typeid,
                                  @PathVariable long categoryid) {
                                      
          
            Librarian librarian = librarianRepository.findById(librarianid);
            Type type = typeRepository.findById(typeid);
            Category category = categoryRepository.findById(categoryid);

            newVideo.setLibrarian(librarian);
            newVideo.setVideoName(videoName);
            newVideo.setType(type);
            newVideo.setCategory(category);
            

            
            return videoRepository.save(newVideo);

    }
}
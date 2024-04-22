package com.example.library.jobs;

import com.example.library.service.AuthorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    private final AuthorService authorService;

    public ScheduledTask(AuthorService authorService) {
        this.authorService = authorService;
    }

//    @Scheduled(fixedDelay=5000)
//    public void refreshMaterializedView(){
//        this.authorService.refreshMaterializedView();
//    }
}

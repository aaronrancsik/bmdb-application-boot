package com.example.bmdb.app;


import com.example.bmdb.config.AppConfig;


import com.example.bmdb.models.*;
import com.example.bmdb.services.*;
import com.example.bmdb.services.user.UserService;
import com.example.bmdb.view.View;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppSpring {

    private static Logger log = LoggerFactory.getLogger(AppSpring.class);

    private UserService userService;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private MediaService mediaService;

    @Inject
    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }


    private MainService mainService;

    @Inject
    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    private View view;

    @Inject
    public void setView(View view) {
        log.info("setView");
        this.view = view;
    }


    public void launch() {

        log.info("launch");
        User user = createUser();
        do {
            view.printMedias(mediaService.findAll());
            long selectedMediaId = selectMediaId();
            mainService.doReview(user.getName(), user.getPassword(), selectedMediaId, view.getReviewTextFromConsole(), view.getRatingFromConsole());
        } while (view.anotherReviewFromConsole());

        view.printMedias(mediaService.findAll());
        long selectedMediaId = selectMediaId();
        averageReviews(selectedMediaId);
    }


    private User createUser() {
        view.printRegistration();
        log.info("createUser");
        User user = this.view.readUserData();

        try {
            userService.save(user);
        } catch (Exception ex) {

        }
        view.printWelcomeMessage(user);
        return user;
    }

    private long selectMediaId() {
        log.info("selectMedia");
        return view.getIdFromConsole();
    }

    private void averageReviews(long selected) {
        log.info("averageReviews");
        view.averageReviewsToConsole(mediaService.getAverageRating(selected));
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            AppSpring app = appContext.getBean(AppSpring.class);
            app.launch();
        }
    }
}

package com.example.bmdb.view;

import com.example.bmdb.models.Media;
import com.example.bmdb.models.Rating;
import com.example.bmdb.models.Review;
import com.example.bmdb.models.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Scanner;

@Component
public class View {

    private Scanner in;

    I18nMsg i18nMsg;
    @Inject
    public void setI18nMsg(I18nMsg i18nMsg) {
        this.i18nMsg = i18nMsg;
    }

    User.UserBuilder userBuilder;
    @Inject
    public void setUserBuilder(User.UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    Review.ReviewBuilder reviewBuilder;
    @Inject
    public void setReviewBuilder(Review.ReviewBuilder reviewBuilder) {
        this.reviewBuilder = reviewBuilder;
    }

    public View() {
        in = new Scanner(System.in);
    }

    public User readUserData()  {

        System.out.println(i18nMsg.getMsg("view.question.name"));
        userBuilder.withName(in.nextLine());

        System.out.println(i18nMsg.getMsg("view.get.email"));
        userBuilder.withEmail(in.nextLine());

        System.out.println(i18nMsg.getMsg("view.get.newPassword"));
        userBuilder.withPassword(in.nextLine());

        return userBuilder.build();
    }

    public void printWelcomeMessage(User user){
        System.out.println(i18nMsg.getMsg("view.welcome",new Object[]{ user.getName() }));
    }

    public void printMedias(Iterable<Media> medias){
        System.out.println(i18nMsg.getMsg("view.medias"));
        for (Media m: medias){
            System.out.println(m.toString());
        }
        System.out.println(i18nMsg.getMsg("view.get.id"));
    }

    public long getIdFromConsole(){
        String input = in.nextLine();
        int inputNumber = Integer.parseInt(input);
        return inputNumber;
    }

    public String getReviewTextFromConsole() {
        System.out.println(i18nMsg.getMsg("view.get.review"));
        return in.nextLine();
    }

    public Rating getRatingFromConsole() {
        Rating rate = null;
        while (rate == null){
            System.out.println(i18nMsg.getMsg("view.get.rating"));
            String choosedRate = in.nextLine().toLowerCase();
            if(choosedRate.equals(i18nMsg.getMsg("view.rate.bad"))) {
                rate=Rating.BAD;
            }
            else if(choosedRate.equals(i18nMsg.getMsg("view.rate.average"))){
                rate=Rating.AVERAGE;
            }
            else if(choosedRate.equals(i18nMsg.getMsg("view.rate.good"))){
                rate=Rating.GOOD;
            }
        }
        return rate;
    }

    public void averageReviewsToConsole(double average){
        System.out.println(i18nMsg.getMsg("view.averageReview", average));
    }

    public boolean anotherReviewFromConsole() {
        while (true){
            System.out.println(i18nMsg.getMsg("view.question.anotherReview"));
            String yesOrNo = in.nextLine();
            if(yesOrNo.equals(i18nMsg.getMsg("view.yes"))){
                return true;
            }else if(yesOrNo.equals(i18nMsg.getMsg("view.no"))){
                return false;
            }
        }
    }

    public void printRegistration() {
        System.out.println(i18nMsg.getMsg("view.registration"));
    }
}

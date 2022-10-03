package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class PracticeForm {

    @BeforeAll
    static void configure() {
        System.out.println("### @BeforeAll");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
           }

    @Test
    void fillForm() {
        open("/automation-practice-form");
    //Delete banner
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    //Set name
        System.out.println("###     @fillName() !");
        $("#firstName").setValue("Denis");
    //Set surname
        System.out.println("###     @fillSurname() !");
        $("#lastName").setValue("Kudla");
    //Set email
        System.out.println("###     @fillEmail");
        $("#userEmail-wrapper #userEmail").setValue("denis@kudla.com");
    //Set gender
        System.out.println("###     @fillGender");
        $("#genterWrapper").$(byText("Male")).click();
    //Set phone number
        System.out.println("###     @fillNumber");
        $("#userNumber-wrapper #userNumber").setValue("7777777777");
    //Set birth date
        System.out.println("###     @fillBirthDate");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__month-select").selectOption(6);
        $(".react-datepicker__day--029").click();
    //Set Subjects
        $("#subjectsInput").setValue("Social").pressEnter();
    //Set hobbies
        System.out.println("###     @fillHobbies");
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
    //Upload image
        System.out.println("###     @uploadImage");
        $("#uploadPicture").uploadFile(new File("src/test/resources/1617343839_50-p-oboi-osennii-sad-59.jpeg"));
    //Set address
        System.out.println("###     @fillAddress");
        $("#currentAddress").setValue("st.Pushkina 6, bld. Kolotuskina 9, app 42");

    //Set State and City
        System.out.println("###     @fillState and City");
        $("#state").click();
        $("#state").$(byText("NCR")).click();

        $("#city").click();
        $("#city").$(byText("Delhi")).click();


    //Now lets check this out
        $("#submit").click();


    //Student Name
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Denis Kudla"));
    //Student Email
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("denis@kudla.com"));
    //Gender
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Male"));
    //Mobile
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("7777777777"));
    //Date of Birth
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("29 July,1994"));
    //Subjects
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Social Studies"));
        //Hobbies
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports, Reading, Music"));
    //Picture
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("1617343839_50-p-oboi-osennii-sad-59.jpeg"));
    //Address
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("st.Pushkina 6, bld. Kolotuskina 9, app 42"));
    //State and City
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("NCR Delhi"));

    //Close tab
        $("#closeLargeModal").click();

    }
}

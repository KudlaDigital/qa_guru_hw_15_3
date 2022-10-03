package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
           }

    @Test
    void fillFormTest() throws InterruptedException {
        open("/automation-practice-form");
        //Delete banner
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //Set name
        $("#firstName").setValue("Denis");
        //Set surname
        $("#lastName").setValue("Kudla");
        //Set email
        $("#userEmail-wrapper #userEmail").setValue("denis@kudla.com");
        //Set gender
        $("#genterWrapper").$(byText("Male")).click();
        //Set phone number
        $("#userNumber-wrapper #userNumber").setValue("7777777777");
        //Set birth date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1994");
        $(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[6]")).click();
        //Set objects
        //X_X
        //Set hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        //Upload image
        $("#uploadPicture").uploadFile(new File("src/test/resources/1617343839_50-p-oboi-osennii-sad-59.jpeg"));
        //Set adress
        $("#currentAddress").setValue("st.Pushkina 6, bld. Kolotuskina 9, app 42");
        //More adress

        $("#submit").click();


        //Now lets check

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
        //  I could't find the way to check this -_-
        //Hobbies
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports, Reading, Music"));
        //Picture
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("1617343839_50-p-oboi-osennii-sad-59.jpeg"));
        //Address
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("st.Pushkina 6, bld. Kolotuskina 9, app 42"));

        //Close tab
        $("#closeLargeModal").click();

    }
}

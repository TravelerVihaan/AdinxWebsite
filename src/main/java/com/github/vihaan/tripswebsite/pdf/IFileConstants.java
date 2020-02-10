package com.github.vihaan.tripswebsite.pdf;

interface IFileConstants {

    // PDF Text
    final String TOP_TEXT = "THANK YOU FOR YOUR ORDER!";
    final String TRIP_NAME = "SILVER MINE";

    final String BOOKING_TEXT = "You have booked tour to Silver Mine";
    final String PICK_TEXT = "We will pick you up from ";
    final String ON = "on";

    final String DETAILS_TEXT = "Here are order details: ";
    final String VOUCHER_NUMBER = "Voucher number ";
    final String LANGUAGE = "Tour language: English";

    final String TICKETS_INFO = "Tickets: ";
    final String NORMAL_TICKETS1 = "Normal - ";
    final String NORMAL_TICKETS2 = " ticket(s)";

    final String PRICE1 = "Price";
    final String PRICE2 = "PLN";

    final String PAYMENT = "Payment : To be paid in office\n" +
            "Order date";
    final String SIGNATURE1 = "Make it EASY with us!";
    final String SIGNATURE2 = "EasyTours!";

    // PDF Fonts
    final String LIBRE_FONT = "Libre";
    final String LIBRE_FONT_PATH = "src/main/resources/fonts/LibreBaskerville-Regular.ttf";
    final String MONTSERRAT_FONT = "Montserrat";
    final String MONTSERRAT_FONT_PATH = "src/main/resources/fonts/Montserrat-Bold.ttf";
    final String OPENSANS_FONT = "OpenSans";
    final String OPENSANS_FONT_PATH = "src/main/resources/fonts/OpenSans-Light.ttf";

    final String TMP_FILE_PATH = "/tmp/voucher-file.pdf";
}

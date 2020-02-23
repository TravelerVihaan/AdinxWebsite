package com.github.vihaan.tripswebsite.pdf;

interface IFileConstants {

    // PDF Text
    String TOP_TEXT = "THANK YOU FOR YOUR ORDER!";

    String BOOKING_TEXT = "You have booked tour to ";
    String PICK_TEXT = "We will pick you up from ";
    String ON = "on";

    String DETAILS_TEXT = "Here are order details: ";
    String VOUCHER_NUMBER = "Voucher number ";
    String LANGUAGE = "Tour language: English";

    String CLIENT = "Client's info: ";

    String TICKETS_INFO = "Tickets: ";
    String NORMAL_TICKETS = "Normal - ";
    String REDUCED_TICKETS = "Normal - ";
    String TICKETS = " ticket(s)";

    String PRICE1 = "Total price: ";
    String PRICE2 = " PLN";

    String PAYMENT = "Payment : To be paid in office";
    String ORDER_DATE = "Order date ";
    String SIGNATURE1 = "Make it EASY with us!";
    String SIGNATURE2 = "EasyTours!";

    // PDF Fonts
    String LIBRE_FONT = "Libre";
    String LIBRE_FONT_PATH = "src/main/resources/fonts/LibreBaskerville-Regular.ttf";
    String MONTSERRAT_FONT = "Montserrat";
    String MONTSERRAT_FONT_PATH = "src/main/resources/fonts/Montserrat-Bold.ttf";
    String OPENSANS_FONT = "OpenSans";
    String OPENSANS_FONT_PATH = "src/main/resources/fonts/OpenSans-Light.ttf";


    @Deprecated
    String TMP_FILE_PATH = "/tmp/voucher-file.pdf";
}

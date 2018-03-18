package ru.test.rest;


import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainTest {
    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = 80;
        } else {
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/2.0/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://ws.audioscrobbler.com/";
        }
        RestAssured.baseURI = baseHost;
        RestAssured.given().param("api_key", "c32a740e3b0484adc018a11e05902a30");
    }

    @Test
    public void testArtistSearch() {
//        HashMap<String, String> params = new HashMap<String, String>(){{
//            put("method","artist.search");
//            put("artist","cher");
//            put("format","json");
//        }};
        String s = given()
                .param("api_key", "c32a740e3b0484adc018a11e05902a30")
                .param("method", "artist.search")
                .param("artist", "cher")
                .param("format", "json")
                .get("")
                .asString();
        System.out.println(s);
    }

    @Test
    public void testArtistGetInfo() {
        given()
                .param("api_key", "c32a740e3b0484adc018a11e05902a30")
                .param("method", "artist.getinfo")
                .param("artist", "Madonna")
                .param("format", "json")
                .get("")
                .then().body("artist.name", equalTo("Madonna"));
    }

    @Test
    public void testGeoGetTopArtists () {
        String s = given()
                .param("api_key", "c32a740e3b0484adc018a11e05902a30")
                .param("method", "geo.gettopartists")
                .param("country", "belarus")
                .param("format", "json")
                .get("")
                .asString();
        System.out.println(s);
    }


}
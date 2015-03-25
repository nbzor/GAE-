package com.cloud.t3.rest;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

/**
 *
 * @author Valentin
 */
public class App {
    public static final String API_KEY_DEFAULT = "AIzaSyDCESd6MVJ0DB7zI_v_oya7xeo5NbTY6fw";
    public static final GoogleCredential CREDENTIAL_DEFAULT = new GoogleCredential().setAccessToken(API_KEY_DEFAULT);   
}

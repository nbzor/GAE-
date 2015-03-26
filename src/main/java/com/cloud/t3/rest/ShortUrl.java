package com.cloud.t3.rest;

import com.cloud.t3.dao.UrlEntity;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.model.Url;
import com.google.api.services.urlshortener.model.UrlHistory;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Valentin
 */
@Path("url")
public class ShortUrl extends Resource {

    @GET
    @Produces("application/json")
    public Response getAll() throws IOException {
        Urlshortener.Url url = new Urlshortener.Builder(new NetHttpTransport(), new JacksonFactory(),null).
                setApplicationName(App.APPLICATION_NAME).build().url();
        
        Urlshortener.Url.List uList = url.list();
        uList.setKey(App.API_KEY_DEFAULT);
        
        return OK(uList.execute().toPrettyString());
    }

    @POST
    public Response createURL(UrlEntity urlEntity) throws IOException {
        if (urlEntity.getLongURL().isEmpty()) {
            return BAD_REQUEST;
        }

        Urlshortener.Url url = new Urlshortener.Builder(new NetHttpTransport(), new JacksonFactory(), App.CREDENTIAL_DEFAULT).
                setApplicationName(App.APPLICATION_NAME).build().url();

        Url u = new Url();
        u.setLongUrl(urlEntity.getLongURL());

        Urlshortener.Url.Insert insert = url.insert(u);
        insert.setKey(App.API_KEY_DEFAULT);
        u = insert.execute();
        return CREATED(u.toPrettyString());
    }

    @GET
    @Path("{url}")
    public Response getUrl(@PathParam("url") String urlShort) throws IOException {
        Urlshortener.Url url = new Urlshortener.Builder(new NetHttpTransport(), new JacksonFactory(), App.CREDENTIAL_DEFAULT).
                setApplicationName(App.APPLICATION_NAME).build().url();
        Urlshortener.Url.List uList = url.list();
        uList.setKey(App.API_KEY_DEFAULT);
        UrlHistory history = uList.execute();
        for(Url u : history.getItems()){
            if(u.getId().equals(urlShort))
                return OK(u.toPrettyString());
        }
        return NOT_FOUND;
    }
}

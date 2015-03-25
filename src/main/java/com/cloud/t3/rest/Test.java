package com.cloud.t3.rest;

import com.cloud.t3.dao.TextEntity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Valentin
 */
@Path("123")
public class Test {

    @GET
    @Produces("application/json")
    public TextEntity get() {
        TextEntity t = new TextEntity();
        t.setText("CEVA");
        return t;
    }
}

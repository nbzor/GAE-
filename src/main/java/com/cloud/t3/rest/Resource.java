package com.cloud.t3.rest;

import javax.ws.rs.core.Response;

/**
 *
 * @author Valentin
 */
public class Resource {
  public static Response NOT_FOUND = Response.status(404).build();
    public static Response METHOD_NOT_ALLOWED = Response.status(405).build();
    public static Response BAD_REQUEST = Response.status(Response.Status.BAD_REQUEST).build();
    public static Response INTERNAL_SERVER_ERROR = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    
    public static Response OK() {
        return Response.status(200).build();
    }

    public static Response OK(Object e) {
        return Response.status(200).entity(e).build();
    }

    public static Response CREATED() {
        return Response.status(201).build();
    }

    public static Response CREATED(Object e) {
        return Response.status(201).entity(e).build();
    }
}

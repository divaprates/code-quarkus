package br.com.diva;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService greetingService = new GreetingService();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(String name) {
        return greetingService.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive!";
    }

    @GET
    @Path("/users")
    public Set<User> getUsers() {
        Set<User> users = Collections.synchronizedSet(new LinkedHashSet<>());
        users.add(new User(UUID.randomUUID(), "Diva"));
        users.add(new User(UUID.randomUUID(), "Sophia"));
        users.add(new User(UUID.randomUUID(), "Bela"));
        users.add(new User(UUID.randomUUID(), "Lua"));

        return users;
    }

    record User(UUID id, String name) {
    }

}

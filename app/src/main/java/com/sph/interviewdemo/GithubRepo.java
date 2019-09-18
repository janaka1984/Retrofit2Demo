package com.sph.interviewdemo;


public class GithubRepo {

    // fields must have same names as fields in JSON. watch out!
    private String name;
    private String full_name;
    private Owner owner;

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }


    public Owner getOwner() {
        return owner;
    }


    public class Owner {
        public String login;
        public int id;

        public String getLogin() {
            return login;
        }

        public int getId() {
            return id;
        }
    }

}

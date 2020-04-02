package com.example.bmdb.services.auth;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
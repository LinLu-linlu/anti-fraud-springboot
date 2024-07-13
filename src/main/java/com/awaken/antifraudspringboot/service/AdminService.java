package com.awaken.antifraudspringboot.service;

import com.awaken.antifraudspringboot.entity.Result;

public interface AdminService {
    Result login(String username, String password);
}

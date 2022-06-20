package com.alejandrojorba.argprograma.DTOs;

import lombok.Data;

public @Data class AuthenticateRequest {
    String usuario;
    String password;
}

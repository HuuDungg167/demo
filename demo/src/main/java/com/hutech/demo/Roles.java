package com.hutech.demo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public enum Roles {
    ADMIN(1),
    CUSTOMER(2),
    EMPLOYER(3);
    public final long value;
}
package com.adnanarch.securedoc.enumeration;

import lombok.Getter;

import static com.adnanarch.securedoc.constant.Constants.*;

@Getter
public enum Authority {
    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES);

    private final String value;

    Authority(String value) {
        this.value = value;
    }
}

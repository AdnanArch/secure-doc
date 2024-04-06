package com.adnanarch.securedoc.constant;

/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 1:32 AM
 * Version: 1.0
 */

public class Constants {
    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTHORITY_DELIMITER = ",";
    public static final String USER_AUTHORITIES = "document:read,document:create,document:update,document:delete";
    public static final String ADMIN_AUTHORITIES = "user:create,user:read,user:update,document:read,document:create,document:update,document:delete";
    public static final String SUPER_ADMIN_AUTHORITIES = "user:create,user:read,user:update,user:delete,document:read,document:create,document:update,document:delete";
    public static final String MANAGER_AUTHORITIES = "document:read,document:create,document:update,document:delete";
}

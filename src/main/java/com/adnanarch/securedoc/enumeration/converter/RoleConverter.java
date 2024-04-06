package com.adnanarch.securedoc.enumeration.converter;

import com.adnanarch.securedoc.enumeration.Authority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 11:08 AM
 * Version: 1.0
 */

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Authority, String> {
    @Override
    public String convertToDatabaseColumn(Authority authority) {
        if (authority == null) {
            return null;
        }
        return authority.getValue();
    }

    @Override
    public Authority convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Authority.values())
                .filter(authority -> authority.getValue().equals(code)).
                findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

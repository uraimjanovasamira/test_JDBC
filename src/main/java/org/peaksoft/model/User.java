package org.peaksoft.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {
    Long id;
    String name;
    String lastName;
    Byte age;
    Long card_id;

        public User(String name, String lastName, Byte age, Long carId) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.card_id = carId;
    }

}
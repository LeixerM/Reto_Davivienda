package com.orangehrm.demo.models;

import lombok.*;

import java.nio.file.Path;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataEmployee {
    private Path pathFile;
    private String firstName;
    private String middleName;
    private String lastName;
    private String idEmployee;

    public static DataEmployee of(Path pathImage, String firstName, String middleName, String lastName, String idEmployee) {
        return new DataEmployee(pathImage.toAbsolutePath(), firstName, middleName, lastName, idEmployee);
    }
}

package com.orangehrm.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@AllArgsConstructor
@Getter
@Setter
public class DataLogin {

        private String username;
        private String password;

}


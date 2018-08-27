package demo.controller;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class QikuForm {
    @Size(max = 3)
    private String question;
}

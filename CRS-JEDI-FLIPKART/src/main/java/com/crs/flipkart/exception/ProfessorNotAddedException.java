package com.crs.flipkart.exception;

import com.crs.flipkart.bean.Professor;

public class ProfessorNotAddedException extends Exception{
    ProfessorNotAddedException(){
    }
    @Override
    public String getMessage() {
        return "Professor not found!!!";
    }
}

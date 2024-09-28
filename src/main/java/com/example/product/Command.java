package com.example.product;

public interface Command<I,O>{
    O excute(I input);
}

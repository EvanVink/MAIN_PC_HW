cmake_minimum_required(VERSION 3.29)
project(assignment2C C)

set(CMAKE_C_STANDARD 23)

add_executable(assignment2C main.c
        Student.c
        Student.h)

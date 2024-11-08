cmake_minimum_required(VERSION 3.29)
project(lab7C C)

set(CMAKE_C_STANDARD 23)

add_executable(lab7C main.c
        student.c
        student.h)

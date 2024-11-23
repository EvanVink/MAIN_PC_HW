cmake_minimum_required(VERSION 3.29)
project(lab8 C)

set(CMAKE_C_STANDARD 23)

add_executable(lab8 main.c
        circular_node.c
        circular_node.h)

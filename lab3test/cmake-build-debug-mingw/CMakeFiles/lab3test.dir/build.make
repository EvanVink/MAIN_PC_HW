# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.29

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "E:\CLion 2024.2.1\bin\cmake\win\x64\bin\cmake.exe"

# The command to remove a file.
RM = "E:\CLion 2024.2.1\bin\cmake\win\x64\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "E:\CST HOMEWORK\MAIN_PC_HW\lab3test"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "E:\CST HOMEWORK\MAIN_PC_HW\lab3test\cmake-build-debug-mingw"

# Include any dependencies generated for this target.
include CMakeFiles/lab3test.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/lab3test.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/lab3test.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/lab3test.dir/flags.make

CMakeFiles/lab3test.dir/Lab3.c.obj: CMakeFiles/lab3test.dir/flags.make
CMakeFiles/lab3test.dir/Lab3.c.obj: E:/CST\ HOMEWORK/MAIN_PC_HW/lab3test/Lab3.c
CMakeFiles/lab3test.dir/Lab3.c.obj: CMakeFiles/lab3test.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir="E:\CST HOMEWORK\MAIN_PC_HW\lab3test\cmake-build-debug-mingw\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/lab3test.dir/Lab3.c.obj"
	"E:\CLion 2024.2.1\bin\mingw\bin\gcc.exe" $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/lab3test.dir/Lab3.c.obj -MF CMakeFiles\lab3test.dir\Lab3.c.obj.d -o CMakeFiles\lab3test.dir\Lab3.c.obj -c "E:\CST HOMEWORK\MAIN_PC_HW\lab3test\Lab3.c"

CMakeFiles/lab3test.dir/Lab3.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing C source to CMakeFiles/lab3test.dir/Lab3.c.i"
	"E:\CLion 2024.2.1\bin\mingw\bin\gcc.exe" $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "E:\CST HOMEWORK\MAIN_PC_HW\lab3test\Lab3.c" > CMakeFiles\lab3test.dir\Lab3.c.i

CMakeFiles/lab3test.dir/Lab3.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling C source to assembly CMakeFiles/lab3test.dir/Lab3.c.s"
	"E:\CLion 2024.2.1\bin\mingw\bin\gcc.exe" $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "E:\CST HOMEWORK\MAIN_PC_HW\lab3test\Lab3.c" -o CMakeFiles\lab3test.dir\Lab3.c.s

# Object files for target lab3test
lab3test_OBJECTS = \
"CMakeFiles/lab3test.dir/Lab3.c.obj"

# External object files for target lab3test
lab3test_EXTERNAL_OBJECTS =

lab3test.exe: CMakeFiles/lab3test.dir/Lab3.c.obj
lab3test.exe: CMakeFiles/lab3test.dir/build.make
lab3test.exe: CMakeFiles/lab3test.dir/linkLibs.rsp
lab3test.exe: CMakeFiles/lab3test.dir/objects1.rsp
lab3test.exe: CMakeFiles/lab3test.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir="E:\CST HOMEWORK\MAIN_PC_HW\lab3test\cmake-build-debug-mingw\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable lab3test.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\lab3test.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/lab3test.dir/build: lab3test.exe
.PHONY : CMakeFiles/lab3test.dir/build

CMakeFiles/lab3test.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\lab3test.dir\cmake_clean.cmake
.PHONY : CMakeFiles/lab3test.dir/clean

CMakeFiles/lab3test.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "E:\CST HOMEWORK\MAIN_PC_HW\lab3test" "E:\CST HOMEWORK\MAIN_PC_HW\lab3test" "E:\CST HOMEWORK\MAIN_PC_HW\lab3test\cmake-build-debug-mingw" "E:\CST HOMEWORK\MAIN_PC_HW\lab3test\cmake-build-debug-mingw" "E:\CST HOMEWORK\MAIN_PC_HW\lab3test\cmake-build-debug-mingw\CMakeFiles\lab3test.dir\DependInfo.cmake" "--color=$(COLOR)"
.PHONY : CMakeFiles/lab3test.dir/depend


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
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2024.2.1\bin\cmake\win\x64\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2024.2.1\bin\cmake\win\x64\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/assignment2C.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/assignment2C.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/assignment2C.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/assignment2C.dir/flags.make

CMakeFiles/assignment2C.dir/main.c.obj: CMakeFiles/assignment2C.dir/flags.make
CMakeFiles/assignment2C.dir/main.c.obj: C:/Users/socce/Desktop/MAINPCHW/MAIN_PC_HW/assignment2C/main.c
CMakeFiles/assignment2C.dir/main.c.obj: CMakeFiles/assignment2C.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/assignment2C.dir/main.c.obj"
	C:\PROGRA~1\JETBRA~1\CLION2~1.1\bin\mingw\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/assignment2C.dir/main.c.obj -MF CMakeFiles\assignment2C.dir\main.c.obj.d -o CMakeFiles\assignment2C.dir\main.c.obj -c C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\main.c

CMakeFiles/assignment2C.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing C source to CMakeFiles/assignment2C.dir/main.c.i"
	C:\PROGRA~1\JETBRA~1\CLION2~1.1\bin\mingw\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\main.c > CMakeFiles\assignment2C.dir\main.c.i

CMakeFiles/assignment2C.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling C source to assembly CMakeFiles/assignment2C.dir/main.c.s"
	C:\PROGRA~1\JETBRA~1\CLION2~1.1\bin\mingw\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\main.c -o CMakeFiles\assignment2C.dir\main.c.s

CMakeFiles/assignment2C.dir/Student.c.obj: CMakeFiles/assignment2C.dir/flags.make
CMakeFiles/assignment2C.dir/Student.c.obj: C:/Users/socce/Desktop/MAINPCHW/MAIN_PC_HW/assignment2C/Student.c
CMakeFiles/assignment2C.dir/Student.c.obj: CMakeFiles/assignment2C.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/assignment2C.dir/Student.c.obj"
	C:\PROGRA~1\JETBRA~1\CLION2~1.1\bin\mingw\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -MD -MT CMakeFiles/assignment2C.dir/Student.c.obj -MF CMakeFiles\assignment2C.dir\Student.c.obj.d -o CMakeFiles\assignment2C.dir\Student.c.obj -c C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\Student.c

CMakeFiles/assignment2C.dir/Student.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing C source to CMakeFiles/assignment2C.dir/Student.c.i"
	C:\PROGRA~1\JETBRA~1\CLION2~1.1\bin\mingw\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\Student.c > CMakeFiles\assignment2C.dir\Student.c.i

CMakeFiles/assignment2C.dir/Student.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling C source to assembly CMakeFiles/assignment2C.dir/Student.c.s"
	C:\PROGRA~1\JETBRA~1\CLION2~1.1\bin\mingw\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\Student.c -o CMakeFiles\assignment2C.dir\Student.c.s

# Object files for target assignment2C
assignment2C_OBJECTS = \
"CMakeFiles/assignment2C.dir/main.c.obj" \
"CMakeFiles/assignment2C.dir/Student.c.obj"

# External object files for target assignment2C
assignment2C_EXTERNAL_OBJECTS =

assignment2C.exe: CMakeFiles/assignment2C.dir/main.c.obj
assignment2C.exe: CMakeFiles/assignment2C.dir/Student.c.obj
assignment2C.exe: CMakeFiles/assignment2C.dir/build.make
assignment2C.exe: CMakeFiles/assignment2C.dir/linkLibs.rsp
assignment2C.exe: CMakeFiles/assignment2C.dir/objects1.rsp
assignment2C.exe: CMakeFiles/assignment2C.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir=C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking C executable assignment2C.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\assignment2C.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/assignment2C.dir/build: assignment2C.exe
.PHONY : CMakeFiles/assignment2C.dir/build

CMakeFiles/assignment2C.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\assignment2C.dir\cmake_clean.cmake
.PHONY : CMakeFiles/assignment2C.dir/clean

CMakeFiles/assignment2C.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\cmake-build-debug C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\cmake-build-debug C:\Users\socce\Desktop\MAINPCHW\MAIN_PC_HW\assignment2C\cmake-build-debug\CMakeFiles\assignment2C.dir\DependInfo.cmake "--color=$(COLOR)"
.PHONY : CMakeFiles/assignment2C.dir/depend


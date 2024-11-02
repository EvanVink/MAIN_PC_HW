# Compiler and flags
CC       = gcc
CFLAGS   = -Wall
LDFLAGS  =

# Target and object files
TARGET   = test
OBJFILES = main.o Student.o

# Default target
all: $(TARGET)

# Link object files to create the final executable
$(TARGET): $(OBJFILES)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJFILES) $(LDFLAGS)

# Compilation rules for individual .o files
main.o: main.c
	$(CC) $(CFLAGS) -c main.c

Student.o: Student.c
	$(CC) $(CFLAGS) -c Student.c

# Clean rule to remove object files and executable
clean:
	rm -f $(OBJFILES) $(TARGET) *~
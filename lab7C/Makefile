CC       = gcc
CFLAGS   = -Wall
LDFLAGS  =

TARGET   = test
OBJFILES = main.o Student.o

all: $(TARGET)

$(TARGET): $(OBJFILES)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJFILES) $(LDFLAGS)

main.o: main.c
	$(CC) $(CFLAGS) -c main.c

Student.o: Student.c
	$(CC) $(CFLAGS) -c Student.c

clean:
	rm -f $(OBJFILES) $(TARGET) *~
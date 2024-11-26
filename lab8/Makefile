CC       = gcc
CFLAGS   = -Wall
LDFLAGS  =

TARGET   = test
OBJFILES = main.o circular_node.o

all: $(TARGET)

$(TARGET): $(OBJFILES)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJFILES) $(LDFLAGS)

main.o: main.c
	$(CC) $(CFLAGS) -c main.c

circular_node.o: circular_node.c
	$(CC) $(CFLAGS) -c circular_node.c

clean:
	rm -f $(OBJFILES) $(TARGET) *~
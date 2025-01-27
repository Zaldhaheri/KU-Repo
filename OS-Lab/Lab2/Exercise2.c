#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv)
{
    if (argc != 4)
        printf("Enter string size, string and, a character only\n");
    else
    {
        int size = atoi(argv[1]);
        char str[size];
        int i;
        for (i = 0; i < strlen(str) + j; i++)
            str[i] = argv[2][i];
        str[i] = '\0';
        char c = argv[3][0];
        
        printf("%s\n", str);
    }
}

#include <stdio.h>

int main()
{
    char c;
    while(1)
    {
        printf("Enter letter: ");
        scanf(" %c", &c);

        if ('a' <= c && 'f' >= c)
            printf("1\n");
        else if ('B' <= c && 'G' >= c)
            printf("2\n");
        else
            printf("3\n");
    }
    return (0);
}
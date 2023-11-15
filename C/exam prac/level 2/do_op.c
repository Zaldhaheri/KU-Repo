#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    printf("%d\n%s\n%s\n%s\n", argc, argv[1], argv[2], argv[3]);
    if (argc == 4)
    {
        if (argv[2][0] == '+')
            printf("%d", (atoi(argv[1]) + atoi(argv[3])));
        else if (argv[2][0] == '-')
            printf("%d", (atoi(argv[1]) - atoi(argv[3])));
        else if (argv[2][0] == '*')
            printf("%d", atoi(argv[1]) * atoi(argv[3]));
        else if (argv[2][0] == '/')
            printf("%d", (atoi(argv[1]) / atoi(argv[3])));
        else if (argv[2][0] == '%')
            printf("%d", (atoi(argv[1]) % atoi(argv[3])));
    }
    printf("\n");
    return (0);
}

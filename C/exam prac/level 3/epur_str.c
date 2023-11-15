#include <unistd.h>
#include <stdio.h>

int main(int argc, char **argv)
{
    int i;
    int len;

    i = 0;
    len = 0;
    if (argc == 2)
    {
        while (argv[1][len] != '\0')
            len++;
        len--;
        while (argv[1][i] != '\0' && (argv[1][i] == ' ' || argv[1][i] == '\t'))
            i++;
        while (argv[1][i] != '\0')
        {
            if (argv[1][i] == ' ' || argv[1][i] == '\t')
            {
                while (argv[1][i] != '\0' && (argv[1][i] == ' ' || argv[1][i] == '\t'))
                    i++;
                i--;
            }
            if (i == len && (argv[1][i] == ' ' || argv[1][i] == '\t'))
                break;
            write (1, &argv[1][i], 1);
            i++;
        }
    }
    write (1, "\n", 2);
    return (0);
}
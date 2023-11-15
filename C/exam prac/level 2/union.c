#include <unistd.h>

int check_d(int x, char c, char *str)
{
    int i;

    i = 0;
    while (str[i] != '\0' && i < x)
    {
        if (str[i] == c)
            return (0);
        i++;
    }
    return (1);
}

int check_str(char c, char *str)
{
    int i;

    i = 0;
    while (str[i] != '\0')
    {
        if (str[i] == c)
            return (0);
        i++;
    }
    return (1);
}

int main(int argc, char **argv)
{
    int i;

    i = 0;
    if (argc == 3)
    {
        while (argv[1][i] != '\0')
        {
            if (check_d(i, argv[1][i], argv[1]) == 1)
                write (1, &argv[1][i], 1);
            i++;
        }
        i = 0;
        while (argv[2][i] != '\0')
        {
            if (check_d(i, argv[2][i], argv[2]) == 1)
            {
                if (check_str(argv[2][i], argv[1]) == 1)
                    write (1, &argv[2][i], 1);
            }
            i++;
        }
    }
    write (1, "\n", 1);
    return (0);
}
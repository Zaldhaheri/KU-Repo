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

int main (int argc, char **argv)
{
    int i;
    int j;

    j = 0;
    i = 0;
    if (argc == 3)
    {
        while (argv[1][i] != '\0')
        {
            while (argv[2][j] != '\0')
            {
                if (argv[1][i] == argv[2][j])
                {
                    if (check_d(i, argv[1][i], argv[1]))
                    {
                        write (1, &argv[1][i], 1);
                        break ;
                    }
                }
                j++;
            }
            i++;
            j = 0;
        }
    }
    write (1, "\n", 2);
    return (0);
}
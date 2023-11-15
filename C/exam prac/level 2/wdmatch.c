#include <unistd.h>

int main(int argc, char **argv)
{
    int i;
    int j;

    i = 0;
    j = 0;
    if (argc == 3)
    {
        while (argv[2][i] != '\0')
        {
            if (argv[1][j] == argv[2][i])
                j++;
            i++;
        }
        i = 0;
        if (argv[1][j] == '\0')
        {
            while (argv[1][i] != '\0')
                write (1, &argv[1][i++], 1);
        }
    }
    write (1, "\n", 2);
    return (0);
}
#include <unistd.h>

int main(int argc, char **argv)
{
    int i;
    int j;

    if (argc > 1)
    {
        j = 0;
        i = 1;
        while (i < argc)
        {
            while (argv[i][j] != '\0')
            {
                if (argv[i][j] >= 'A' && argv[i][j] <= 'Z')
                    argv[i][j] += 32;
                if ((argv[i][j] == ' ' || argv[i][j] == '\t') && argv[i][j - 1] >= 'a' && argv[i][j - 1] <= 'z')
                    argv[i][j - 1] -= 32;
                j++;
            }
            if (argv[i][j] == '\0' && argv[i][j - 1] >= 'a' && argv[i][j - 1] <= 'z')
                argv[i][j - 1] -= 32;
            j = 0;
            while (argv[i][j] != '\0')
                write (1, &argv[i][j++], 1);
            if (argc - 1 != i)
                write (1, "\n", 1);
            j = 0;
            i++;
        }
    }
    write (1, "\n", 2);
    return (0);
}
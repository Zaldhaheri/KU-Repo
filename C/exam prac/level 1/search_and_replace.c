#include <unistd.h>

int main(int argc, char **argv)
{
    int i;

    i = 0;
    if (argc == 4)
    {
        if (argv[2][1] != '\0' || argv[3][1] != '\0')
        {
            write (1, "\n", 2);
            return (0);
        }
        else
        {
            while (argv[1][i] != '\0')
            {
                if (argv[1][i] == argv[2][0])
                {
                    argv[1][i] = argv[3][0];
                }
                write (1, &argv[1][i], 1);
                i++;
            }
        }
    }
    write (1, "\n.", 3);
    return (0);
}
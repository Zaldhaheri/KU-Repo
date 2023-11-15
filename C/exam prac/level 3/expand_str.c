#include <unistd.h>

int main(int argc, char **argv)
{
    int i;

    if (argc == 2)
    {
        i = 0;
        while (argv[1][i] != '\0' && (argv[1][i] == ' ' || argv[1][i] == '\t'))
            i++;
        while (argv[1][i] != '\0')
        {
            if (argv[1][i] == ' ' || argv[1][i] == '\t')
            {
                while (argv[1][i] != '\0' && (argv[1][i] == ' ' || argv[1][i] == '\t'))
                    i++;
                if (argv[1][i] == '\0')
                    break;
                write (1, "   ", 4);
            }
            write (1, &argv[1][i], 1);
            i++;
        }
    }
    write (1, ".\n", 2);
    return (0);
}
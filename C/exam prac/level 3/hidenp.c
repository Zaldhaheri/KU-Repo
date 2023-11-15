#include <unistd.h>

int main(int argc, char **argv)
{
    int i;
    int j;

    i = 0;
    j = 0;
    if (argc == 3)
    {
        if (argv[1][i] == '\0')
            write (1, "1", 2);
        else
        {
            while (argv[2][j] != '\0')
            {
                if (argv[1][i] == argv[2][j])
                    i++;
                j++;
            }
            if (argv[1][i] == '\0')
                write (1, "1", 2);
            else   
                write (1, "0", 2);
        }
    }
    write (1, "\n", 2);
    return (0);
}
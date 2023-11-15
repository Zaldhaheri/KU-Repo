#include <unistd.h>

int main(int argc, char **argv)
{
    int i;
    char c;

    i = 0;
    if (argc == 2)
    {
        while(argv[1][i] != '\0')
        {
            if ((argv[1][i] >= 'A' && argv[1][i] <= 'Z') ||
                (argv[1][i] >= 'a' && argv[1][i] <= 'z'))
            {
                c = argv[1][i];
                while ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
                {
                    write (1, &argv[1][i], 1);
                    c--;
                }
            }
            else   
                write (1, &argv[1][i], 1);
            i++;
        }
    }
    write (1, "\n", 2);
    return (0);
}
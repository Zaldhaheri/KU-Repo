#include <unistd.h>

void print_hex(int n)
{
    if (n >= 16)
        print_hex(n / 16);
    write (1, &"0123456789abcdef"[n % 16], 1);
}

int ft_atoi(char *str)
{
    int i;
    int r;
    int s;

    s = 1;
    r = 0;
    i = 0;
    while (str[i] != '\0' && (str[i] == ' ' && str[i] == '\t'))
        i++;
    if (str[i] == '+' || str[i] == '-')
    {
        if (str[i] == '-')
            s *= -1;
        i++;
    }
    while (str[i] != '\0' && str[i] >= '0' && str[i] <= '9')
    {
        r *= 10;
        r += str[i++] - '0';
    }
    return (r * s);
}

int main(int argc, char **argv)
{
    int num;

    if (argc == 2)
    {
        num = ft_atoi(argv[1]);
        if (num >= 0)
            print_hex(num);
    }
    write (1, "\n", 1);
    return (0);
}
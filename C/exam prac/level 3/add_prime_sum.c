#include <unistd.h>
#include <stdio.h>

int is_prime(int n)
{
    int i;

    i = 2;
    if (n == 1)
        return (0);
    if (n == 2)
        return (1);
    while (i <= n / i)
    {
        if (n % i == 0)
            return (0);
        i++;
    }
    return (1);
}

int ft_atoi(char *str)
{
    int i;
    int s;
    int r;

    i = 0;
    s = 1;
    r = 0;
    while (str[i] != '\0' && (str[i] == ' ' || (str[i] >= 9 && str[i] <= 13)))
        i++;
    if (str[i] == '-' || str[i] == '+')
    {
        if (str[i] == '-')
            s *= -1;
        i++;
    }
    while (str[i] != '\0' && str[i] >= '0' && str[i] <= '9')
    {
        r *= 10;
        r += str[i] - '0';
        i++;
    }
    return (r * s);
}

void ft_putnbr(int n)
{
    if (n >= 10)
        ft_putnbr(n / 10);
    write (1, &"0123456789"[n % 10], 1);
}

int main(int argc, char **argv)
{
    int num;
    int i;
    int r;

    r = 0;
    i = 1;
    if (argc == 2)
    {
        num = ft_atoi(argv[1]);
        if (num > 0)
        {
            while (i <= num)
            {
                if (is_prime(i) == 1)
                {
                    r += i;
                }
                i++;
            }
            ft_putnbr(r);
        }
        else
        {
            write (1,"0\n", 1);
            return (0);
        }
    }
    else
    {
        write (1,"0\n", 1);
        return (0);
    }
    write (1, "\n", 1);
    return (0);
}
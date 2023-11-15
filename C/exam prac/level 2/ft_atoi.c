#include <stdio.h>
#include <stdlib.h>

int ft_atoi(const char *str)
{
    int i;
    int s;
    int r;

    r = 0;
    s = 1;
    i = 0;
    while (str[i] != '\0' && (str[i] == ' ' || str[i] == '\t'))
        i++;
    if (str[i] == '-')
    {
        s *= -1;
        i++;
    }
    else if (str[i] == '+')
        i++;
    while (str[i] != '\0' && str[i] >= '0' && str[i] <= '9')
    {
        r *= 10;
        r += str[i++] - '0';
    }
    return (r * s);
}

int main()
{
    char *str = "-0000000202020";
    printf("%d\n%d", atoi(str), ft_atoi(str));
}
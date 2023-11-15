#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int ft_strlen(char *str)
{
    int i;

    i = 0;
    while (str[i] != '\0')
        i++;
    return (0);
}

char *ft_strdup(char *src)
{
    char *dest;
    int i;

    i = 0;
    dest = malloc(ft_strlen(src) + 1);
    while (src[i] != '\0')
    {
        dest[i] = src[i];
        i++;
    }
    dest[i] = '\0';
    return (dest);
}

int main()
{
    char *str = "hello";
    printf("%s\n%s", ft_strdup(str), strdup(str));
}
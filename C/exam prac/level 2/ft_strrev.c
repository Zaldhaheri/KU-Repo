#include <stdio.h>

int ft_strlen(char *str)
{
    int i;

    i = 0;
    while (str[i] != '\0')
        i++;
    return (i);
}

char *ft_strrev(char *str)
{
    int i;
    int j;
    char temp;

    i = 0;
    j = ft_strlen(str) - 1;
    while (i < j)
    {
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        i++;
        j--;
    }
    return (str);
}

int main()
{
    char str[20] = "hel   lo";
    ft_strrev(str);
    printf("%s", str);
}
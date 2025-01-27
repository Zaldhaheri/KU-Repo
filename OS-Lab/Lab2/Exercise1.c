#include <stdio.h>
#include <string.h>

int main()
{
    char str[10];
    if (fgets(str, sizeof(str), stdin) == NULL)
        return 1;
    if (str [strlen(str) - 1] != '\n')
        printf("Input too long\n");
    printf("str is %d\n", strlen(str));
    return 0;
}

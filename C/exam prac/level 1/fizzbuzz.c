#include <unistd.h>

int print_num(int n)
{
    if (n > 10)
        print_num(n / 10);
    write (1, &"0123456789"[n % 10], 1);
}

int main()
{
    int i;
    char num;

    num = '0';
    i = 1;
    while (i <= 100)
    {
        if (i % 15 == 0)
            write (1, "fizzbuzz", 9);
        else if (i % 3 == 0)
            write (1, "fizz", 5);
        else if (i % 5 == 0)
            write (1, "buzz", 5);
        else
            print_num(i);
        write (1, "\n", 2);
        i++;
    }
}
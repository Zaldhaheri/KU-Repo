#include <unistd.h>

int main()
{
    write (1, "z\n", 3);
    return (0);
}
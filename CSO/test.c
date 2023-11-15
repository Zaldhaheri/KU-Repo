long int simple_1(long int *x, long int y)
{
    long int t = *x + y;
    *x = t;
    return t;
}
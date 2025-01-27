#include <stdio.h>
#include <math.h>
#include <stdbool.h>

bool isArmStrong(int x)
{
    int n1, n2, n3;

    n1 = (x % 10);		// 00X
    n2 = (x / 10) % 10; // 0X0
	n3 = (x / 100);		// X00
	
	return ((pow(n1, 3) + pow(n2, 3) + pow(n3, 3)) == x);
}

int main()
{
    int num;

	printf("Please enter a positive 3-digit integer: ");
    scanf(" %d", &num);
    if (num < 0)
    {
        printf("Number should not be negative");
        return 0;
    }
    else if ((num < 100 || num > 999))
    {
        printf("Number should be a positive 3-digit integer");
        return (0);
    }
	if (isArmStrong(num))
		printf("%d is an armstrong number", num);
	else
		printf("%d is not an armstrong number", num);
	return 0;
}
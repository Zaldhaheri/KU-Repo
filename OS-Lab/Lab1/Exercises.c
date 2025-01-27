#include <stdio.h>

double	mtokm(double m)
{
	return (m/1000);
}

double	FtoC(double f)
{
	return ((f - 32) * 5 / 9);
}

int	main()
{
	printf("kilos: %f\n", mtokm(4500.5));
	printf("celsius: %f", FtoC(85.5));
}
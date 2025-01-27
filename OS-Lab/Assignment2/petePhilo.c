#include <stdio.h>
#include <stdlib.h>
#include "pthread.h"
#include <unistd.h>

#define NUM_PHILO 5
#define NUM_FORKS 5

#define COLOR_RESET   "\033[0m"
#define COLOR_RED     "\033[31m"
#define COLOR_GREEN   "\033[32m"
#define COLOR_YELLOW  "\033[33m"
#define COLOR_BLUE    "\033[34m"
#define COLOR_MAGENTA "\033[35m"
#define COLOR_CYAN    "\033[36m"

int turn;
int flag[NUM_PHILO];
int interested[NUM_PHILO];
void philosopher(void *arg) {
    int id = *(int *)arg;

    while (1) {
        interested[id] = 1;
        turn = id;
        while(turn == id && interested[(id + 1) % NUM_PHILO] == 1);

        flag[id] = 1;
        printf(COLOR_RED "Philosopher %d is thinking\n" COLOR_RESET, id);
        usleep(100);

        if (!flag[(id + 1) % NUM_PHILO] && !flag[(id + NUM_PHILO - 1) % NUM_PHILO]) {
            flag[id] = 0;
            printf(COLOR_YELLOW "Philosopher %d is eating\n" COLOR_RESET, id);
            usleep(10000);
            interested[id] = 0;
        } else {
            flag[id] = 0;
            interested[id] = 0;
            printf(COLOR_GREEN "Philosopher %d cannot eat now\n" COLOR_RESET, id);
            usleep(10000);
        }
        
    }
}


int main()
{
    pthread_t philosophers[NUM_PHILO];
    int ids[NUM_PHILO];

    for (int i = 0; i < NUM_FORKS; ++i) {
        flag[i] = 0;
        interested[i] = 0;
    }

    for (int i = 0; i < NUM_PHILO; ++i) {
        ids[i] = i;
        pthread_create(&philosophers[i], NULL, (void *(*)(void *))philosopher, &ids[i]);
    }

    for (int i = 0; i < NUM_PHILO; ++i) {
        pthread_join(philosophers[i], NULL);
    }

    return 0;
}
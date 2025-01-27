#include <stdio.h>
#include <stdlib.h>
#include "pthread.h"
#include <unistd.h>
#include <stdatomic.h>

#define NUM_PHILO 5
#define NUM_FORKS 5

#define COLOR_RESET   "\033[0m"
#define COLOR_RED     "\033[31m"
#define COLOR_GREEN   "\033[32m"
#define COLOR_YELLOW  "\033[33m"
#define COLOR_BLUE    "\033[34m"
#define COLOR_MAGENTA "\033[35m"
#define COLOR_CYAN    "\033[36m"

atomic_flag forks[NUM_PHILO] = {ATOMIC_FLAG_INIT};
atomic_flag lock = ATOMIC_FLAG_INIT;

void philosopher(void *arg) {
    int id = *(int *)arg;
    int left_fork = id;
    int right_fork = (id + 1) % NUM_PHILO;

    while (1) {
        printf(COLOR_RED "Philosopher %d is thinking\n" COLOR_RESET, id);
        usleep(100);
        
        while(atomic_flag_test_and_set(&lock));
        while(atomic_flag_test_and_set(&forks[left_fork]));
        printf(COLOR_BLUE "Philosopher %d got right fork %d\n" COLOR_RESET, id, right_fork);
        
        while(atomic_flag_test_and_set(&forks[right_fork]));
        printf(COLOR_MAGENTA "Philosopher %d got left fork %d\n" COLOR_RESET, id, left_fork);
        
        atomic_flag_clear(&lock);
        printf(COLOR_YELLOW "Philosopher %d is eating\n" COLOR_RESET, id);
        usleep(100000);

        
        atomic_flag_clear(&forks[left_fork]);
        atomic_flag_clear(&forks[right_fork]);
        printf(COLOR_GREEN "Philosopher %d put down forks %d and %d\n" COLOR_RESET, id, left_fork, right_fork);
    }
}


int main()
{
    pthread_t philosophers[NUM_PHILO];
    int ids[NUM_PHILO];

    for (int i = 0; i < NUM_FORKS; ++i) {
        atomic_flag_clear(&forks[i]);
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
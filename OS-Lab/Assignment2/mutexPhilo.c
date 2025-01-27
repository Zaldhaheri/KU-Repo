#include <stdio.h>
#include <stdlib.h>
#include "pthread.h"
#include "semaphore.h"
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

pthread_mutex_t forks[NUM_PHILO];
pthread_mutex_t lock;

void philosopher(void *arg) {
    int id = *(int *)arg;
    int left_fork = id;
    int right_fork = (id + 1) % NUM_PHILO;

    while (1) {
        printf(COLOR_RED "Philosopher %d is thinking\n" COLOR_RESET, id);
        usleep(100);
        
        pthread_mutex_lock(&lock);
        pthread_mutex_lock(&forks[right_fork]);
        printf(COLOR_BLUE "Philosopher %d got right fork %d\n" COLOR_RESET, id, right_fork);
        
        pthread_mutex_lock(&forks[left_fork]);
        printf(COLOR_MAGENTA "Philosopher %d got left fork %d\n" COLOR_RESET, id, left_fork);
        
        pthread_mutex_unlock(&lock);
        printf(COLOR_YELLOW "Philosopher %d is eating\n" COLOR_RESET, id);
        usleep(100000);

        
        pthread_mutex_unlock(&forks[left_fork]);
        pthread_mutex_unlock(&forks[right_fork]);
        printf(COLOR_GREEN "Philosopher %d put down forks %d and %d\n" COLOR_RESET, id, left_fork, right_fork);
    }
}


int main()
{
    pthread_t philosophers[NUM_PHILO];
    int ids[NUM_PHILO];

    for (int i = 0; i < NUM_FORKS; ++i) {
        pthread_mutex_init(&forks[i], NULL);
    }

    for (int i = 0; i < NUM_PHILO; ++i) {
        ids[i] = i;
        pthread_create(&philosophers[i], NULL, (void *(*)(void *))philosopher, &ids[i]);
    }

    for (int i = 0; i < NUM_PHILO; ++i) {
        pthread_join(philosophers[i], NULL);
    }

    for (int i = 0; i < NUM_FORKS; ++i) {
        pthread_mutex_destroy(&forks[i]);
    }

    return 0;
}
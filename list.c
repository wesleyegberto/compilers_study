#include <stdio.h>
#include <stdlib.h>

struct list {
  int head;
  struct list* tail;
};

typedef    struct list    List;

List* insert(List* xs, int x)
{
  List* ys = malloc(sizeof(List));
  ys->head = x;
  ys->tail = xs;
  return ys;
}

int length(List* xs)
{
  int n = 0;
  while (xs != NULL) {
    n = n+1;
    xs = xs->tail;
  }
  return n;
}

void main()
{
  List* xs = NULL;
  xs = insert(xs, 1);
  xs = insert(xs, 2);
  xs = insert(xs, 3);

  printf("Length: %i\n", length(xs));
}

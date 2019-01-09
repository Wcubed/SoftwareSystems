## 7.2
The menu is only drawn when the event dispatch thread notices an event related to it. However, the mandleThread that draws "underneath" the menu paints a new line every 20 milliseconds. Because a separate thread does the drawing, the menu isn't notified of the fact that it just got drawn over, and stays cut off, until a new menu event (like mouse over) causes it to be redrawn.

## 7.3
The drawing of the fractal now happens in the event dispatch thread.
Therefore, the window becomes unresponsive.

## 7.5
The `start` button only adds a ball to the panel. But does not call the `animate()` function, which is necessary to actually make things happen.

## 7.6
Can't remove the call to `animate()` from `Bounce`. That function is not called there.

## 7.9
The threads are talking through each other. Example output:

```
Thread B: Enter number 1: Thread A: Enter number 1: 3
Thread B: Enter number 2: 4
Thread A: Enter number 2: 5
Thread B: 3 + 5 = 8
6
Thread A: 4 + 6 = 10
```

First, both A and B ask for number 1, with A being the last one, but the `3` ends up with thread B. Then it looks like thread B asks for number 2, but the entered `4` get's passed to thread A as number 1.
This is because both threads are waiting for input with `readLine()`. The first to call `readLine()` is the one to receive the input. Even if the other thread sent an output prompt in between.

## 7.11
Only one thread at a time may now execute a `SyncConsole` function. But this does not say anything about the order in which numbers get asked:

```
Thread B: Enter number 1: 1
Thread A: Enter number 1: 2
Thread A: Enter number 2: 3
Thread B: Enter number 2: 4
Thread A: 2 + 3 = 5
Thread B: 1 + 4 = 5
```

Thread A can still interleave with thread B.

## 7.12
There is no difference. This because `synchronize` only works on a single instance of an object, and not between instances.

## 7.14
1. It means that you can acquire the lock, even if you already have it yourself.
   Two subsequent calls to `lock()` on the same lock, won't give any issue.
2. Yes.
3. You can lock over multiple functions at once. The lock can be given out in a fairer way. It offers a way to try to acquire the lock, and do something else if it is occupied.
4. A disadvantage is that one needs to make sure to call


## 7.16
The two producers are overwriting each other. Even if the number the first producer put in has not been read, the second producer can put in a number as well.
A number can be read multiple times, in the end the consumers keep reading the last number endlessly.

## 7.17
Here we need to use `notifyAll()`, because both the producers and consumers are listening at the same time. So calling `notify()` might wake up a consumer when we want a producer and vice-versa.

## 7.19
- Thread1 could read the balance, then thread2 could modify the balance, and then thread1 would override thread2's modification, resulting in a wrong end result.

- It would then use `new Thread(runnable);` I don't think the body of `MyThread` needs to be changed.
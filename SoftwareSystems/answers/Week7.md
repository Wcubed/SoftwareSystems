## 7.2
The menu is only drawn when the event dispatch thread notices an event related to it. However, the mandleThred that draws "underneath" the menu paints a new line every 20 milliseconds. The menu isn't notified of the fact that it just got drawn over, and stays cut off, until a new menu event (like mouse over) get's it to be redrawn.

## 7.3
The drawing of the fractal now happens in the event dispatch thread.
Therefore, the window becomes unresponsive.
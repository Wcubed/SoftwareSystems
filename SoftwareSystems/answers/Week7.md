## 7.2
The menu is only drawn when the event dispatch thread notices an event related to it. However, the mandleThread that draws "underneath" the menu paints a new line every 20 milliseconds. Because a separate thread does the drawing, the menu isn't notified of the fact that it just got drawn over, and stays cut off, until a new menu event (like mouse over) causes it to be redrawn.

## 7.3
The drawing of the fractal now happens in the event dispatch thread.
Therefore, the window becomes unresponsive.

## 7.5
The `start` button only adds a ball to the panel. But does not call the `animate()` function, which is necessary to actually make things happen.

## 7.6
Can't remove the call to `animate()` from `Bounce`. That function is not called there.
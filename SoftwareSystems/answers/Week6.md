## 6.9
The data based approach is the least costly.
The text approach is excessively wordy, as it sends full words where a character suffices. (e.g. "king" instead of "K").
The object based approach has additional overhead, like the `serialVersionUID`.

## 6.16
The way the responsibilities are separated means that if we wanted to change one of the components,
say we wanted to change the TUI to a GUI, we can do that with minimal hassle.
# JFrame-Windows

Consolidates various frame, component, and event listener classes into a single, easy-to-use class.
 * Use the {@link update} method to update the content of the screen with a new BufferedImage and to box up the most recent user input.  This should be called frequently in a loop.
 * Each time you update, the delta-time also updates.  {@link getDeltaTime} to get the number of seconds since the last update.  Useful for making things happen at a constant rate.
 * Then, use methods such as {@link getKey}, {@link getMouseX}, {@link getMouseButton}, and more to read in user input.

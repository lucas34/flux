# Flux

Simple implementation of a counter, highly inspired by the Facebook Flux architecture.

## Explanation

![Facebook flux](https://facebook.github.io/flux/img/flux-simple-f8-diagram-1300w.png)

In this case
* Store : Contains the counter state (value)
* Action : Possible actions such as "increment() and decrement()

The application displays two fragments side by side, the first will trigger actions base on user events and the second fragment will react. The counter on the right fragment is directly inside the fragment and the one on the right comes from the store. As you can see, they are keep showing the same number.

## Implementation
Basically, the view will trigger an invoke the increment() function from action module, the latter will send the event to the store via the dispatcher, the store will update his variables and send a notification to the UI that something as change.

## Plugins and side effects
According to the schema, the view should only react to the events emitted by the store. In this case the view can even react to anything. But It makes you the possibility to create plugin. I have a Logger plugin that will print on the console all the event that are triggered.

## Missing features

In the facebook's implementation, they disallow [Eventception](https://github.com/facebook/flux/blob/ac1e4970c2a85d5030b65696461c271ba981a2a6/src/Dispatcher.js#L184)

Flux allows you to have dependencies between store and wait for so actions to be executed first. So far, I haven't try to implement this such thing

## Conclusion
The concept is interesting. It may be a strong solution to do reactive programmation on a large scale. My concern is only if you trigger an action in a reaction to an event. You may be in a case of an infinity event loop, debugging with this kind of architecture could be a bit tricky.

[Lucas Nelaupe](https://github.com/ReactiveX/RxJava)


## Contributors

* [Lucas Nelaupe](http://www.lucas-nelaupe.fr/) - <https://github.com/lucas34>
* Feel free to contribute, All suggestions are welcome :-)

## License

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

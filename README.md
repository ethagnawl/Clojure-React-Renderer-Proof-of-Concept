# Clojure React Renderer Proof of Concept

## What am I looking at?

This was an experiment to see how plausible it would be to pre-render React.js
components using Clojure and Java 8's Nashorn JavaScript engine.

## ... and the verdict is?

Using the linked resources, it was no trouble getting this trivial example up
and running.

I was expecting the Java/Nashorn interop to be verbose and involve lots of
boilerplate, but with the help of a few utility functions I was able to build
up a nice API.  (e.g. `(react-render (sample-react-component data))`)

I'm anxiously awaiting the opportunity to use this stack in a non-trivial
application. I would recommend others give Clojure/Nashorn some thought before
defaulting to (node|io).js for their next "full-stack JavaScript application."
([Sorry, but I'm not bringing category theory into this
conversation.](https://en.wikipedia.org/wiki/Isomorphism))

## Where are the interesting bits?

You'll want to have a look at [renderer.clj](https://github.com/ethagnawl/Clojure-React-Renderer-Proof-of-Concept/blob/master/src/bad_movie_back_end/core/renderer.clj).

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running the application locally

To start a web server for the application, run:

    lein ring server

## Running the tests

    lein with-profile test midje

## Resources

- http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/

- http://augustl.com/blog/2014/jdk8_react_rendering_on_server/

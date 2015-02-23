(ns clojure-react-renderer-proof-of-concept.core.clojure-react-renderer-proof-of-concept-tests
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-react-renderer-proof-of-concept.core.handler :refer :all]))

(facts "Clojure React Renderer Proof of Concept Tests"
  (fact "Test GET request to / route returns expected string"
    (let [response (app (mock/request :get "/"))]
      (:status response) => 200
      (:body response) => (contains #"Hello, .+"))))

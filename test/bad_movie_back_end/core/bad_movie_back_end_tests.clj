(ns bad-movie-back-end.core.bad-movie-back-end-tests
  (:use midje.sweet)
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [bad-movie-back-end.core.handler :refer :all]
            ))

(facts "Bad Movie Poll Tests"
  (fact "Test GET request to / route returns expected string"
    (let [response (app (mock/request :get "/"))]
      (:status response) => 200
      (:body response) => (contains "HELLO FROM NASHORN"))))

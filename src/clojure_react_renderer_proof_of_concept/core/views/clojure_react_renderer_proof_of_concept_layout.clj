(ns clojure-react-renderer-proof-of-concept.core.views.clojure-react-renderer-proof-of-concept-layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common-layout [& body]
  (html5
    [:head
      [:title "Clojure React Renderer Proof of Concept"]]
    [:body
      [:div#app body]]))

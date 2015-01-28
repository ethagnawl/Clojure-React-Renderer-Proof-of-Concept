(ns bad-movie-back-end.core.views.bad-movie-back-end-layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common-layout [& body]
  (html5
    [:head
      [:title "Bad Movie Poll"]
      (include-css "/css/bad-movie-back-end.css")]
    [:body
      [:div#app body]]))

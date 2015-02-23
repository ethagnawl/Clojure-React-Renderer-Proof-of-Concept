(ns clojure-react-renderer-proof-of-concept.core.routes.clojure-react-renderer-proof-of-concept-routes

  (:require
    [compojure.core :refer :all]
    [clojure-react-renderer-proof-of-concept.core.renderer :refer [render]]))

(defn get-route [request] (render request))

(defroutes clojure-react-renderer-proof-of-concept-routes
           (GET  "/" [] get-route))



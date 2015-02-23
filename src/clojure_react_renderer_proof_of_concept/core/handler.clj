(ns clojure-react-renderer-proof-of-concept.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojure-react-renderer-proof-of-concept.core.routes.clojure-react-renderer-proof-of-concept-routes :refer [clojure-react-renderer-proof-of-concept-routes]]))

(defroutes app-routes
  (route/not-found "Not Found"))

(defn init [] "Off we go!")

(def app
  (-> (routes clojure-react-renderer-proof-of-concept-routes app-routes)
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))

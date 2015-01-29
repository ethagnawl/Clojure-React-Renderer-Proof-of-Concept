(ns bad-movie-back-end.core.routes.bad-movie-back-end-routes

  (:import [
            javax.script
            ScriptEngineManager])

  (:require
    [clojure.data.json :as json]
    [ring.util.response :as response]
    [compojure.core :refer :all]
    [bad-movie-back-end.core.renderer :refer [render]]))

(defn get-route [request] (render request))

(defroutes bad-movie-back-end-routes
           (GET  "/" [] get-route))


